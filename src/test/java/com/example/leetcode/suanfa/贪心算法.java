package com.example.leetcode.suanfa;

import java.util.Arrays;

/**
 * @author: lichengcan
 * @date: 2023-09-20 16:31
 * @description
 **/
public class 贪心算法 {

    public static int coinChange(int[] coins, int amount) {
        // 初始化一个数组，用于记录凑成每个金额所需的最小硬币数量
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1); // 将数组初始化为一个不可能达到的值
        dp[0] = 0; // 凑成金额为0的最小硬币数量为0

        // 动态规划求解
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] <= amount ? dp[amount] : -1;
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        int result = coinChange(coins, amount);
        if (result != -1) {
            System.out.println("最少硬币数量: " + result);
        } else {
            System.out.println("无法凑成总金额");
        }
    }
}
