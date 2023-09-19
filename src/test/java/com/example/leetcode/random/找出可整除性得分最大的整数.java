package com.example.leetcode.random;

/**
 * @author: lichengcan
 * @date: 2023-09-17 18:57
 * @description
 **/
public class 找出可整除性得分最大的整数 {
//    给你两个下标从 0 开始的整数数组 nums 和 divisors 。
//
//    divisors[i] 的 可整除性得分 等于满足 nums[j] 能被 divisors[i] 整除的下标 j 的数量。
//
//    返回 可整除性得分 最大的整数 divisors[i] 。如果有多个整数具有最大得分，则返回数值最小的一个。

    public static void main(String[] args) {
        找出可整除性得分最大的整数 test = new 找出可整除性得分最大的整数();
        int[] nums = new int[]{4, 7, 9, 3, 9};
        int[] divisors = new int[]{5, 2, 3};
        System.out.println(test.maxDivScore(nums, divisors));

    }

    public int maxDivScore(int[] nums, int[] divisors) {
        int[] score = new int[divisors.length];

        // 初始化分数数组为0
        for (int i = 0; i < divisors.length; i++) {
            score[i] = 0;
        }

        for (int num : nums) {
            for (int i = 0; i < divisors.length; i++) {
                if (num % divisors[i] == 0) {
                    score[i] += 1;
                }
            }
        }

        int maxScore = score[0];
        int maxDivisor = divisors[0];

        for (int i = 1; i < score.length; i++) {
            if (score[i] > maxScore) {
                maxScore = score[i];
                maxDivisor = divisors[i];
            } else if (score[i] == maxScore && divisors[i] < maxDivisor) {
                // 如果有多个除数得分相同，选择最小的除数
                maxDivisor = divisors[i];
            }
        }

        return maxDivisor;
    }

}
