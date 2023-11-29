package com.example.leetcode.mianshi;

import java.util.Arrays;

/**
 * @author: lichengcan
 * @date: 2023-11-29 14:23
 * @description
 **/
public class H指数 {

    //给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数。计算并返回该研究者的 h 指数。
    //
    //根据维基百科上 h 指数的定义：h 代表“高引用次数” ，一名科研人员的 h 指数 是指他（她）至少发表了 h 篇论文，
    //
    // 并且每篇论文 至少 被引用 h 次。如果 h 有多种可能的值，h 指数 是其中最大的那个。
    //

    public static int hIndex(int[] citations) {
        Arrays.sort((citations));
        int max = 0;
        for (int i = 0; i < citations.length; i++) {
            int temp = citations[i];
            int count = 0;
            for (int citation : citations) {
                if (citation >= temp) {
                    count++;
                }
            }
            if (count >= temp) {
               max= Math.max(max, temp);
            }else {
                max= Math.max(max, count);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] citations = new int[]{3, 0, 6, 1, 5};
        int[] citations2 = new int[]{100};
        System.out.println(hIndex(citations));
        System.out.println(hIndex(citations2));
    }
}
