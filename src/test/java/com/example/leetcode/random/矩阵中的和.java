package com.example.leetcode.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class 矩阵中的和 {
    //    给你一个下标从 0 开始的二维整数数组 nums 。一开始你的分数为 0 。你需要执行以下操作直到矩阵变为空：
//
//    矩阵中每一行选取最大的一个数，并删除它。如果一行中有多个最大的数，选择任意一个并删除。
//    在步骤 1 删除的所有数字中找到最大的一个数字，将它添加到你的 分数 中。
//    请你返回最后的 分数 。
    public static void main(String[] args) {
        矩阵中的和 t = new 矩阵中的和();
        /*[[7,2,1],[6,4,2],[6,5,3],[3,2,1]]*/
        int[][] ints = new int[][]{{7, 2, 1}, {6, 4, 2}, {6, 5, 3}, {3, 2, 1}};

        System.out.println(t.matrixSum(ints));
        System.out.println(t.matrixSum1(ints));
    }

    public int matrixSum(int[][] nums) {
        for (int[] num : nums) {
            Arrays.sort(num);
        }
        //获取到第一行的数据放到list
        final int rows = nums.length;
        final int columns = nums[0].length;
        int res = 0;
        for (int i = 0; i < columns; i++) {
            int temp = 0;
            for (int[] num : nums) {
                temp=Math.max(temp,num[i]);
            }
            res+=temp;
        }
        return res;
    }

    public int matrixSum1(int[][] nums) {
        for (int[] num : nums) {
            Arrays.sort(num);
        }
        int ans = 0;
        for (int j = 0; j < nums[0].length; ++j) {
            int mx = 0;
            for (int[] row : nums) {
                mx = Math.max(mx, row[j]);
            }
            ans += mx;
        }
        return ans;
    }
}
