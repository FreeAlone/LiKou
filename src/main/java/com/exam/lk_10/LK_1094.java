package com.exam.lk_10;

import java.util.HashMap;
import java.util.Map;

public class LK_1094 {

    public static void main(String[] args) {
        int[][] trips1 = {{2,1,5},{3,3,7}};
        int capacity1 = 4;
        int[][] trips2 = {{2,1,5}, {3,3,7}};
        int capacity2 = 5;
        LK_1094 lk_1094 = new LK_1094();
        System.out.println(lk_1094.carPooling(trips1, capacity1));
        System.out.println(lk_1094.carPooling1(trips2, capacity2));

    }

    public boolean carPooling(int[][] trips, int capacity) {
        int[] diff = new int[1001];
        for (int[] trip : trips) {
            diff[trip[1]] += trip[0];
            if (trip[2] < diff.length) {
                diff[trip[2]] -= trip[0];
            }
        }
        //先单独判断diff[0]是否超载
        if (diff[0] > capacity) return false;
        for (int i = 1; i < diff.length; i++) {
            diff[i] += diff[i - 1];
            if (diff[i] > capacity) {
                return false;
            }
        }
        return true;
    }

    public boolean carPooling1(int[][] trips, int capacity) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] trip : trips) {
            int num = trip[0];
            int from = trip[1];
            int to = trip[2];
            while (from < to) {
                Integer temp = map.getOrDefault(from, capacity);
                temp -= num;
                if (temp < 0) {
                    return false;
                }
                map.put(from, temp);
                from++;
            }
        }
        return true;
    }
}
