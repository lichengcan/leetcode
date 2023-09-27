package com.example.leetcode.github;

/**
 * @author: lichengcan
 * @date: 2023-09-27 15:16
 * @description
 **/
public class 整数的各位积和之差 {
    public static void main(String[] args) {
        整数的各位积和之差 test = new 整数的各位积和之差();
        int n = 234;
        System.out.println(test.subtractProductAndSum(n));
    }

    public int subtractProductAndSum(int n) {
        int mul = 1;
        int sum = 0;
        final int[] ints = getInts(n);
        for (int anInt : ints) {
            mul *= anInt;
            sum += anInt;
        }
        return mul - sum;
    }

    /**
     * 获取int个十百千......
     */
    public static int[] getInts(int n) {
        int length = String.valueOf(n).length();
        int[] res = new int[length];
        for (int i = 0; i < length; i++) {
            //先除
            int pow = (int) Math.pow(10, i);
            int div = i == 0 ? 1 : pow;
            //取模
            res[i] = (n / div) % 10;
        }
        return res;
    }
}
