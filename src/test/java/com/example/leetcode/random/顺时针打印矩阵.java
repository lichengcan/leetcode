package com.example.leetcode.random;

/**
 * @author: lichengcan
 * @date: 2023-09-13 09:52
 * @description
 **/
public class 顺时针打印矩阵 {


    public static void main(String[] args) {

        顺时针打印矩阵 shun = new 顺时针打印矩阵();
        int[][] ints = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        final int[] ints1 = shun.spiralOrder1(ints);
        for (int i : ints1) {
            System.out.print(i + " ");
        }
    }

//    1 2 3
//    4 5 6
//    7 8 9
// 1 2 3    69   87   45
    public int[] spiralOrder1(int[][] matrix) {
        final int rowLength = matrix.length;
        //空值处理
        if (rowLength == 0) return new int[0];
        //四个循环 左-右 上-下 右-左 下-上
        int l = 0, r = matrix[0].length - 1, t = 0, b = rowLength - 1, x = 0;
        //循环条件 左<右
        //结束条件 ++l>r
        //定一个数据来存路径数据
        int[] res = new int[(r + 1) * (b + 1)];
        while (true) {
            //左--右
            for (int i = l; i <= r; i++) {
                res[x++] = matrix[t][i];
            }
            if (++t > b) break;
            //上-下    行变  纵坐标 固定
            for (int i = t; i <= b; i++) {
                res[x++] = matrix[i][r];
            }
            if (l>--r) break;
            //右--左 列变 行不变
            for (int i = r; i >= l; i--) {
                res[x++] = matrix[b][i];
            }
            if (t>--b) break;
            //下--上 行变 列不变
            for (int i = b; i >= t; i--) {
                res[x++] = matrix[i][l];
            }
            if (++l > r) break;
        }
        return res;
    }


    /**
     * 高分答案
     *
     * @param matrix
     * @return
     */
    public int[] spiralOrder(int[][] matrix) {
        //空值处理
        if (matrix.length == 0) return new int[0];
        //左 右 上 下四个指针 x用来存放结果
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
        //初始化结果数组大小
        int[] res = new int[(r + 1) * (b + 1)];
        while (true) {
            //左-右遍历
            //for循环是没到最右边就一直循环
            //res[先加1]赋值，把第t行的i列赋值
            //结束：for循环结束一次，t加1，代表标记已经遍历过的，如果t+1后大于b结束
            for (int i = l; i <= r; i++) res[x++] = matrix[t][i]; // left to right.
            if (++t > b) break;
            //上到下遍历
            for (int i = t; i <= b; i++) res[x++] = matrix[i][r]; // top to bottom.
            if (l > --r) break;
            for (int i = r; i >= l; i--) res[x++] = matrix[b][i]; // right to left.
            if (t > --b) break;
            for (int i = b; i >= t; i--) res[x++] = matrix[i][l]; // bottom to top.
            if (++l > r) break;
        }
        return res;
    }
}
