package com.example.leetcode.mianshi;

/**
 * @author: lichengcan
 * @date: 2023-09-20 15:58
 * @description
 **/
public class 跳跃游戏 {

    //给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
    //
    //判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。


    public boolean canJump(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            //如果当前位置已经大于能跳的最远位置，则false
            if (i > k) return false;
            //i+nums[i] 当前能跳到的最远位置
            k = Math.max(k, i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {

        跳跃游戏 test = new 跳跃游戏();
        int[] ints = new int[]{2, 3, 1, 1, 4};
        int[] ints1 = new int[]{3, 2, 1, 0, 4};
        System.out.println(test.canJump(ints));
        System.out.println(test.canJump1(ints));
        System.out.println(test.canJump1(ints1));
    }

    public boolean canJump1(int[] nums) {
        int k = 0;
        //为什么i<=k
        for (int i = 0; i <= k; i++) {
            //当前能跳的距离
            int temp = i + nums[i];
            //更新跳的最远
            k = Math.max(k, temp);
            //如果最远>=最后一个元素的下标
            if (k >= nums.length - 1) return true;
        }
        return false;
    }

}
