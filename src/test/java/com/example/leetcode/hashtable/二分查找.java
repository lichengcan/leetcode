package com.example.leetcode.hashtable;

/**
 * @author: lichengcan
 * @date: 2023-09-12 15:20
 * @description
 **/
public class 二分查找 {

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 3, 5, 9, 11,15,22,77,64};
        System.out.println(search1(nums, 3));
    }

    public static int search(int[] nums, int target) {

        return -1;
    }

    public static int search1(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        //右指针大于等于左指针
        while (left <= right) {
            //找到中位数
            int mid = (right - left) / 2 + left;
            int num = nums[mid];
            if (num == target) {
                return mid;
                //目标值小于当前中位数的值，右指针左移
            } else if (num > target) {
                right = mid - 1;
            } else {
                //目标值大于当前中位数的值，左指针右移
                left = mid + 1;
            }
        }
        return -1;
    }


}
