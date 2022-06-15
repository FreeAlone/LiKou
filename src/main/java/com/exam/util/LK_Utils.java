package com.exam.util;

public class LK_Utils {

    public static void printArr(int[] arr) {
        StringBuilder stringBuilder = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(arr[i]);
        }
        stringBuilder.append("]");
        System.out.println(stringBuilder);
    }
}
