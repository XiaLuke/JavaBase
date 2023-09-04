package cn.xf;

import java.util.Arrays;

/**
 * 火柴拼正方形
 * <p>
 * 你将得到一个整数数组 matchsticks ，其中 matchsticks[i] 是第 i个火柴棒的长度。你要用 所有的火柴棍拼成一个正方形。
 * 你 不能折断 任何一根火柴棒，但你可以把它们连在一起，而且每根火柴棒必须 使用一次 。
 * 如果你能使这个正方形，则返回 true ，否则返回 false 。
 *
 * @author XF
 * @date 2023/06/25
 */
public class _473 {
    public static boolean solution(int[] nums) {
        if (nums == null || nums.length < 4) {
            return false; // 火柴数不足
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 4 != 0) {
            return false; // 不能等分成 4 段
        }

        int[] side = new int[4];
        Arrays.sort(nums); // 从长到短排序
        return backtrack(nums, side, nums.length - 1, sum / 4); // 从末尾开始回溯
    }

    /**
     * 回溯
     *
     * @param nums   数据
     * @param side   四条边
     * @param pos    剩余根数
     * @param target 最大长度
     * @return boolean
     */
    private static boolean backtrack(int[] nums, int[] side, int pos, int target) {
        if (pos == -1) { // 所有火柴都已经拼完
            return side[0] == side[1] && side[1] == side[2] && side[2] == side[3]; // 四条边长度相等
        }

        for (int i = 0; i < 4; i++) { // 尝试将 nums[pos] 放入边 i 中
            if (side[i] + nums[pos] > target) { // 加入该火柴棒后超过了该边的长度限制
                continue;
            }
            side[i] += nums[pos]; // 尝试加入该火柴棒
            if (backtrack(nums, side, pos-1, target)) { // 递归尝试组成下一条边
                return true;
            }
            side[i] -= nums[pos]; // 回溯到上一次状态，取消加入该火柴棒的操作
        }
        return false;
    }

    public static void main(String[] args) {
        int[] num = new int[]{1,1,1,1,2,2};
        int[] nums = new int[4];
        boolean solution = solution(num);
    }
}
