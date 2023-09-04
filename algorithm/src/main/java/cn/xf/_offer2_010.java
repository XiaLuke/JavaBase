package cn.xf;

import java.util.HashMap;
import java.util.Map;

/**
 * 和为 k 的子数组
 *
 * 给定一个整数数组和一个整数 k ，请找到该数组中和为 k 的连续子数组的个数。
 *
 * @author XF
 * @date 2023/06/29
 */
public class _offer2_010 {
    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; ++start) {
            int sum = 0;
            for (int end = start; end >= 0; --end) {
                sum += nums[end];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }
    public static int subarraySum3(int[] nums, int k) {
        int cnt = 0, length = nums.length;
        int[] sums = new int[length + 1];
        //遍历得到前缀和数组
        for (int i = 1; i <= length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        Map<Integer, Integer> map = new HashMap<>(nums.length*4);
        for (int pre: sums) {
            Integer c = map.get(pre - k);
            if (c != null) {
                cnt += c;//i代表结束点，pre-k前缀和的数量代表子数组起点的数量
            }
            map.merge(pre, 1, Integer::sum);
        }
        return cnt;
    }

    public static int subarraySum2(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // 初始化，表示累计和为0的情况出现了1次
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k); // 更新count
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1); // 更新累计和的次数
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum2(new int[]{1, 1, 1}, 2));
    }
}
