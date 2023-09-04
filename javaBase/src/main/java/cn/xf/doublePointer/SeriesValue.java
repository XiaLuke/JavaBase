package cn.xf.doublePointer;

/**
 * 系列价值
 * 给你一个下标从 0 开始的整数数组nums 。
 * <p>
 * 现定义两个数字的 串联是由这两个数值串联起来形成的新数字。
 * <p>
 * 例如，15和49的串联是1549 。
 * nums的 串联值最初等于 0 。执行下述操作直到nums变为空：
 * <p>
 * 如果nums中存在不止一个数字，分别选中 nums 中的第一个元素和最后一个元素，将二者串联得到的值加到nums的 串联值 上，然后从nums中删除第一个和最后一个元素。
 * 如果仅存在一个元素，则将该元素的值加到nums 的串联值上，然后删除这个元素。
 * 返回执行完所有操作后nums 的串联值。
 *
 * @author XF
 * @date 2023/06/19
 */
public class SeriesValue {
    public static long solution2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0, right = nums.length - 1;
        long count = 0;
        StringBuilder sb = new StringBuilder();
        if (nums.length == 1) {
            return nums[left];
        }
        for (int i = 0; i < nums.length; i++) {
            if (left == right) {
                count += nums[left];
                return count;
            }
            if (left < right) {
//                sb = sb.append(nums[left]).append(nums[right]);
                String s = sb.append(nums[left]).append(nums[right]).toString();
                count += Integer.parseInt(s);
                left++;
                right--;
            }
        }
        return count;
    }
    public static long solution3(int[] nums){
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        long concVal = 0;
        StringBuilder concValStr = new StringBuilder();
        if (nums.length == 1) {
            // nums 中只有一个元素，那么该元素即为串联值，直接返回
            return concVal += nums[left];
        }
        while (left < right) {
            // 拼接-计算串联值

            concVal += Integer.parseInt(concValStr.append(nums[left]).append(nums[right]).toString());
            left++;
            right--;
            // 遍历完，如果 nums 中剩余单独一个元素，即左右指针相等时，继续将其累加到串联值中
            if (left == right) {
                concVal += nums[left++];
            }
        }
        return concVal;
    }

    public static long solution1(int[] nums) {
        int left = 0, right = nums.length - 1;
        long count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (left == right) {
                count += nums[left];
                return count;
            }
            if (left < right) {
                String num = nums[left] + "" + nums[right];
                left++;
                right--;
                count = Math.addExact(count, Long.valueOf(num));
            }
        }
        return count;
    }

    public static void main(String[] args) {
        long theArrayConcVal = solution2(new int[]{1021, 2021, 52101201, 522411001, 2101120});
        System.out.println(theArrayConcVal);
    }
}
