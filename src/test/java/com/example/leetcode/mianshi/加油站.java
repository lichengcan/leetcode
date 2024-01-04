package com.example.leetcode.mianshi;

/**
 * @author: lichengcan
 * @date: 2023-10-11 16:15
 * @description
 **/
public class 加油站 {
    //在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
    //
    //你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
    //
    //给定两个整数数组 gas 和 cost ，如果你可以按顺序绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。


    public int canCompleteCircuit(int[] gas, int[] cost) {

        //1 判断起点行不行，cost[i] > gas[i] 就不行

        //2 每到一个点，先加油

        //3 加完油 再判断 cost[i] > gas[i] 是否能到下一个加油站

        //4 判断 是否到达起点
        final int length = gas.length;
        for (int i = 0; i < length; i++) {
            if (cost[i] > gas[i]) {
            }

        }
        return 1;
    }

    public static void main(String[] args) {
        int a = 5, b = 5;
        int c= a+++b;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
    }

}
