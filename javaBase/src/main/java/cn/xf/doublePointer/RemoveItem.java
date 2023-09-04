package cn.xf.doublePointer;

/**
 * 删除项目
 * 循环遍历整个数组，对于每个遍历到的元素，如果它等于目标值 val，
 * 那么我们就将 fast 指向下一个元素，即不进行任何操作。反之，如果这个元素不等于 val，
 * 那么我们就将其存放到 slow 指向的位置，并令 slow 和 fast 指针都向右移动一位。
 * 当 fast 指针遍历到数组末尾时，slow 指针指向的位置就是修改后的数组的末尾位置，我们只需要返回 slow 即可。
 *
 * 这样，我们就可以在不使用额外空间的情况下，完成对原数组的原地修改。时间复杂度为O(n)，空间复杂度为O(1)。
 *
 * @author XF
 * @date 2023/06/16
 */
public class RemoveItem {
    public static int removeElement(int[] nums, int val) {
        int i = 0, j = 0;
        for(;j<nums.length;j++){
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        for (int num : nums) {
            System.out.print(num+" ");
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,2,3};
        int i = removeElement(nums, 3);
        System.out.println("\n"+i);

    }
}
