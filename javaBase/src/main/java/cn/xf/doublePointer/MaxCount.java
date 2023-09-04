package cn.xf.doublePointer;

/**
 * 最大计数
 * 使用双指针的思路来解决。我们设定两个指针 left 和 right，initially left 指向数组的第一个元素，right 指向数组的第一个 0 的位置。
 * <p>
 * 然后，我们循环遍历整个数组，对于每个遍历到的元素，如果它等于 1，那么我们就将 right 指针向右移动一位。反之，如果这个元素等于 0，
 * 那么我们就可以得到一个长度为 right-left 的连续 1 的序列，我们可以将这个长度与当前最大长度进行比较，如果它比当前最大长度要大，
 * 那么就更新最大长度并继续遍历数组。
 * <p>
 * 当 left 指针遍历到右边界时，我们就完成了对数组的遍历。时间复杂度为 O(n)，空间复杂度为 O(1)。
 *
 * @author XF
 * @date 2023/06/16
 */
public class MaxCount {
    public static int solution(int[] nums, int val) {
        int left = 0, right = 0, maxCount = 0;
        for (int i = 0; i < nums.length; i++) {
            // 相等，右指针向右移动一位
            if (nums[i] == val) {
                right++;
            } else {
                // 不等时，得到一个数量为right-left的结果
                maxCount = Math.max(maxCount, right - left);
                // 将指针重置位置
                left = right - 1;
                right = left;
            }
        }
        //
        return Math.max(maxCount, right - left);
    }

    public static int solution2(int[] nums, int val) {
        int left = 0, right = 0, maxCount = 0;
        while (right < nums.length) {
            if (nums[right] != val) {
                left = right;
            }
            maxCount = Math.max(maxCount, right - left);
            right++;
        }
        return maxCount;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 5, 6, 2, 2, 2, 7, 5, 8, 9, 2, 2, 1, 4, 2, 2, 2, 2, 2};
        int count = solution2(nums, 2);
        System.out.println(count);
    }
}
