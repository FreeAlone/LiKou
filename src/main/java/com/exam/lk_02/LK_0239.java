package com.exam.lk_02;

import com.exam.util.LK_Utils;
import javafx.util.Pair;

import java.util.Deque;
import java.util.LinkedList;

public class LK_0239 {

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] nums1 = {1};
        int k1 = 1;
        LK_0239 lk_0239 = new LK_0239();
        LK_Utils.printArr(lk_0239.maxSlidingWindow(nums, k));
        LK_Utils.printArr(lk_0239.maxSlidingWindow(nums1, k1));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Pair<Integer, Integer>> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && deque.peekLast().getValue() < nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(new Pair<>(i, nums[i]));
            if (i - k + 1 >= 0) {
                if (deque.peekFirst().getKey() == i - k) {
                    deque.pollFirst();
                }
                res[i - k + 1] = deque.peekFirst().getValue();
            }
        }
        return res;
    }
}
