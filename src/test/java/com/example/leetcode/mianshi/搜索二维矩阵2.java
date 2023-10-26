package com.example.leetcode.mianshi;

/**
 * @author: lichengcan
 * @date: 2023-10-26 14:40
 * @description
 **/
public class 搜索二维矩阵2 {

    //编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
    //
    //每行的元素从左到右升序排列。
    //每列的元素从上到下升序排列。
    public static void main(String[] args) {
        搜索二维矩阵2 test = new 搜索二维矩阵2();
        int[][] matrix = new int[][]{{5}};
        int target = 5;
        test.searchMatrix(matrix, target);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            int sum = matrix[row][col];
            if (sum < target) {
                row++;
            } else if (sum > target) {
                col--;
            } else {
                return true;
            }
        }
        return false;
    }
}
