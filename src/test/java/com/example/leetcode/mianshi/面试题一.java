package com.example.leetcode.mianshi;

/**
 * @author: lichengcan
 * @email ccnaive@qq.com
 * @date: 2024-01-26 16:55
 * @description
 **/
public class 面试题一 {
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

    //题目: 实现一个curry函数, 完成以下效果:
    //
    //const add = (a, b, c)=>a + b + c
    //curry(add)(1)(2)(3) === add(1,2,3)
    public static String toCurry(String... strs) {
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : strs) {
            stringBuffer.append(str);
        }
        return stringBuffer.toString();
    }

    //## . sqrt函数
    //
    //> 题目: 实现`sqrt`函数, 计算一个数的平方根
    //>
    //> 例如: `sqrt(9) === 3`
    //
    //这个感觉是数学上的问题了, 当时直接懵了, 试了一下直接使用 `Math.sqrt()` ,没想到直接通过了, 这里给出gpt提供的代码

    public static double getSqrt(double num) {
        return Math.sqrt(num);
    }


    public static void main(String[] args) {
        //1
        System.out.println(isStr("110-110-1100"));
        System.out.println(isStr("11a-11c-11c"));
        System.out.println(isStr("1-2-334"));
        //2
        System.out.println(toCurry("123", "lcc", "222"));
        System.out.println(toCurry("aa", "lcc", "222"));
        System.out.println(toCurry("bb", "lcc", "222"));
        //3
        System.out.println(getSqrt(10));
        System.out.println(getSqrt(9));
        System.out.println(getSqrt(14));
        System.out.println(getSqrt(3));
    }
}
