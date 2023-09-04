package cn.xf.doublePointer;

import java.util.Arrays;

/**
 * 最小数量船
 * <p>
 * 给定数组people。people[i]表示第 i个人的体重，船的数量不限，每艘船可以承载的最大重量为limit。
 * 每艘船最多可同时载两人，但条件是这些人的重量之和最多为limit。
 * 返回 承载所有人所需的最小船数。
 *
 * @author XF
 * @date 2023/06/25
 */
public class LimitShip {
    public static int limitShip(int[] request, int limit) {
        Arrays.sort(request);
        int leftPoint = 0, rightPoint = request.length - 1,result = 0;
        while (leftPoint <= rightPoint) {
            int count = request[leftPoint] + request[rightPoint];
            if (count > limit) {
                rightPoint--;
            }
            if (count <= limit) {
                leftPoint++;
                rightPoint--;
            }
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] re = new int[]{1,5,8,6,9,3,1,5,4,1,1};
        int i = limitShip(re, 9);
        System.out.println(i);
    }
}
