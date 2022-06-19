package com.exam.lk_05;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LK_0547 {

    public static void main(String[] args) {
        int[][] isConnected1 = {{1,1,0},{1,1,0},{0,0,1}};
        int[][] isConnected2 = {{1,0,0},{0,1,0},{0,0,1}};
        int[][] isConnected3 = {{1,0,0,1},{0,1,1,0}, {0,1,1,1},{1,0,1,1}};
        int[][] isConnected4 = {{1,1,0,0,0,0,0,1,0,0,0,0,0,0,0},{1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,1,0,1,1,0,0,0,0,0,0,0,0},{0,0,0,0,1,0,0,0,0,1,1,0,0,0,0},{0,0,0,1,0,1,0,0,0,0,1,0,0,0,0},{0,0,0,1,0,0,1,0,1,0,0,0,0,1,0},{1,0,0,0,0,0,0,1,1,0,0,0,0,0,0},{0,0,0,0,0,0,1,1,1,0,0,0,0,1,0},{0,0,0,0,1,0,0,0,0,1,0,1,0,0,1},{0,0,0,0,1,1,0,0,0,0,1,1,0,0,0},{0,0,0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,1,0,1,0,0,0,0,1,0},{0,0,0,0,0,0,0,0,0,1,0,0,0,0,1}};

        LK_0547 lk_0547 = new LK_0547();
        System.out.println(lk_0547.findCircleNum(isConnected1));
        System.out.println(lk_0547.findCircleNum(isConnected2));
        System.out.println(lk_0547.findCircleNum(isConnected3));
        System.out.println(lk_0547.findCircleNum(isConnected4));
        System.out.println();
        System.out.println(lk_0547.findCircleNumBfs(isConnected1));
        System.out.println(lk_0547.findCircleNumBfs(isConnected2));
        System.out.println(lk_0547.findCircleNumBfs(isConnected3));
        System.out.println(lk_0547.findCircleNumBfs(isConnected4));
        System.out.println();
        System.out.println(lk_0547.findCircleNumDfs1(isConnected1));
        System.out.println(lk_0547.findCircleNumDfs1(isConnected2));
        System.out.println(lk_0547.findCircleNumDfs1(isConnected3));
        System.out.println(lk_0547.findCircleNumDfs1(isConnected4));
        System.out.println();
        System.out.println(lk_0547.findCircleNumDfs2(isConnected1));
        System.out.println(lk_0547.findCircleNumDfs2(isConnected2));
        System.out.println(lk_0547.findCircleNumDfs2(isConnected3));
        System.out.println(lk_0547.findCircleNumDfs2(isConnected4));
    }

    int[] parent;

    // 并查集
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

    // 深度优先搜索 递归
    public int findCircleNumDfs1(int[][] isConnected) {
        int len = isConnected.length;
        boolean[] visited = new boolean[len];
        int ret = 0;
        for (int i = 0; i < len; i++) {
            if (!visited[i]) {
                ret ++;
                visited[i] = true;
                dfs(visited, isConnected, len, i);
            }
        }
        return ret;
    }

    public void dfs(boolean[] visited, int[][] isConnected, int len, int t) {
        for (int i = 0; i < len; i++) {
            if (!visited[i] &&  i != t && isConnected[t][i] == 1) {
                visited[i] = true;
                dfs(visited, isConnected, len, i);
            }
        }
    }

    // 深度优先搜索 栈
    public int findCircleNumDfs2(int[][] isConnected) {
        int len = isConnected.length;
        boolean[] visited = new boolean[len];
        int ret = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            if (!visited[i]) {
                ret++;
                stack.push(i);
                while (!stack.isEmpty()) {
                    Integer k = stack.pop();
                    visited[k] = true;
                    for (int j = 0; j < len; j++) {
                        if (!visited[j] && k != j && isConnected[k][j] == 1) {
                            stack.push(j);
                        }
                    }
                }
            }
        }
        return ret;
    }

    // 广度优先搜索
    public int findCircleNumBfs(int[][] isConnected) {
        int len = isConnected.length;
        boolean[] visited = new boolean[isConnected.length];
        int ret = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            if (!visited[i]) {
                queue.offer(i);
                ret++;
                while (!queue.isEmpty()) {
                    Integer temp = queue.poll();
                    visited[temp] = true;
                    for (int j = 0; j < len; j++) {
                        if (isConnected[temp][j] == 1 && !visited[j]) {
                            queue.offer(j);
                        }
                    }
                }
            }
        }
        return ret;
    }
}
