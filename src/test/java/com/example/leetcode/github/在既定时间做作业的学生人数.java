package com.example.leetcode.github;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: lichengcan
 * @date: 2023-09-27 14:18
 * @description
 **/
public class 在既定时间做作业的学生人数 {
    public static void main(String[] args) {
        int[] startTime = {19, 71, 9, 89, 57, 47, 57, 81};
        int[] endTime = {93, 88, 23, 96, 82, 53, 91, 95};
        在既定时间做作业的学生人数 test= new 在既定时间做作业的学生人数();
        System.out.println(test.busyStudent(startTime, endTime, 63));
    }

    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int num = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (startTime[i]<=queryTime&&queryTime<=endTime[i]) {
                num++;
            }
        }
        return num;
    }
}
