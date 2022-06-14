package com.lc.exam07;

import java.util.Stack;

/**
 * 单调栈
 */
public class LC_0739 {
    public static void main(String[] args) {
        int[] temperatures  = {30,60,90};
        LC_0739 lc_0739 = new LC_0739();
        int[] result = lc_0739.dailyTemperatures(temperatures);
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }
        return result;
    }
}
