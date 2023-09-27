package com.example.leetcode.github;

/**
 * @author: lichengcan
 * @date: 2023-09-27 15:13
 * @description
 **/
public class 统计位数为偶数的数字 {
    public int findNumbers(int[] nums) {
        int res = 0;
        for(int num : nums){
            if (String.valueOf(num).length()%2==0) {
                res++;
            }
        }
        return res;
    }
}
