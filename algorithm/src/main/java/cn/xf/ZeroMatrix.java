package cn.xf;

import java.util.Arrays;

/**
 * 零矩阵
 * 若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 *
 * @author XF
 * @date 2023/06/14
 */
public class ZeroMatrix {
    public static int[][] clearZero(int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        boolean[] col = new boolean[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 0){
                    // 记录当前位置
                    row[i] = true;
                    col[j] =true;
                }
            }
        }
        for (int i = 0; i < row.length; i++) {
            for (int j = 0; j < col.length; j++) {
                if(row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        /*
        * 1,2,3
        * 4,6,0
        * 5,2,0
        * */
        int[][] arr = {{1,2,3},{4,6,0},{5,2,0}};
        int[][] ints = clearZero(arr);
        System.out.println(Arrays.deepToString(ints));
    }
}
