package cn.xf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 重构 2 行二进制矩阵
 * <p>
 * <p>
 * 给你一个2行 n 列的二进制数组：
 * <p>
 * 矩阵是一个二进制矩阵，这意味着矩阵中的每个元素不是0就是1。
 * 第 0 行的元素之和为upper。
 * 第 1 行的元素之和为 lower。
 * 第 i 列（从 0 开始编号）的元素之和为colsum[i]，colsum是一个长度为n的整数数组。
 * 你需要利用upper，lower和colsum来重构这个矩阵，并以二维整数数组的形式返回它。
 * <p>
 * 如果有多个不同的答案，那么任意一个都可以通过本题。
 * <p>
 * 如果不存在符合要求的答案，就请返回一个空的二维数组。
 *
 * @author XF
 * @date 2023/06/29
 */
public class _1253 {
    /**
     * 重建矩阵
     *
     * @param upper  0行元素个数和
     * @param lower  1行元素个数和
     * @param colsum 提供数组
     * @return {@link List}<{@link List}<{@link Integer}>>
     */
    public static List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        // 首先，计算 colsum 数组中的元素和 sum，以及 colsum 中值为 2 的元素个数 two。sum 表示所有列元素之和，two 表示值为 2 的元素个数。
        int n = colsum.length;
        int sum = 0, two = 0;
        for (int i = 0; i < n; ++i) {
            if (colsum[i] == 2) {
                ++two;
            }
            sum += colsum[i];
        }
        // 如果 sum 不等于 upper + lower，或者最小值（Math.min）的 upper 和 lower 小于 two，即无法满足要求，那么返回一个空的列表（new ArrayList<List<Integer>>()），
        // 表示无法重构矩阵。
        if (sum != upper + lower || Math.min(upper, lower) < two) {
            return Collections.emptyList();
        }
        // 将 upper 和 lower 分别减去 two，表示已经确定了两行中值为 1 的元素个数。此时，upper 和 lower 分别表示还需要确定的值为 1 的元素个数。
        upper -= two; // 0行中为1的个数
        lower -= two; // 1行中为1的个数

        // 创建一个列表 res，用于存储重构后的二进制矩阵。列表 res 包含两个元素，每个元素都是一个列表（new ArrayList<Integer>()），表示矩阵的两行。
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 0; i < 2; ++i) {
            res.add(new ArrayList<Integer>());
        }
        // 遍历 colsum 数组
        for (int i = 0; i < n; ++i) {
            // 如果 colsum[i] 等于 2，表示该列的两个元素都为 1，分别将 1 添加到 res 的第一行和第二行。
            if (colsum[i] == 2) {
                res.get(0).add(1);
                res.get(1).add(1);
                // 如果 colsum[i] 等于 1，表示该列的一个元素为 1，另一个元素为 0，根据 upper 和 lower 的值进行判断：
            } else if (colsum[i] == 1) {
                // 如果 upper 大于 0，表示还可以在第一行添加一个值为 1 的元素，并减去相应的 upper；
                if (upper > 0) {
                    res.get(0).add(1);
                    res.get(1).add(0);
                    --upper;
                }
                // 否则，表示要在第二行添加一个值为 1 的元素，并减去相应的 lower。
                else {
                    res.get(0).add(0);
                    res.get(1).add(1);
                }
            }
            // 如果 colsum[i] 等于 0，表示该列的两个元素都为 0，分别将 0 添加到 res 的第一行和第二行。
            else {
                res.get(0).add(0);
                res.get(1).add(0);
            }
        }
        return res;
    }

    public static List<List<Integer>> solution(int upper, int lower, int[] colsum) {
        int sum = 0, numTowCount = 0;
        for (int item : colsum) {
            sum += item;
            if (item == 2) {
                numTowCount++;
            }
        }
        if (upper + lower != sum || Math.min(upper, lower) < numTowCount) {
            return Collections.emptyList();
        }
        upper -= numTowCount;
        lower -= numTowCount;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            res.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < colsum.length; i++) {
            if (colsum[i] == 2) {
                res.get(0).add(1);
                res.get(1).add(1);
            } else if (colsum[i] == 1) {
                if (upper != 0) {
                    res.get(0).add(1);
                    res.get(1).add(0);
                    upper--;
                } else {
                    res.get(0).add(0);
                    res.get(1).add(1);
                    lower--;
                }
            } else {
                res.get(0).add(0);
                res.get(1).add(0);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(solution(2, 3, new int[]{2, 2, 1, 1}));
    }
}
