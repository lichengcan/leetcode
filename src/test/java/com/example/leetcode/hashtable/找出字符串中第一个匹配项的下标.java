package com.example.leetcode.hashtable;

/**
 * @author: lichengcan
 * @date: 2023-09-12 15:39
 * @description
 **/
public class 找出字符串中第一个匹配项的下标 {

    public static void main(String[] args) {
        String haystack = "abc"; String needle = "c";
        System.out.println(strStr(haystack, needle));
        System.out.println(strStr1(haystack, needle));
    }
    public static int strStr1(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        if (n==m) {
            if (haystack.equals(needle)) {
                return 0;
            }
        }
         for (int i = 0; i <= n - m; i++) {
            String substring = haystack.substring(i, i+m);
            if (substring.equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 暴力破解
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        //字符长度差
        for (int i = 0; i + m <= n; i++) {
            boolean flag = true;
            //目标字符长度
            for (int j = 0; j < m; j++) {
                //遇到一个匹配不上就终端
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }
}
