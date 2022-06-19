package com.exam.lk_10;

import java.util.LinkedList;
import java.util.Queue;

public class LK_1004 {

    public static void main(String[] args) {
        int[] nums1 = {1,1,1,0,0,0,1,1,1,1,0};
        int k1 = 2;
        int[] nums2 = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k2 = 3;
        LK_1004 lk_1004 = new LK_1004();
        System.out.println(lk_1004.longestOnes(nums1, k1));
        System.out.println(lk_1004.longestOnes(nums2, k2));
    }

    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int result = 0;
        Queue<Integer> queue = new LinkedList<>();
        while (left < nums.length && right < nums.length) {
            if (nums[right] == 1) {
                result = Math.max(result, right - left + 1);
                right++;
            } else if (k > 0) {
                result = Math.max(result, right - left + 1);
                queue.offer(right++);
                k--;
            } else if (!queue.isEmpty()) {
                left = queue.poll() + 1;
                k++;
            } else {
                right++;
                left = right;
            }
        }
        return result;
    }

    public int longestOnes2(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int result = 0;
        int temp = k;
        while (left < nums.length && right < nums.length) {
            if (nums[right] == 1) {
                result = Math.max(result, right - left + 1);
                right++;
            } else if (temp > 0 && k > 0) {
                result = Math.max(result, right - left + 1);
                right++;
                k--;
            } else if (temp > 0) {
                while (k == 0 && left < right) {
                    if (nums[left] == 0) {
                        k++;
                    }
                    left++;
                }
            } else {
                right++;
                left = right;
            }
        }
        return result;
    }

}
