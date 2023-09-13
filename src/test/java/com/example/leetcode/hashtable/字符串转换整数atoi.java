package com.example.leetcode.hashtable;

/**
 * @author: lichengcan
 * @date: 2023-09-12 16:28
 * @description
 **/
public class 字符串转换整数atoi {
    public static void main(String[] args) {
        字符串转换整数atoi atoi = new 字符串转换整数atoi();
        String str = "-45kkkk";
        System.out.println(atoi.myAtoi(str));

    }
    public int myAtoi(String str) {
        int i = 0, sign = 1, result = 0;
        // 读入字符串并丢弃无用的前导空格
        while (i < str.length() && str.charAt(i) == ' ') {
            i++;
        }
        // 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。确定最终结果是负数还是正数。如果两者都不存在，则假定结果为正。
        if (i < str.length() && (str.charAt(i) == '+' || str.charAt(i) == '-')) {
            sign = (str.charAt(i++) == '+') ? 1 : -1;
        }
        // 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > Integer.MAX_VALUE % 10)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + (str.charAt(i++) - '0');
        }
        return result * sign;
    }
}
