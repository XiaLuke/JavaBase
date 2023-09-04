package cn.xf;

import java.util.Arrays;

/**
 * 对角线遍历
 * 给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。
 *
 * @author XF
 * @date 2023/06/14
 */
public class DiagonalTraversal {
    /**
     * m：数组长度
     * n：数组宽度
     * 二位数组遍历次数：m*n
     * 遍历的方向为向上和向下
     * 向上时，判断当前位置是否为上边界或者右边界
     * 上边界：当前位置行号是否为0
     * 有边界：当前位置是否为n-1
     * 其他位置：行号-1，列号+1
     * <p>
     * 向下时，判断当前位置是否为下边界或者左边界
     * 左边界：当前位置列号是否为0
     * 下边界：当前位置行号是否为m-1
     * 其他位置：列号-1，行号+1
     *
     * @param matrix 矩阵
     * @return {@link int[]}
     */
    public static int[] diagonalTraverse(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int count = m * n;
        int[] result = new int[count];
        int row = 0, col = 0, direction = 1;
        for (int i = 0; i < count; i++) {
            result[i] = matrix[row][col];
            if (direction == 1) {
                if (row == 0 && col != n - 1) { // 上边界
                    col++;
                    direction = -1;
                } else if (col == n - 1) { // 右边界
                    row++;
                    direction = -1;
                } else {
                    col++;
                    row--;
                }
            } else {
                if (col == 0 && row != m - 1) { // 左边界
                    row++;
                    direction = 1;
                } else if (row == m - 1) { // 下边界
                    col++;
                    direction = 1;
                } else {
                    col--;
                    row++;
                }
            }
        }
        return result;
    }
    public static int[] diagonalTraverse1(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int count = m * n;
        int[] result = new int[count];
        int row = 0, col = 0, direction = 1;
        for (int i = 0; i < m * n; i++) {
            result[i] = matrix[row][col];
            // 如果是向上遍历对角线
            if (direction == 1) {
                // 如果到达了上边界或者右边界，需要掉头向下
                if (col == n - 1) {
                    row++;
                    direction = -1;
                } else if (row == 0) {
                    col++;
                    direction = -1;
                } else {
                    row--;
                    col++;
                }
            }
            // 如果是向下遍历对角线
            else {
                // 如果到达了下边界或者左边界，需要掉头向上
                if (row == m - 1) {
                    col++;
                    direction = 1;
                } else if (col == 0) {
                    row++;
                    direction = 1;
                } else {
                    row++;
                    col--;
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] ints = diagonalTraverse(mat);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
    }
}
