package com.exam.lk_08;

public class LK_0875 {

    public static void main(String[] args) {
        LK_0875 lk_0875 = new LK_0875();
        int[] piles1 = {3,6,7,11};
        int h1 = 8;
        int[] piles2 = {30,11,23,4,20};
        int h2 = 5;
        int[] piles3 = {30,11,23,4,20};
        int h3 = 6;
        int[] piles4 = {805306368,805306368,805306368};
        int h4 = 1000000000;
//        System.out.println(lk_0875.minEatingSpeed(piles1, h1));
//        System.out.println(lk_0875.minEatingSpeed(piles2, h2));
//        System.out.println(lk_0875.minEatingSpeed(piles3, h3));
        System.out.println(lk_0875.minEatingSpeed(piles4, h4));

    }

    public int minEatingSpeed(int[] piles, int h) {
        int lk = 0;
        int rk = 1000000001;
        while (lk + 1 != rk) {
            int mid = (lk + rk ) / 2;
            if (isBlue(piles, h, mid)) {
                rk = mid;
            } else {
                lk = mid;
            }
        }
        return rk;
    }

    private boolean isBlue(int[] piles, int h, int mid) {
        // 大于等于
        long total = 0;
        for (int pile : piles) {
            int a = pile % mid;
            int b = pile / mid;
            if (a > 0) {
                b++;
            }
            total += b;
        }
        return total <= h;
    }
}
