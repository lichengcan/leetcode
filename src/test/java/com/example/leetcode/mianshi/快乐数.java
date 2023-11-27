package com.example.leetcode.mianshi;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: lichengcan
 * @date: 2023-11-27 16:45
 * @description
 **/
public class 快乐数 {
    //编写一个算法来判断一个数 n 是不是快乐数。
    //
    //「快乐数」 定义为：
    //
    //对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
    //然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
    //如果这个过程 结果为 1，那么这个数就是快乐数。
    //如果 n 是 快乐数 就返回 true ；不是，则返回 false 。

    public static boolean isHappy(int n) {
        // 给一个数字 n，它的下一个数字是什么？
        // 按照一系列的数字来判断我们是否进入了一个循环。
        Map<Integer, Integer> map = new HashMap<>();
        while(n!=1){
            n = nextNum(n);
            if (map.containsKey(n)) {
                return false;
            } else {
                map.put(n, 1);
            }
        }
        return true;
    }

    static int nextNum(int n) {
        int nextNum = 0;
        while (n > 0) {
            int mod = n % 10;//个位
            n = n / 10;//去掉个位
            nextNum += mod * mod;
        }
        return nextNum;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(2));
    }
}
