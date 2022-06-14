package com.lc.exam00;

public class LC_0004 {

    public static void main(String[] args) {
        LC_0004 lc_0004 = new LC_0004();
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(lc_0004.findMedianSortedArrays(nums1, nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if (len == 0) {
            return 0;
        }
        int[] nums = new int[len];
        for (int i = 0, j = 0, k = 0; k < nums.length; k++) {
            if (i >= nums1.length) {
                nums[k] = nums2[j++];
            } else if (j >= nums2.length) {
                nums[k] = nums1[i++];
            } else if (nums1[i] <= nums2[j]) {
                nums[k] = nums1[i++];
            } else {
                nums[k] = nums2[j++];
            }
        }
        if (len % 2 == 0) {
            int index = len / 2;
            return (nums[index] + nums[index - 1]) / 2d;
        } else {
            int index = len / 2;
            return nums[index];
        }
    }

    // TODO: 用二分在实现一下
}
