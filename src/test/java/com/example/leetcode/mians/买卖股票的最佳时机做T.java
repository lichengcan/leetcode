package com.example.leetcode.mians;

/**
 * @author: lichengcan
 * @date: 2023-09-20 15:07
 * @description
 **/
public class 买卖股票的最佳时机做T {
//    给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
//
//    在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
//
//    返回 你能获得的 最大 利润 。
    //输入：prices = [7,1,5,3,6,4]
    //输出：7
    //解释：在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
    //     随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6 - 3 = 3 。
    //     总利润为 4 + 3 = 7 。


    public static void main(String[] args) {
        int[] ints = new int[]{7, 1, 5, 3, 6, 4};
        int[] ints2 = new int[]{1,2,3,4,5};
        买卖股票的最佳时机做T test = new 买卖股票的最佳时机做T();
        System.out.println(test.maxProfit2(ints));
        System.out.println(test.maxProfit2(ints2));
    }

    /**
     * 这种情况不能解决 int[] ints2 = new int[]{1,2,3,4,5};
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int res = 0;
        //双指针：l 买入、r 卖出、中间指针m
        //不卖的时候干啥：r++，m++
        //什么时候卖：当 prices[m] > prices[r]
        //怎么卖：prices[r-1]-prices[l]
        //l=r，m=r，r++
        final int length = prices.length;
        int l = 0, m = 0, r = 1;
        while (r != length) {
            int buy = prices[l];
            int temp = prices[m];
            int sell = prices[r];
            if (temp > sell) {
                res += prices[r - 1] - buy;
                m = l = r;
            }else{
                m++;
            }
            r++;
        }
        return res;
    }


    public int maxProfit2(int[] prices) {
        int res = 0;
        //每两天比较一次，能赚就卖
        final int length = prices.length;
        int l = 0, r = 1;
        while (r != length) {
            int buy = prices[l];
            int sell = prices[r];
            if (sell > buy) {
                res += sell-buy;
            }
            r++;l++;
        }
        return res;
    }

}
