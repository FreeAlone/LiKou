package com.lc.exam00;

/**
 * 二分查找
 */
public class LC_0033 {

    public static void main(String[] args) {
        LC_0033 lc_0033 = new LC_0033();
//        int[] nums = {4,5,6,7,0,1,2};
//        int target = 0;
//        int[] nums = {4,5,6,7,0,1,2};
//        int target = 3;
        int[] nums = {1};
        int target = 0;
        System.out.println(lc_0033.search(nums, target));
    }

    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return target == nums[0] ? 0 : -1;
        }
        int base = nums[0];
        int left = -1;
        int right = nums.length;
        while (left + 1 != right) {
            int mid = (left + right) / 2;
            if (nums[mid] < base) {
                right = mid;
            } else {
                left = mid;
            }
        }
        int l1 = -1;
        int r1 = right;

        int l2 = right - 1;
        int r2 = nums.length;
        if (right < nums.length) {
            if (nums[l1 + 1] > target && nums[r1 - 1] < target && nums[l2 + 1] > target && nums[r2 - 1] < target) {
                return -1;
            }
        } else if (nums[l1 + 1] > target && nums[r1 - 1] < target) {
            return -1;
        }
        if (right < nums.length && nums[r2 - 1] >= target) {
            // 2
            if (l2 + 1 == r2 - 1) {
                return nums[l2 + 1] == target ? l2 + 1 : -1;
            }
            while (l2 + 1 != r2) {
                int m2 = (l2 + r2) / 2;
                if (nums[m2] > target) {
                    r2 = m2;
                } else {
                    l2 = m2;
                }
            }
            return nums[l2] == target ? l2 : -1;
        } else {
            // 1
            if (0 == r1 - 1) {
                return nums[l1 + 1] == target ? 0 : -1;
            }
            while (l1 + 1 != r1) {
                int m1 = (l1 + r1) / 2;
                if (nums[m1] > target) {
                    r1 = m1;
                } else {
                    l1 = m1;
                }
            }
            return l1 > -1 && nums[l1] == target ? l1 : -1;
        }
    }
}
