package com.example.leetcode.mianshi;

import java.util.HashMap;

/**
 * @author: lichengcan
 * @date: 2023-11-27 11:09
 * @description
 **/
public class 单词规律 {

    public static boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> res1 = new HashMap<>();
        HashMap<String, Character> res2 = new HashMap<>();

        final String[] s1 = s.split(" ");
        if (pattern.length()!=s1.length) return false;
        for (int i = 0; i < pattern.length(); i++) {
            final char c = pattern.charAt(i);
            if (res1.containsKey(c) && !res1.get(c).equals(s1[i])||res2.containsKey(s1[i])&&res2.get(s1[i])!=c) {
                return false;
            }
            res1.put(c, s1[i]);
            res2.put(s1[i], c);
        }
        return true;
    }

    public static void main(String[] args) {
        String pattern = "abba";
        String s = "dog dog dog dog";
        System.out.println(wordPattern(pattern, s));
    }
}
