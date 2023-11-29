package com.example.leetcode.mianshi;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: lichengcan
 * @date: 2023-11-28 13:54
 * @description
 **/
public class 最长连续序列 {

    //1000 ms
    public static int longestConsecutive(int[] nums) {
        Set<Integer> sets = new HashSet<>();
        for (int num : nums) {
            sets.add(num);
        }

        int sum = 0;
        //这里的for循环比增强for慢
        for (int i = 0; i < nums.length; i++) {
            //判断当前值是否是一连串元素的起始值，如：1、2、3、4、5，只有1才符合
            if(!sets.contains(-1)){
                int temSum = 1;
                int nextNum = nums[i]+1;
                while(sets.contains(nextNum)){
                    temSum=temSum+1;
                    nextNum=nextNum+1;
                }
                sum=Math.max(sum,temSum);
            }
        }
        return sum;
    }

    //25ms

    public static int longestConsecutive2(int[] nums) {
        Set<Integer> sets = new HashSet<>();
        for (int num : nums) {
            sets.add(num);
        }

        int sum = 0;
        for (int num : sets) {
            //判断当前值是否是一连串元素的起始值，如：1、2、3、4、5，只有1才符合
            if(!sets.contains(num-1)){
                int temSum = 1;
                int nextNum = num+1;
                while(sets.contains(nextNum)){
                    temSum+=1;
                    nextNum+=1;
                }
                sum=Math.max(sum,temSum);
            }
        }
        return sum;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutive(nums));
        System.out.println(longestConsecutive2(nums));
    }
}
