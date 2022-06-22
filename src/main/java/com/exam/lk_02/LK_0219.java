package com.exam.lk_02;

import java.util.*;

public class LK_0219 {

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,1};
        int k1 = 3;
        int[] nums2 = {1,0,1,1};
        int k2 = 1;
        int[] nums3 = {1,2,3,1,2,3};
        int k3 = 2;
        LK_0219 lk_0219 = new LK_0219();
        System.out.println(lk_0219.containsNearbyDuplicate(nums1, k1));
        System.out.println(lk_0219.containsNearbyDuplicate(nums2, k2));
        System.out.println(lk_0219.containsNearbyDuplicate(nums3, k3));
    }


    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Set<Integer> set = map.getOrDefault(nums[i], new HashSet<>());
            set.add(i);
            map.put(nums[i], set);
        }
        for (Integer integer : map.keySet()) {
            Set<Integer> set = map.getOrDefault(integer, new HashSet<>());
            if (set.size() > 1) {
                Integer[] array = set.toArray(set.toArray(new Integer[0]));
                for (int i = 0; i < array.length; i++) {
                    for (int j = i + 1; j < array.length; j++) {
                        if (!Objects.equals(array[i], array[j]) && Math.abs(array[i] - array[j]) <= k) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
