package com.example.leetcode.mianshi;

import java.util.*;

/**
 * @author: lichengcan
 * @date: 2023-11-27 14:15
 * @description
 **/
public class 字母异位词分组 {
    //给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
    //
    //字母异位词 是由重新排列源单词的所有字母得到的一个新单词。

    public static List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String temp = new String(chars);
            List<String> orDefault = map.getOrDefault(temp, new ArrayList<>());
            orDefault.add(str);
            map.put(temp, orDefault);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs =new String[]{"eat","tea","tan","ate","nat","bat"};
        final List<List<String>> lists = groupAnagrams(strs);
        System.out.println("lists = " + lists);
    }
}
