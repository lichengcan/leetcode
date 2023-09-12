package com.example.leetcode.hashtable;

/**
 * @author: lichengcan
 * @date: 2023-09-12 10:09
 * @description
 **/
public class 整数转罗马数字 {

//    罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
//
//    字符          数值
//    I             1
//    V             5
//    X             10
//    L             50
//    C             100
//    D             500
//    M             1000
//    例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
//
//    通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
//
//    I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
//    X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
//    C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
//    给你一个整数，将其转为罗马数字。

    public static void main(String[] args) {
        System.out.println(intToRoman2(1));
        System.out.println(intToRoman2(3));
        System.out.println(intToRoman2(4));
        System.out.println(intToRoman2(5));
        System.out.println(intToRoman2(9));
        System.out.println(intToRoman2(10));
        System.out.println(intToRoman2(13));
        System.out.println(intToRoman2(23));
        System.out.println(intToRoman2(33));
        System.out.println(intToRoman2(39));
        System.out.println(intToRoman2(40));
    }

    /**
     * 官方题解
     *
     * @param num
     * @return
     */
    public static String intToRoman2(int num) {

        //将所有罗马数字的表达式放到数组
        //将对应的阿拉伯数字也放到数组
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuffer result = new StringBuffer();
        //遍历阿拉伯数组
        for (int i = 0; i < values.length; i++) {
            int value = values[i];
            while (num >= value) {
                result.append(symbols[i]);
                num -= value;
            }
            if (num == 0) {
                break;
            }
        }
        return result.toString();

    }


    /**
     * 自己写的 low
     *
     * @param num
     * @return
     */
    public static String intToRoman(int num) {

        //如果
        StringBuffer stringBuffer = new StringBuffer();
        if (num < 4) {
            for (int i = 0; i < num; i++) {
                stringBuffer.append("I");
            }
            return stringBuffer.toString();
        } else if (num == 4) {
            return "IV";
        } else if (num == 5) {
            return "V";
        } else if (num < 9) {
            int mod = num % 5;
            stringBuffer.append("V");
            for (int i = 0; i < mod; i++) {
                stringBuffer.append("I");
            }
            return stringBuffer.toString();
        } else if (num == 9) {
            return "IX";
        } else if (num == 10) {
            return "X";
        } else if (num < 40) {
            int div = num / 10;
            int mod = num % 10;
            for (int i = 0; i < div; i++) {
                stringBuffer.append("X");
            }
            return stringBuffer + intToRoman2(mod);
        } else if (num == 40) {
            return "XL";
        }
        return null;
    }
}
