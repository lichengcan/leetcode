package com.example.leetcode.hashtable;

import java.util.HashSet;

/**
 * @author: lichengcan
 * @date: 2023-09-11 16:02
 * @description
 **/
public class 无重复字符 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("jbpnbwwd"));
        System.out.println(lengthOfLongestSubstring1("jbpnbwwd"));
    }

    /**
     * 没看懂 todo
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        // 记录字符上一次出现的位置
        int[] last = new int[128];
        for (int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();

        //用来存储最终的结果，即最长不含重复字符的子串的长度。
        int res = 0;
        int start = 0; // 窗口开始位置
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i);//获取ascll码
            start = Math.max(start, last[index] + 1);
            res = Math.max(res, i - start + 1);
            last[index] = i;
        }
        return res;
    }


    /**
     * 下面是自己写的，无法处理空字符串情况
     * @param s
     * @return
     */

    //使用hashset进行查找无重复字符长度
    //算出每个字符ascll码进行put，如果put失败记录长度
    //每次判断长度
    public static int lengthOfLongestSubstring1(String s) {
        int maxValue = 0;
        int n = s.length();
        HashSet<Character> set = new HashSet();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                char c = s.charAt(j);
                boolean add = set.add(c);
                if (!add) {
                    //取大
                    maxValue = Math.max(maxValue, set.size());
                    set.clear();
                    break;
                }
            }
        }
        //处理空串
        if(maxValue==0){
            maxValue=set.size();
        }
        return maxValue;
    }

}
