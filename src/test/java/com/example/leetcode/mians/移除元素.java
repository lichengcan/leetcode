package com.example.leetcode.mians;

/**
 * @author: lichengcan
 * @date: 2023-09-19 16:06
 * @description
 **/
public class 移除元素 {

    public int removeElement(int[] nums, int val) {
        //双指针
        final int length = nums.length;

        int left = 0;
        for (int right = 0; right < length; right++) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }

    /**
     * 双指针优化
     * 例如序列 [1,2,3,4,5]，当 val 为 1 时，我们需要把每一个元素都左移一位
     * 直接5---1
     * @param nums
     * @param val
     * @return
     */
    public int removeElement1(int[] nums, int val) {
        //双指针
        int left = 0;
        int right = nums.length;
        while (left<right){
            if (nums[left]==val){
                //这里的right-1才是需要替换的元素所在位置
                nums[left]=nums[right-1];
                right--;
            }else {
                left++;
            }
        }
        return left;
    }
}
