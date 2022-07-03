package com.exam.lk_04;

import com.exam.util.LK_Utils;

import java.util.*;

public class LK_0438 {

    public static void main(String[] args) {
        String s1 = "cbaebabacd", p1 = "abc";
        String s2 = "abab", p2 = "ab";
        LK_0438 lk_0438 = new LK_0438();
        LK_Utils.printList(lk_0438.findAnagrams2(s1, p1));
        LK_Utils.printList(lk_0438.findAnagrams2(s2, p2));
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        char[] pc = p.toCharArray();
        Map<Character, Integer> target = new TreeMap<>();
        for (char c : pc) {
            Integer integer = target.getOrDefault(c, 0);
            target.put(c, integer + 1);
        }
        char[] chars = s.toCharArray();
        Map<Character, Integer> temp = new TreeMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (target.containsKey(chars[i])) {
                Integer integer = temp.getOrDefault(chars[i], 0);
                temp.put(chars[i], integer + 1);
            }
            int startIndex = i - p.length();
            if (startIndex >= 0 && target.containsKey(chars[startIndex])) {
                Integer integer = temp.getOrDefault(chars[startIndex], 0);
                temp.put(chars[startIndex], integer - 1);
            }
            boolean flag = true;
            for (Character character : target.keySet()) {
                if (!target.get(character).equals(temp.get(character))) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                list.add(startIndex + 1);
            }
        }
        return list;
    }

    public List<Integer> findAnagrams2(String s, String p) {
        int sl = s.length();
        int pl = p.length();
        List<Integer> result = new ArrayList<>();
        if (sl < pl) {
            return result;
        }
        int[] sa = new int[26];
        int[] pa = new int[26];
        for (int i = 0; i < pl; i++) {
            sa[s.charAt(i) - 'a']++;
            pa[p.charAt(i) - 'a']++;
        }
        if (Arrays.equals(sa, pa)) {
            result.add(0);
        }
        for (int i = pl; i < sl; i++) {
            sa[s.charAt(i) - 'a']++;
            sa[s.charAt(i - pl) - 'a']--;
            if (Arrays.equals(sa, pa)) {
                result.add(i - pl + 1);
            }
        }
        return result;
    }
}
