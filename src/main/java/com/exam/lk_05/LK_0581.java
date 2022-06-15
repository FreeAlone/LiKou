package com.exam.lk_05;

public class LK_0581 {

    public static void main(String[] args) {
        LK_0581 LK_0581 = new LK_0581();
        int[] nums = new int[] {2,6,4,8,10,9,15};
//        int[] nums = new int[] {1,2,3,4};
//        int[] nums = new int[] {1};
        System.out.println(LK_0581.findUnsortedSubarray(nums));
    }

    public int findUnsortedSubarray(int[] nums) {
        int left = 0;
        int right = - 1;
        int min = nums[nums.length - 1];
        int max = nums[0];
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] < max) {
                right = i;
            } else {
                max = nums[i];
            }
            if (nums[nums.length - i - 1] > min) {
                left = nums.length - i - 1;
            } else {
                min = nums[nums.length - i - 1];
            }
        }
        return right - left + 1;
    }

}
