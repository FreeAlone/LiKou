package com.exam.lk_01;

import java.util.*;

public class LK_0139 {

    public static void main(String[] args) {
        String s1 = "leetcode";
        List<String> wordDict1 = Arrays.asList("leet", "code");
        String s2 = "applepenapple";
        List<String> wordDict2 = Arrays.asList("apple", "pen");
        String s3 = "catsandog";
        List<String> wordDict3 = Arrays.asList("cats", "dog", "sand", "and", "cat");
        String s4 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        List<String> wordDict4 = Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa");
        LK_0139 lk_0139 = new LK_0139();
        System.out.println(lk_0139.wordBreak(s1, wordDict1));
        System.out.println(lk_0139.wordBreak(s2, wordDict2));
        System.out.println(lk_0139.wordBreak(s3, wordDict3));
        System.out.println(lk_0139.wordBreak(s4, wordDict4));
    }


    public boolean result = false;

    public final char LETTER_A = 'a';

    public TrieTree root = null;

    public boolean[] failed;

    public boolean wordBreak(String s, List<String> wordDict) {
        result = false;
        root = new TrieTree('R');
        failed = new boolean[s.length()];
        for (String str : wordDict) {
            TrieTree temp = root;
            char[] chars = str.toCharArray();
            for (char aChar : chars) {
                int index = aChar - LETTER_A;
                if (temp.trees[index] == null) {
                    TrieTree trieTree = new TrieTree(aChar);
                    temp.trees[index] = trieTree;
                    temp = trieTree;
                } else {
                    temp = temp.trees[index];
                }
            }
            temp.end = true;
        }
        char[] chars = s.toCharArray();
        findChar(chars, 0);
        return result;
    }

    public void findChar(char[] chars, int index) {
        if (result || index >= chars.length || failed[index]) {
            return;
        }
        int indexTemp = index;
        TrieTree temp = root;
        for (; index < chars.length; index++) {
            char c = chars[index];
            TrieTree trieTree = temp.trees[c - LETTER_A];
            if (trieTree == null) {
                return;
            }
            if (chars.length == index + 1 && trieTree.end) {
                result = true;
                return;
            }
            temp = trieTree;
            if (temp.end) {
                failed[indexTemp] = true;
                findChar(chars, index + 1);
            }
        }
    }

    static class TrieTree {

        public char letter;

        public TrieTree[] trees;

        public boolean end;

        public TrieTree(char c) {
            this.letter = c;
            trees = new TrieTree[26];
            end = false;
        }
    }

}
