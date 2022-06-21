package com.exam.lk_00;

public class LK_0005 {

    public static void main(String[] args) {
        String str1 = "babad";
        String str2 = "cbbd";
        LK_0005 lk_0005 = new LK_0005();
        System.out.println(lk_0005.longestPalindrome(str1));
        System.out.println(lk_0005.longestPalindrome(str2));
    }

    public String longestPalindrome(String s) {
        int res = s.length();
        char[] arr = s.toCharArray();
        while (res > 1) {
            for (int i = 0; i < s.length() - res + 1; i++) {
                int left = i;
                int right = i + res - 1;
                boolean flag = true;
                while (left < right) {
                    if (arr[left] != arr[right]) {
                        flag = false;
                        break;
                    }
                    left++;
                    right--;
                }
                if (flag) {
                    return s.substring(i, res + i);
                }
            }
            res--;
        }
        return s.substring(0, 1);
    }
}
