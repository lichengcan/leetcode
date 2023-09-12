package com.example.leetcode.hashtable;

/**
 * @author: lichengcan
 * @date: 2023-09-12 10:59
 * @description
 **/
public class 罗马数字转整数 {

    public static void main(String[] args) {
        System.out.println(romanToInt("I"));
    }


    public static int romanToInt(String sb) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int sum=0;
        for (int i = 0; i < symbols.length; i++) {
            final String symbol = symbols[i];
            while (sb.startsWith(symbol)&&!sb.isEmpty()){
                sum+=values[i];
                sb=sb.replace(symbol,"");
            }
            if (sb.isEmpty()){
                break;
            }
        }
        return sum;
    }
}
