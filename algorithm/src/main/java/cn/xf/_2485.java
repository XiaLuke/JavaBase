package cn.xf;

/**
 * 找出中枢数
 * 给你一个正整数 n ，找出满足下述条件的 中枢整数 x ：
 * <p>
 * 1 和 x 之间的所有元素之和等于 x 和 n 之间所有元素之和。
 * 返回中枢整数 x 。如果不存在中枢整数，则返回 -1 。题目保证对于给定的输入，至多存在一个中枢整数
 *
 * @author XF
 * @date 2023/06/26
 */
public class _2485 {
    public static int solution(int n) {
        // 总和
        int total = (n + 1) * n / 2;
        // 左边和与右边和
        int leftSum = 0, rightSum = 0;
        for (int i = 0; i < n; i++) {
            rightSum = total - leftSum - i;
            if (rightSum == leftSum && leftSum + rightSum + i == total) {
                return i;
            }
            leftSum += i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int solution = solution(8);
        System.out.println(solution);
    }
}
