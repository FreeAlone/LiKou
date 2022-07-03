package com.exam.lk_02;

import java.util.*;

public class LK_0207 {

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1,0}};

        int numCourses1 = 2;
        int[][] prerequisites1 = {{1,0},{0,1}};

        LK_0207 lk_0207 = new LK_0207();
        System.out.println(lk_0207.canFinish(numCourses, prerequisites));
        System.out.println(lk_0207.canFinish(numCourses1, prerequisites1));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] degree = new int[numCourses];
        TreeMap<Integer, Set<Integer>> preMap = new TreeMap<>();
        for (int[] prerequisite : prerequisites) {
            degree[prerequisite[0]] += 1;
            Set<Integer> set = preMap.getOrDefault(prerequisite[1], new HashSet<>());
            set.add(prerequisite[0]);
            preMap.put(prerequisite[1], set);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
            }
        }
        Set<Integer> study = new HashSet<>();
        while (!queue.isEmpty()) {
            Integer courses = queue.poll();
            study.add(courses);
            Set<Integer> set = preMap.getOrDefault(courses, new HashSet<>());
            for (Integer integer : set) {
                degree[integer] -= 1;
                if (degree[integer] == 0) {
                    queue.offer(integer);
                }
            }
        }
        return study.size() == numCourses;
    }

}
