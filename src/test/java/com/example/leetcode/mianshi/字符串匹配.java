package com.example.leetcode.mianshi;

/**
 * @author: lichengcan
 * @email ccnaive@qq.com
 * @date: 2024-01-26 16:55
 * @description
 **/
public class 字符串匹配 {
    //题目: 判断字符串是否符合XXX-XXX-XXXX(X为数字), 返回Boolean值
    //
    //例如 :
    //
    //'110-110-1100' 返回 true,
    //
    //'11a-11b-110c' 返回 ralse
    //
    //'123-1-2' 返回 ralse

    public static boolean isStr(String str) {
        String[] strings = str.split("-");
        for (String num : strings) {
            try {
                Integer.valueOf(num);
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isStr("110-110-1100"));
        System.out.println(isStr("11a-11c-11c"));
        System.out.println(isStr("1-2-334"));
    }
}
