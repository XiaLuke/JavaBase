package cn.xf.doublePointer;

public class SumOfTwoNumbers {
    public static int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            int temp = numbers[i] + numbers[j];
            if (target == temp) {
                return new int[]{i + 1, j + 1};
            } else if (target < temp) {
                j--;
            } else {
                i++;
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 4, 6, 7, 9, 11, 33, 45, 67};
        int[] ints = twoSum(nums, 54);
        System.out.println(ints[0]);
        System.out.println(ints[1]);
    }
}
