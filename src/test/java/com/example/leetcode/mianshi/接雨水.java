package com.example.leetcode.mianshi;

import java.util.Arrays;

/**
 * @author: lichengcan
 * @date: 2023-11-29 16:42
 * @description
 **/
public class 接雨水 {

    //给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

    public int trap(int[] height) {
        int maxH = 0;
        for (int i : height) {
            maxH = Math.max(maxH, i);
        }
        int length = height.length;
        int water = 0;
        for (int i = 1; i <= maxH; i++) {
            int tempWater = 0;
            //遍历第一层
            //如果遇到height[j]>=1时停下，判断height[j+1]<1,如果ture，则tempWater++，一直遍历到length前，如果又遇到height[]>=1时将，water+=tempWater
            int left = 0;
            while (left < left) {
                if (height[left] < i) {
                    left++;
                } else if (height[left] >= i) {
                    if (height[left + 1] < i) {
                        tempWater++;
                        left++;
                    }
                }
            }
        }
        return 1;
    }

    //动态规划
    public static int trap1(int[] height) {
        final int length = height.length;
        int[] l = new int[length];
        int[] r = new int[length];
        //左
        l[0] = height[0];
        for (int i = 1; i < length; i++) {
            l[i] = Math.max(height[i], l[i - 1]);
        }
        //右
        r[length - 1] = height[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            r[i] = Math.max(r[i + 1], height[i]);
        }
        //左右交集取最小-原始height
        int sum = 0;
        for (int i = 0; i < l.length; i++) {
            sum += Math.min(l[i], r[i]) - height[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap1(height));
    }

}
