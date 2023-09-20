package com.example.leetcode.mians;

/**
 * @author: lichengcan
 * @date: 2023-09-20 15:07
 * @description
 **/
public class 买卖股票的最佳时机 {
//    给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
//
//    你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
//
//    返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。


    public static void main(String[] args) {
        int[] ints = new int[]{7, 1, 5, 3, 6, 4};
        买卖股票的最佳时机 test = new 买卖股票的最佳时机();
        System.out.println(test.maxProfit(ints));
    }

    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int res = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice)
                minPrice = prices[i];
            else if (prices[i] - minPrice > res)
                res = prices[i] - minPrice;
        }
        return res;
    }

}
