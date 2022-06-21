package com.exam.lk_02;

public class LK_0240 {

    public static void main(String[] args) {
        int[][] matrix = {{-1,3}};
        int target = 3;
        int[][] matrix1 = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int target1 = 5;
        int[][] matrix2 = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int target2 = 20;
        LK_0240 lk_0240 = new LK_0240();
        System.out.println(lk_0240.searchMatrix(matrix, target));
        System.out.println(lk_0240.searchMatrix(matrix1, target1));
        System.out.println(lk_0240.searchMatrix(matrix2, target2));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] ints : matrix) {
            if (ints[0] <= target && ints[ints.length - 1] >= target) {
                for (int anInt : ints) {
                    if (anInt == target) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
