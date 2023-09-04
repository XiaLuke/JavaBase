package cn.xf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 四数之和
 *
 * @author XF
 * @date 2023/06/26
 */
public class _18FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);  // 排序
        List<List<Integer>> result = new ArrayList<>();
        // 在后面的循环中寻找四个数的和，至少需要四个位置才能找齐，因此 i 最多只能取到倒数第四个位置
        // 最后三个数据不进行遍历，因为无法构成四个数
        for (int i = 0; i < n - 3; i++) {
            // 如果有需要可保留重复的数据，可去掉
            if (i > 0 && nums[i] == nums[i - 1]) {  // 跳过重复的数
                continue;
            }
            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if ((long) nums[i] + nums[n - 3] + nums[n - 2] + nums[n - 1] < target) {
                continue;
            }
            // 找到四个数中的第二个数
            // j = i + 1，之前的数据已经使用过，从下一位开始
            // j < n - 2，至少需要四个数来满足四元组，在当前循环中，最小的数可能为j，j+1，j+2，最大能取到第n-3位，保证至少留下两个位置来计算四个数之和
            // 如果第二个位置取到了倒数第二个位置，最后一个数无法构成四元组，
            for (int j = i + 1; j < n - 2; j++) {
                // 如果有需要可保留重复的数据，可去掉
                if (j > i + 1 && nums[j] == nums[j - 1]) {  // 跳过重复的数
                    continue;
                }
                if ((long) nums[i] + nums[j] + nums[j+1] + nums[j+2] > target) {
                    break;
                }
                if ((long) nums[i] + nums[j] + nums[n - 2] + nums[n - 1] < target) {
                    continue;
                }
                int left = j + 1, right = n - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;
                        while (left < right && nums[left] == nums[left - 1]) {  // 跳过重复的数
                            left++;
                        }
                        while (left < right && nums[right] == nums[right + 1]) {  // 跳过重复的数
                            right--;
                        }
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // -3，-2，-1，0，0，1，2，2，2
//        int[] num = new int[]{1, 0, -1, 0, -2, 2, 2, -3,2};
        int[] num = new int[]{1000000000,1000000000,1000000000,1000000000};
        List<List<Integer>> lists = fourSum(num,
        -294967296);
        System.out.println(lists);
    }

}


