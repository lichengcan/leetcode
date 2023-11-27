package com.example.leetcode.mianshi;

import java.util.Arrays;

/**
 * @author: lichengcan
 * @date: 2023-11-27 11:32
 * @description
 **/
public class 有效的字母异位词 {

    public static boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) return false;
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();

        Arrays.sort(c1);
        Arrays.sort(c2);
        return Arrays.equals(c1, c2);
    }

    public static void main(String[] args) {
        String s = "aacc";
        String t = "ccac";
        System.out.println(isAnagram(s, t));
    }
}
