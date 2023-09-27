package com.example.leetcode.github;

/**
 * @author: lichengcan
 * @date: 2023-09-27 14:41
 * @description
 **/
public class 统计有序矩阵中的负数 {

    public static void main(String[] args) {
        统计有序矩阵中的负数 test = new 统计有序矩阵中的负数();
        int[][] grid ={{4, 3, 2, -1},{3, 2, 1, -1},{1, 1, -1, -2}, {-1, -1, -2, -3}};
        System.out.println(test.countNegatives(grid));
    }

    public int countNegatives(int[][] grid) {
        int h = grid.length;
        int l = grid[0].length;
        int res = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < l; j++) {
                final int i1 = grid[i][j];
                if (i1 < 0) {
                    res++;
                }
            }
        }
        return res;
    }
}
