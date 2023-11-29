package com.example.leetcode.mianshi;

/**
 * @author: lichengcan
 * @date: 2023-11-29 15:47
 * @description
 **/
public class 除自身以外数组的乘积 {
    //给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
    //
    //题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
    //
    //请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
    //
    //
    //
    //示例 1:
    //
    //输入: nums = [1,2,3,4]
    //输出: [24,12,8,6]
    //示例 2:
    //
    //输入: nums = [-1,1,0,-3,3]
    //输出: [0,0,9,0,0]

    public static int[] productExceptSelf(int[] nums) {
        final int length = nums.length;
        int[] l = new int[length];
        int[] r = new int[length];
        l[0] = 1;

        for (int i = 1; i < length; i++) {
            l[i]=nums[i-1]*l[i-1];
        }

        r[length-1] = 1;
        for (int i = length-2; i >=0; i--) {
            r[i]=nums[i+1]*r[i+1];
        }
        int[] ans = new int[length];
        for (int i = 0; i < length; i++) {
            ans[i]=l[i]*r[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        System.out.println(productExceptSelf(nums));
    }
}
