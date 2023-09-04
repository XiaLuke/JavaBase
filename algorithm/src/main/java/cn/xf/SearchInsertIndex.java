package cn.xf;

public class SearchInsertIndex {
    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置
     *
     * @param nums
     * @param target
     * @return int
     */
    public static int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (target <= nums[i]) {
                return i;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
        int[] num = new int[]{1};
        int i = searchInsert(num, 0);
        System.out.println(i);
    }
}
