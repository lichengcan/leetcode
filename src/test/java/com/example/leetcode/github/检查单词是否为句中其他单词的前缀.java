package com.example.leetcode.github;

/**
 * @author: lichengcan
 * @date: 2023-09-27 14:28
 * @description
 **/
public class 检查单词是否为句中其他单词的前缀 {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] str =  sentence.split(" ");
        for(int i = 0 ; i<str.length;i++){
            if(str[i].startsWith(searchWord)){
                return i;

            }
        }
        return -1;
    }
}
