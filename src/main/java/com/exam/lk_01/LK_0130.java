package com.exam.lk_01;

import com.exam.util.LK_Utils;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class LK_0130 {

    public static void main(String[] args) {
//        char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        char[][] board = {{'O','O','O'},{'O','O','O'},{'O','O','O'}};
        LK_0130 lk_0130 = new LK_0130();
        lk_0130.solve(board);
        LK_Utils.printArrArr(board);
    }

    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        for (int i = 0; i < board.length; i++) {
            visited[i][0] = true;
            visited[i][board[i].length - 1] = true;
            if (board[i][0] == 'O') {
                stack.push(new Pair<>(i, 0));
            }
            if (board[i][board[i].length - 1] == 'O') {
                stack.push(new Pair<>(i, board[i].length - 1));
            }
        }
        for (int i = 0; i < board[0].length; i++) {
            visited[0][i] = true;
            visited[board.length - 1][i] = true;
            if (board[0][i] == 'O') {
                stack.push(new Pair<>(0, i));
            }
            if (board[board.length - 1][i] == 'O') {
                stack.push(new Pair<>(board.length - 1, i));
            }
        }
        List<Pair<Integer, Integer>> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            Pair<Integer, Integer> pair = stack.pop();
            list.add(pair);
            int i = pair.getKey();
            int j = pair.getValue();
            if (i + 1 < board.length && !visited[i+1][j]) {
                visited[i+1][j] = true;
                if (board[i+1][j] == 'O') {
                    stack.push(new Pair<>(i+1, j));
                }
            }
            if (i - 1 >= 0 && !visited[i-1][j]) {
                visited[i-1][j] = true;
                if (board[i-1][j] == 'O') {
                    stack.push(new Pair<>(i-1, j));
                }
            }
            if (j + 1 < board[0].length && !visited[i][j+1]) {
                visited[i][j+1] = true;
                if (board[i][j+1] == 'O') {
                    stack.push(new Pair<>(i, j+1));
                }
            }
            if (j - 1 >= 0 && !visited[i][j-1]) {
                visited[i][j-1] = true;
                if (board[i][j-1] == 'O') {
                    stack.push(new Pair<>(i, j-1));
                }
            }
        }
        for (char[] chars : board) {
            Arrays.fill(chars, 'X');
        }
        for (Pair<Integer, Integer> pair : list) {
            board[pair.getKey()][pair.getValue()] = 'O';
        }
    }

}
