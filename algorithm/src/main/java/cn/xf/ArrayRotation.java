package cn.xf;

import java.util.Arrays;

/**
 * 阵列旋转
 *
 * @author XF
 * @date 2023/06/14
 */
public class ArrayRotation {
    /**
     * 二维数组旋转时，根据旋转度数不同
     * b[i][j]=a[n-j][i];  //顺时针旋转90 度
     * c[i][j]=a[n-i][n-j]; //顺时针旋转180度
     * d[i][j]=a[j][n-i];   //顺时针旋转270度
     * n为数组下标最大值
     * 这段代码实现了二维数组的顺时针旋转90度的功能。它使用了一个新的二维数组result，
     * 并通过两个嵌套的循环遍历原数组arr中的每个元素，将它放入新数组result中旋转后的位置中。
     *
     * 具体来说，第一个循环遍历的是arr中的行，而第二个循环遍历的是arr中当前行的列。
     * 对于arr中的arr[i][j]元素，旋转后应该位于result的位置result[j][length-1-i]。
     * 因此，通过计算这个位置的行坐标和列坐标，就可以将原数组中的元素放入新数组中。
     *
     * 需要注意的是，由于矩阵顺时针旋转90度后，行和列的数量都是相等的，
     * 因此新数组result的维度与原数组arr的维度相同。
     *
     * @param arr 二维数组
     * @param num 旋转度数
     * @return {@link int[][]}
     */
    public static int[][] rotation(int[][] arr, int num) {
        int length = arr.length;
        int maxIndex = length - 1;
        int[][] result = new int[length][length];
        if (num == 90) {
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    // 旋转结果错误：矩阵的顺时针旋转90度的操作不是按列交换，
                    // 而是按行交换。对于原数组arr中的一个元素arr[i][j]，旋转90度后它应该位于矩阵的(j, N-i-1)位置，其中N为矩阵的宽度。
//                    result[i][j] = arr[maxIndex - j][i];
                    // 修复后
                    result[j][maxIndex - i] = arr[i][j];
                }
            }
        }
        if (num == 180) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
//                    result[i][j] = arr[maxIndex - i][maxIndex - j];
                    result[maxIndex - i][maxIndex - j] = arr[i][j];
                }
            }
        }
        if (num == 270) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    result[i][j] = arr[j][maxIndex - i];
                    result[j][maxIndex - i] = arr[i][j];

                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        int[][] arr = {{1, 2, 4, 5, 7}, {3, 2, 7, 4, 6}, {5, 8, 4, 2, 9}, {7, 0, 9, 1, 4}, {8, 4, 2, 6, 1}};
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] rotation = rotation(arr, 180);
        System.out.println(Arrays.deepToString(rotation));
    }

}
