package com.example.leetcode.hashtable;

/**
 * @author: lichengcan
 * @date: 2023-09-12 11:44
 * @description
 **/
public class 最长公共前缀 {
//    编写一个函数来查找字符串数组中的最长公共前缀。
//
//    如果不存在公共前缀，返回空字符串 ""。
//    示例 1：
//
//    输入：strs = ["flower","flow","flight"]
//    输出："fl"
//    示例 2：
//
//    输入：strs = ["dog","racecar","car"]
//    输出：""
//    解释：输入不存在公共前缀。
//
//    提示：
//
//            1 <= strs.length <= 200
//            0 <= strs[i].length <= 200
//    strs[i] 仅由小写英文字母组成


    public static void main(String[] args) {
        String[] strs = new String[]{"flower", "flow", "flight"};
        String[] strs2 = new String[]{"a"};
        String[] strs3 = new String[]{"a","ab"};

        final String s = longestCommonPrefix(strs);
        final String s1 = longestCommonPrefix(strs2);
        final String s2 = longestCommonPrefix(strs3);
        System.out.println("s = " + s);
        System.out.println("s = " + s1);
        System.out.println("s = " + s2);
    }

    /**
     * al帮忙改了一下 第二个for循环的比较方法
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String str1 = strs[0];
        int strLength = str1.length();
        //找到最小字符串长度
        for (String str : strs) {
            int length = str.length();
            if (length < strLength) {
                strLength = length;
            }
        }
        for (int i = 0; i < strLength; i++) {
            //获取单个字符
            final char aChar = strs[0].charAt(i);
            //与后面其他字符比较
            for (String str : strs) {
                //记录最长字符长度
                if (i >= str.length() || str.charAt(i) != aChar) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0].substring(0, strLength);
    }

    /**
     * 自己写了一遍，有问题
     * @param strs
     * @return
     */
    public static String longestCommonPrefixV1(String[] strs) {
        String str1 = strs[0];
        int strLength = str1.length();
        //找到最小字符串长度
        for (String str : strs) {
            int length = str.length();
            if (length < strLength) {
                strLength = length;
            }
        }
        int resultLength = 0;
        for (int i = 0; i < strLength; i++) {
            //获取单个字符
            final byte aByte = strs[0].getBytes()[i];
            //与后面其他字符比较
            for (String str : strs) {
                final byte aByte1 = str.getBytes()[i];
                if (aByte !=aByte1) {
                    resultLength=i;
                }
            }
        }
        return strs[0].substring(0,resultLength+1);
    }
}
