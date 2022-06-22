package com.exam.lk_09;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class LK_0994 {

    public static void main(String[] args) {
        int[][] grid1 = {{2,1,1},{1,1,0},{0,1,1}};
        int[][] grid2 = {{2,1,1},{0,1,1},{1,0,1}};
        int[][] grid3 = {{0,2}};
        LK_0994 lk_0994 = new LK_0994();
        System.out.println(lk_0994.orangesRotting(grid1));
        System.out.println(lk_0994.orangesRotting(grid2));
        System.out.println(lk_0994.orangesRotting(grid3));
    }

    public int orangesRotting(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        int maxRow = grid.length;
        int maxCol = grid[0].length;
        boolean[][] visited = new boolean[maxRow][maxCol];
        Queue<Pair<Integer, Pair<Integer, Integer>>> queue = new LinkedList<>();
        int total = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new Pair<>(0, new Pair<>(i, j)));
                    visited[i][j] = true;
                } else if (grid[i][j] == 1) {
                    total++;
                } else if (grid[i][j] == 0) {
                    visited[i][j] = true;
                }
            }
        }
        int res = 0;
        while (!queue.isEmpty()) {
            Pair<Integer, Pair<Integer, Integer>> levelPair = queue.poll();
            int level = levelPair.getKey();
            Pair<Integer, Integer> pair = levelPair.getValue();
            int row = pair.getKey();
            int col = pair.getValue();
            grid[row][col] = 2;
            res = level;
            if (row + 1 < maxRow && !visited[row + 1][col]) {
                if (grid[row + 1][col] == 1) {
                    queue.offer(new Pair<>(level + 1, new Pair<>(row + 1, col)));
                    total--;
                }
                visited[row + 1][col] = true;
            }
            if (row - 1 >= 0 && !visited[row - 1][col]) {
                if (grid[row - 1][col] == 1) {
                    queue.offer(new Pair<>(level + 1, new Pair<>(row - 1, col)));
                    total--;
                }
                visited[row - 1][col] = true;
            }
            if (col + 1 < maxCol && !visited[row][col + 1]) {
                if (grid[row][col + 1] == 1) {
                    queue.offer(new Pair<>(level + 1, new Pair<>(row, col + 1)));
                    total--;
                }
                visited[row][col + 1] = true;
            }
            if (col - 1 >= 0 && !visited[row][col - 1]) {
                if (grid[row][col - 1] == 1) {
                    queue.offer(new Pair<>(level + 1, new Pair<>(row, col - 1)));
                    total--;
                }
                visited[row][col - 1] = true;
            }

        }
        if (total > 0) {
            return -1;
        }
        return res;
    }

}
