package com.example.leetcode.mianshi;

import java.util.HashMap;

/**
 * @author: lichengcan
 * @date: 2023-11-27 10:37
 * @description
 **/
public class 同构字符串 {
    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> res1 = new HashMap();
        HashMap<Character, Character> res2 = new HashMap();
        for (int j = 0; j < s.length(); j++) {
            char l1 = s.charAt(j);
            char r1 = t.charAt(j);
            if (res1.containsKey(l1) && res1.get(l1) != r1 || res2.containsKey(r1) && res2.get(r1) != l1) {
                return false;
            }
            res1.put(l1, r1);
            res2.put(r1, l1);
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "badc";
        String t = "baba";
        System.out.println(isIsomorphic(s, t));
    }
}
