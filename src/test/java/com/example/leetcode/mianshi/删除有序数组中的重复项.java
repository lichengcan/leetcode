package com.example.leetcode.mianshi;

/**
 * @author: lichengcan
 * @date: 2023-09-19 16:26
 * @description
 **/
public class 删除有序数组中的重复项 {
//    给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。
//
//    考虑 nums 的唯一元素的数量为 k ，你需要做以下事情确保你的题解可以被通过：
//
//    更改数组 nums ，使 nums 的前 k 个元素包含唯一元素，并按照它们最初在 nums 中出现的顺序排列。nums 的其余元素与 nums 的大小不重要。
//    返回 k 。

    public int removeDuplicates(int[] nums) {
        //定义两个指针，一个left，一个right
        //如果left = right：right++
        //如果left != right: left+1位置的元素=right
        //如果right++后 = length，也要进行步骤3
        int left = 0, right = left + 1;
        while (right < nums.length) {
            if (nums[left] != nums[right]) {
                nums[left+1]=nums[right];
                left++;
            }else {
                right++;
            }
        }
        //为啥要+1 ，因为是返回长度，left是数组下标
        return left+1;
    }
}
