package com.example.leetcode.mianshi;

import java.util.HashMap;

/**
 * @author: lichengcan
 * @date: 2023-09-22 10:10
 * @description 罗马数字转整数
 **/
public class 罗马数字转整数 {

    //罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
    //
    //字符          数值
    //I             1
    //V             5
    //X             10
    //L             50
    //C             100
    //D             500
    //M             1000
    //例如， 罗马数字 2 写做 II ，即为两个并列的 1 。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
    //
    //通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。
    // 数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。
    // 同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
    //
    //I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
    //X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
    //C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
    //给定一个罗马数字，将其转换成整数。


    public static int romanToInt(String s) {
        HashMap<String,Integer> map = new HashMap<>();
        map.put("I",1);
        map.put("V",5);
        map.put("X",10);
        map.put("L",50);
        map.put("C",100);
        map.put("D",500);
        map.put("M",1000);
        int sum = 0;
        for (int i = 0; i < s.length()-1; i++) {
            String pre = String.valueOf(s.charAt(i));
            String next = String.valueOf(s.charAt(i+1));
            if (map.get(pre)<map.get(next)) {
                sum = sum - map.get(pre);
            }else {
                sum = sum + map.get(pre);
            }
        }
        return sum+map.get(String.valueOf(s.charAt(s.length()-1)));
    }
    public static void main(String[] args) {
        String str = new String("XXVII");
        System.out.println(romanToInt(str));
    }
}

