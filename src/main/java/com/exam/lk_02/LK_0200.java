package com.exam.lk_02;

public class LK_0200 {

    public static void main(String[] args) {
        char[][] grid1 = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        char[][] grid2 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        LK_0200 lk_0200 = new LK_0200();
        System.out.println(lk_0200.numIslands(grid1));
        System.out.println(lk_0200.numIslands(grid2));
    }

    public int numIslands(char[][] grid) {
        int[] parent = init(grid);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    union(grid, parent, i, j);
                }
            }
        }
        int ret = 0;
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == i) {
                ret++;
            }
        }
        return ret;
    }

    public int[] init(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int len = m * n;
        int[] parent = new int[len];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    parent[i * grid[i].length + j] = i * grid[i].length + j;
                } else {
                    parent[i * grid[i].length + j] = -1;
                }

            }
        }
        return parent;
    }

    public int find(int[] parent, int x) {
        if (parent[x] != x && parent[x] != -1) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    public void union(char[][] grid, int[] parent, int x, int y) {
        int l0 = x * grid[0].length + y;

        // 左边的
        if (y > 0 && y < grid[0].length) {
            int l1 = x * grid[0].length + y - 1;
            int f0 = find(parent, l1);
            int f1 = find(parent, l0);
            if (f1 > -1 && f0 > -1) {
                parent[f1] = f0;
            }
        }
        // 右边的
        if (y >= 0 && y < grid[0].length - 1) {
            int l1 = x * grid[0].length + y + 1;
            int f0 = find(parent, l0);
            int f1 = find(parent, l1);
            if (f1 > -1 && f0 > -1) {
                parent[f1] = f0;
            }
        }
        // 上边的
        if (x > 0 && x < grid.length) {
            int l1 = (x - 1) * grid[0].length + y;
            int f0 = find(parent, l1);
            int f1 = find(parent, l0);
            if (f1 > -1 && f0 > -1) {
                parent[f1] = f0;
            }
        }
        // 下边的
        if (x >= 0 && x < grid.length - 1) {
            int l1 = (x + 1) * grid[0].length + y;
            int f0 = find(parent, l0);
            int f1 = find(parent, l1);
            if (f1 > -1 && f0 > -1) {
                parent[f1] = f0;
            }
        }
    }
}
