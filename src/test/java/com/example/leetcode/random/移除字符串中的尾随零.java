package com.example.leetcode.random;

/**
 * @author: lichengcan
 * @date: 2023-09-19 15:10
 * @description
 **/
public class 移除字符串中的尾随零 {
    //    给你一个用字符串表示的正整数 num ，请你以字符串形式返回不含尾随零的整数 num 。
//
//
//
//    示例 1：
//
//    输入：num = "51230100"
//    输出："512301"
//    解释：整数 "51230100" 有 2 个尾随零，移除并返回整数 "512301" 。
//    示例 2：
//
//    输入：num = "123"
//    输出："123"
//    解释：整数 "123" 不含尾随零，返回整数 "123" 。


//    正则表达式模式 "0+$" 解释如下：
//
//            "0"：表示匹配数字 0。
//            "+$"：表示匹配一个或多个连续的 0，并且这些 0 必须出现在字符串的末尾。
    public String removeTrailingZeros(String num) {
        return num.replaceAll("0+$", "");
    }

}
