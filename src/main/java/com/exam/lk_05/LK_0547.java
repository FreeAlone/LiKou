package com.exam.lk_05;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class LK_0547 {

    public static void main(String[] args) {
        int[][] isConnected1 = {{1,1,0},{1,1,0},{0,0,1}};
        int[][] isConnected2 = {{1,0,0},{0,1,0},{0,0,1}};
        int[][] isConnected3 = {{1,0,0,1},{0,1,1,0}, {0,1,1,1},{1,0,1,1}};
        int[][] isConnected4 = {{1,1,0,0,0,0,0,1,0,0,0,0,0,0,0},{1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,1,0,1,1,0,0,0,0,0,0,0,0},{0,0,0,0,1,0,0,0,0,1,1,0,0,0,0},{0,0,0,1,0,1,0,0,0,0,1,0,0,0,0},{0,0,0,1,0,0,1,0,1,0,0,0,0,1,0},{1,0,0,0,0,0,0,1,1,0,0,0,0,0,0},{0,0,0,0,0,0,1,1,1,0,0,0,0,1,0},{0,0,0,0,1,0,0,0,0,1,0,1,0,0,1},{0,0,0,0,1,1,0,0,0,0,1,1,0,0,0},{0,0,0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,1,0,1,0,0,0,0,1,0},{0,0,0,0,0,0,0,0,0,1,0,0,0,0,1}};

        LK_0547 lk_0547 = new LK_0547();
//        System.out.println(lk_0547.findCircleNum(isConnected1));
//        System.out.println(lk_0547.findCircleNum(isConnected2));
        System.out.println(lk_0547.findCircleNum(isConnected3));
//        System.out.println(lk_0547.findCircleNum(isConnected4));
    }

    int[] parent;

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = i + 1; j < isConnected[i].length; j++) {
                if (isConnected[i][j] == 1) {
                    union(i, j);
                }
            }
        }
        int p = 0;
        for (int i = 0; i < n; i++) {
            if (i == parent[i]) {
                System.out.println(parent[i]);
                p++;
            }
        }
        return p;
    }

    public int find(int i) {
        if (i != parent[i]) {
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }

    public void union(int x, int y) {
        parent[find(y)] = find(x);
    }
}
