package com.exam.lk_00;

/**
 * 二分查找
 */
public class LK_0069 {

    public static void main(String[] args) {
        LK_0069 lk_0069 = new LK_0069();
        System.out.println(lk_0069.mySqrt(10));
        System.out.println(Long.MAX_VALUE);
        long z = Integer.MAX_VALUE / 2;
        System.out.println(z * z);
        System.out.println(2147483648L);
        long result = 1;
        for (int i = 0; i < 31; i++) {
            result = result * 2;
        }
        System.out.println(result);
        System.out.println(Integer.MAX_VALUE + 1L);
    }

    public int mySqrt(int x) {
        long left = -1;
        long right = Integer.MAX_VALUE + 1L;
        while (left + 1 != right) {
            long m = (left + right) / 2;
            if (isBlue(x, m)) {
                left = m;
            } else {
                right = m;
            }
        }
        return (int) left;
    }

    private boolean isBlue(int x, long m) {
        return m * m <= x;
    }

}
