package com.example.leetcode.mianshi;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author: lichengcan
 * @date: 2023-10-26 15:08
 * @description
 **/
public class 赎金信 {
    //给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
    //
    //如果可以，返回 true ；否则返回 false 。
    //
    //magazine 中的每个字符只能在 ransomNote 中使用一次。
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;
        char[] c1 = ransomNote.toCharArray();
        char[] c2 = magazine.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        int i = 0;
        for (char c : c2) {
            if (i == ransomNote.length()) return true;
            if (c == c1[i]) {
                i++;
            }
        }
        return i == ransomNote.length();
    }

    public static boolean canConstruct1(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;
        char[] c1 = ransomNote.toCharArray();
        char[] c2 = magazine.toCharArray();
        int[] arr = new int[26];
        for (char c : c2) {
            arr[c - 'a']++;
        }
        for (char c : c1) {
            arr[c - 'a']--;
            if (arr[c - 'a'] < 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "aab";
        System.out.println(canConstruct1(ransomNote, magazine));

    }
}
