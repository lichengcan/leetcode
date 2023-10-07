package com.example.leetcode.github;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: lichengcan
 * @date: 2023-10-07 16:08
 * @description
 **/
public class 第一个出现两次的字母 {
    public char repeatedCharacter(String s) {
        int length = s.length();
        Set<Character> strings = new HashSet<>(length);
        for (int i = 0; i < length; i++) {
            final char c = s.charAt(i);
            if(!strings.add(c)){
                return c;
            }
        }
        return ' ';
    }


}
