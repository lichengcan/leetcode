package com.example.leetcode.github;

import java.util.Arrays;

/**
 * @author: lichengcan
 * @date: 2023-09-27 16:23
 * @description
 **/
public class 第N个泰波那契数 {
    public static void main(String[] args) {
        第N个泰波那契数 test = new 第N个泰波那契数();
        System.out.println(test.tribonacci(25));
    }

    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        int a = 0, b = 1, c = 1;
        for (int i = 3; i <= n; i++) {
            int d = a + b + c;
            a = b;
            b = c;
            c = d;
        }
        return c;
    }

    public int tribonacci1(int n) {
        //构建泰波那契数
        int[] ints = new int[n];
        ints[0] = 0;
        if (n > 1) {
            ints[1] = 1;
            if (n > 2) {
                ints[2] = 1;
                for (int i = 3; i < n-1; i++) {
                    ints[i] = ints[i - 1] + ints[i - 2] + ints[i - 3];
                }
            }
        }
        return Arrays.stream(ints).sum();
    }
}
