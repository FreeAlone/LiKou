package com.exam.lk_00;

import java.util.HashSet;
import java.util.Set;

public class LK_0003 {

    public static void main(String[] args) {
        String str1 = "abcabcbb";
        String str2 = "bbbbb";
        String str3 = "pwwkew";
        LK_0003 lk_0003 = new LK_0003();
        System.out.println(lk_0003.lengthOfLongestSubstring(str1));
        System.out.println(lk_0003.lengthOfLongestSubstring(str2));
        System.out.println(lk_0003.lengthOfLongestSubstring(str3));
    }

    public int lengthOfLongestSubstring(String s) {
        char[] array = s.toCharArray();
        int res = 0;
        int left = 0;
        int right = 0;
        Set<Character> set = new HashSet<>();
        while (right < array.length) {
            if (!set.contains(array[right])) {
                set.add(array[right]);
                res = Math.max(res, right - left + 1);
                right++;
            } else {
                set.remove(array[left]);
                left++;
            }
        }
        return res;
    }
}
