package com.exam.lk_04;

import java.util.*;

public class LK_0452 {

    public static void main(String[] args) {
        int[][] points1 = {{10,16},{2,8},{1,6},{7,12}};
        int[][] points2 = {{1,2},{3,4},{5,6},{7,8}};
        int[][] points3 = {{1,2},{2,3},{3,4},{4,5}};
        LK_0452 lk_0452 = new LK_0452();
        System.out.println(lk_0452.findMinArrowShots(points1));
        System.out.println(lk_0452.findMinArrowShots(points2));
        System.out.println(lk_0452.findMinArrowShots(points3));
    }

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            if (!set.contains(i)) {
                int l1 = points[i][0];
                int r1 = points[i][1];
                for (int j = i+1; j < points.length; j++) {
                    if (!set.contains(j)) {
                        int l2 = points[j][0];
                        int r2 = points[j][1];
                        if (l2 > r1 || r2 < l1) {
                            continue;
                        }
                        set.add(j);
                        l1 = Math.max(l1 , l2);
                        r1 = Math.min(r1 , r2);
                    }
                }
                set.add(i);
                res++;
            }
        }
        return res;
    }
}
