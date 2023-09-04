package cn.xf;

import java.util.Arrays;

public class _1 {
    public static int[] twoSum(int[] nums, int target) {
//        Arrays.sort(nums);
        int leftPoint =0,rightPoint=nums.length-1,length = nums.length-1;
        int[] result = new int[2];
        for(int i =length;i>=0;i--){
            if(nums[rightPoint]>target){
                rightPoint--;
                continue;
            }
            int count = nums[rightPoint]+nums[leftPoint];
            if(count>target){
                rightPoint--;
            }
            if(count<target){
                leftPoint++;
            }
            if(count==target){
                result[0]=leftPoint;
                result[1]=rightPoint;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        int[] num = new int[]{3,2,4};
        twoSum(num,6);
    }
}
