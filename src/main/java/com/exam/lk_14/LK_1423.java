package com.exam.lk_14;

public class LK_1423 {

    public static void main(String[] args) {
        int[] cardPoints1 = {1, 2, 3, 4, 5, 6, 1};
        int k1 = 3;
        int[] cardPoints2 = {2, 2, 2};
        int k2 = 2;
        int[] cardPoints3 = {9, 7, 7, 9, 7, 7, 9};
        int k3 = 7;
        int[] cardPoints4 = {1, 1000, 1};
        int k4 = 1;
        int[] cardPoints5 = {1, 79, 80, 1, 1, 1, 200, 1};
        int k5 = 3;
        LK_1423 lk_1423 = new LK_1423();
        System.out.println(lk_1423.maxScore(cardPoints1, k1));
        System.out.println(lk_1423.maxScore(cardPoints2, k2));
        System.out.println(lk_1423.maxScore(cardPoints3, k3));
        System.out.println(lk_1423.maxScore(cardPoints4, k4));
        System.out.println(lk_1423.maxScore(cardPoints5, k5));
    }

    public int maxScore(int[] cardPoints, int k) {
        int total = 0;
        for (int cardPoint : cardPoints) {
            total += cardPoint;
        }
        if (k >= cardPoints.length) {
            return total;
        }
        int len = cardPoints.length - k;
        int min = 0;
        for (int i = 0; i < len; i++) {
            min += cardPoints[i];
        }
        int temp = min;
        for (int i = len; i < cardPoints.length; i++) {
            temp = temp + cardPoints[i] - cardPoints[i - len];
            min = Math.min(min, temp);
        }
        return total - min;
    }
}
