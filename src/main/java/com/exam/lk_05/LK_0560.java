package com.exam.lk_05;

import java.util.HashMap;

public class LK_0560 {

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 1};
        int k1 = 2;
        int[] nums2 = {1, 2, 3};
        int k2 = 3;
        LK_0560 lk_0560 = new LK_0560();
        System.out.println(lk_0560.subarraySum(nums1, k1));
        System.out.println(lk_0560.subarraySum1(nums2, k2));
    }

    public int subarraySum(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }

    public int subarraySum1(int[] nums, int k) {
        int[] prefixSum = new int[nums.length + 1];
        prefixSum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < prefixSum.length; j++) {
                if (prefixSum[j] - prefixSum[i] == k) {
                    res++;
                }
            }
        }
        return res;
    }
}
