package com.exam.lk_02;

public class LK_0209 {

    public static void main(String[] args) {
        int target0 = 213;
        int[] nums0 = {12,28,83,4,25,26,25,2,25,25,25,12};
        int target1 = 7;
        int[] nums1 = {2,3,1,2,4,3};
        int target2 = 4;
        int[] nums2 = {1,4,4};
        int target3 = 11;
        int[] nums3 = {1,1,1,1,1,1,1,1};
        LK_0209 lk_0209 = new LK_0209();
        System.out.println(lk_0209.minSubArrayLen(target0, nums0));
        System.out.println(lk_0209.minSubArrayLen(target1, nums1));
        System.out.println(lk_0209.minSubArrayLen(target2, nums2));
        System.out.println(lk_0209.minSubArrayLen(target3, nums3));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int result = Integer.MAX_VALUE;
        int sum = 0;
        while (left < nums.length && right < nums.length) {
            sum += nums[right];
            while (sum >= target) {
                result = Math.min(result, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;

        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
