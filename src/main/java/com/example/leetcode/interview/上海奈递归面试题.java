package com.example.leetcode.interview;

/**
 * @author: lichengcan
 * @email ccnaive@qq.com
 * @date: 2024-02-24 17:06
 * @description
 **/
public class 上海奈递归面试题 {

    public static void main(String[] args) {
        //假设用户输入
        int n = 8;
        int[] sum = new int[n];
        sum[0] = 0;
        sum[1] = 1;
        //8   21
        //7   13
        //6   8
        //5   5
        //4 = 3
        //3 = 2
        //2 = 1
        // 1 = 1
        // 0 = 0
        //解法一
        for (int i = 2; i < sum.length; i++) {
            sum[i] = sum[i - 1] + sum[i - 2];
        }
        System.out.println("方法一"+sum[n - 1] + sum[n - 2]);
        final int i = computN(n);
        System.out.println("递归答案 = " + i);

    }
    /**
     * 解法二 递归
     *
     * @param n
     * @return
     */
    public static int computN(int n) {
        if (n == 0) return 0;
        else if (n == 1) return 1;
        else return computN(n - 1) + computN(n - 2);
    }
}
