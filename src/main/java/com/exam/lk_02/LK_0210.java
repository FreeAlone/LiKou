package com.exam.lk_02;

import com.exam.util.LK_Utils;

import java.util.*;

public class LK_0210 {

    public static void main(String[] args) {
        int numCourses1 = 2;
        int[][] prerequisites1 = {{1,0}};
        int numCourses2 = 4;
        int[][] prerequisites2 = {{1,0},{2,0},{3,1},{3,2}};
        int numCourses3 = 1;
        int[][] prerequisites3 = {};
        LK_0210 lk_0210 = new LK_0210();
        LK_Utils.printArr(lk_0210.findOrder(numCourses1, prerequisites1));
        LK_Utils.printArr(lk_0210.findOrder(numCourses2, prerequisites2));
        LK_Utils.printArr(lk_0210.findOrder(numCourses3, prerequisites3));
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> map = new HashMap<>();

        int[] ru = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            Set<Integer> set = map.getOrDefault(prerequisite[0], new HashSet<>());
            set.add(prerequisite[1]);
            map.put(prerequisite[0], set);
            ru[prerequisite[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < ru.length; i++) {
            if (ru[i] == 0) {
                queue.offer(i);
            }
        }
        int i = 0;
        int[] res = new int[numCourses];
        while (!queue.isEmpty()) {
            Integer temp = queue.poll();
            i++;
            res[numCourses - i] = temp;
            if (map.get(temp) != null) {
                for (Integer integer : map.get(temp)) {
                    ru[integer]--;
                    if (ru[integer] == 0) {
                        queue.offer(integer);
                    }
                }
            }
        }

        if (i == numCourses) {
            return res;
        }
        return new int[0];
    }
}
