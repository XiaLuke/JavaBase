package cn.xf.doublePointer;

public class MinArraySubLength {
    public static int solution(int[] nums,int target){
        int left = 0, right = 0;
        int sum = 0, minLen = Integer.MAX_VALUE;
        while (right < nums.length) {
            sum += nums[right];
            while (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,5,4,8,3,2,6,9};
        int solution = solution(nums, 7);
        System.out.println(solution);
    }
}
