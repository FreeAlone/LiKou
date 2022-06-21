package com.exam.lk_08;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LK_0820 {

    public static void main(String[] args) {
        String[] words1 = {"time", "me", "bell"};
        String[] words2 = {"t"};
        LK_0820 lk_0820 = new LK_0820();
        System.out.println(lk_0820.minimumLengthEncoding(words1));
        System.out.println(lk_0820.minimumLengthEncoding(words2));
    }

    public int minimumLengthEncoding(String[] words) {
        Arrays.sort(words, (o1, o2) -> o2.length() - o1.length());
        int len = 0;
        Tire root = new Tire();
        for (String word : words) {
            boolean isNew = false;
            char[] charArray = word.toCharArray();
            Tire cur = root;
            for (int j = charArray.length - 1; j >= 0; j--) {
                int index = charArray[j] - 'a';
                if (cur.children[index] == null) {
                    Tire temp = new Tire();
                    temp.c = charArray[j];
                    cur.children[index] = temp;
                    isNew = true;
                }
                cur = cur.children[index];
            }
            if (isNew) {
                len += word.length() + 1;
            }
        }
        return len;
    }

    class Tire {
        public Tire[] children = new Tire[26];
        public char c;
    }

}
