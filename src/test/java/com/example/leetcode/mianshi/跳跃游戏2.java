package com.example.leetcode.mianshi;

/**
 * @author: lichengcan
 * @date: 2023-09-20 15:58
 * @description
 **/
public class 跳跃游戏2 {

    //给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
    //
    //每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
    //
    //0 <= j <= nums[i]
    //i + j < n
    //返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。


    public int jump(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        //选择下一步路最远
        for (int i = 0; i < length-1; i++) {
            maxPosition =Math.max(maxPosition, i+nums[i]);
            //当现在的位置==能到达最远的位置时进行跳跃
            if(i==end){
                end=maxPosition;
                steps++;
            }
        }

        return steps;
    }

    public static void main(String[] args) {

        跳跃游戏2 test = new 跳跃游戏2();
        int[] ints = new int[]{2, 3, 1, 1, 4};
        int[] ints1 = new int[]{3, 2, 1, 0, 4};
        System.out.println(test.jump(ints));
    }



}
