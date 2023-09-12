package com.example.leetcode.hashtable;

/**
 * @author: lichengcan
 * @date: 2023-09-12 10:59
 * @description
 **/
public class 罗马数字转整数 {

    public static void main(String[] args) {
        System.out.println(romanToInt1("MCMXCI"));
        System.out.println(romanToInt1("MCMXCIV"));
    }


    /**
     * 自己写的
     * @param sb
     * @return
     */
    public static int romanToInt(String sb) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int sum=0;
        for (int i = 0; i < symbols.length; i++) {
            final String symbol = symbols[i];
            while (sb.startsWith(symbol)&&!sb.isEmpty()){
                sum+=values[i];
                sb=sb.substring(symbol.length());
            }
            if (sb.isEmpty()){
                break;
            }
        }
        return sum;
    }


    /**
     * 高分答案
     * @param s
     * @return
     */
    public static int romanToInt1(String s) {
        int res = 0;
        char[] arr = s.toCharArray();
        for (int i = arr.length - 1; i >= 0; i--) {
            char c = arr[i];
            switch (c) {
                case 'I':
                    //I X C 是三个特殊字符，可能存在IXC在左边，右边是更大的情况，这时候就需要进行减法
                    res += (res >= 5 ? -1 : 1);
                    break;
                case 'V':
                    res += 5;
                    break;
                case 'X':
                    res += 10 * (res >= 50 ? -1 : 1);
                    break;
                case 'L':
                    res += 50;
                    break;
                case 'C':
                    res += 100 * (res >= 500 ? -1 : 1);
                    break;
                case 'D':
                    res += 500;
                    break;
                case 'M':
                    res += 1000;
                    break;
            }
        }
        return res;
    }
}
