package cn.xf;

public class SearchArrayCenter {

    /**
     * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
     *
     * @param nums
     * @return int
     */
    public static int pivotIndex(int[] nums) {
        int sum = 0;
        // 求总和
        for (int item : nums) {
            sum += item;
        }
        // 从左边遍历数的总和
        int leftIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            sum -= nums[i];
            if (leftIndex == sum) {
                return i;
            }
            leftIndex += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] generate = new int[]{1,6,8,4,4,0,8,0,3,9,3,8,6,1};
        int i = pivotIndex(generate);
        System.out.println(i);
    }
}

