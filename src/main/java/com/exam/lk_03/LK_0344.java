package com.exam.lk_03;

import com.exam.util.LK_Utils;

public class LK_0344 {

    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        LK_0344 lk_0344 = new LK_0344();
        lk_0344.reverseString(s);
        LK_Utils.printArr(s);
    }

    public void reverseString(char[] s) {
        for (int i = 0; i < s.length/2; i++) {
            char c = s[i];
            s[i] = s[s.length - i -1];
            s[s.length - i -1] = c;
        }
    }
}
