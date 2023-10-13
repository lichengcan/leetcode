package com.example.leetcode.mianshi;

import java.util.Arrays;

/**
 * @author: lichengcan
 * @date: 2023-10-13 11:05
 * @description
 **/
public class 分发糖果 {

    //n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
    //
    //你需要按照以下要求，给这些孩子分发糖果：
    //
    //每个孩子至少分配到 1 个糖果。
    //相邻两个孩子评分更高的孩子会获得更多的糖果。
    //请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。

    public static void main(String[] args) {
        分发糖果 t = new 分发糖果();
        int[] ints = new int[]{1,0,2};
        System.out.println(t.candy(ints));

    }
    public int candy(int[] ratings) {
        final int length = ratings.length;

        int[] left = new int[length];
        for (int i = 1; i < ratings.length; i++) {
            if (i > 0 && ratings[i - 1] < ratings[i]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }
        int res =0; int right =0;
        for (int i = length-1; i >=0; i--) {
            if (i <length-1 && ratings[i] > ratings[i+1]) {
                right++;
            }else {
                right=1;
            }
            res += Math.max(left[i], right);

        }
        return res;
    }
}
