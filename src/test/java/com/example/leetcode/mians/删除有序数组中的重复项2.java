package com.example.leetcode.mians;

/**
 * @author: lichengcan
 * @date: 2023-09-19 16:50
 * @description
 **/
public class 删除有序数组中的重复项2 {

    public int removeDuplicates(int[] nums) {
        //两个指针
        //每次拿两个元素进行添加，新拿的两个元素和之前的后面一个是否相同，相同则跳过
        int skip = 2;
       return removeDup(nums,skip);
    }

    /**
     * 保留允许连续重复次数内的元素
     * 从而实现了在不创建新数组的情况下删除重复项
     * @param nums
     * @param k
     * @return
     */
    private int removeDup(int[] nums, int k) {
        //当前指针
        int cur = 0;
        for (int x : nums) {
            //cur < k ，如果k=2，代表前面2个元素无条件保留
            //nums[cur-k]保留元素中最右边的 和当前元素 不相等：进行保留
            if (cur < k || nums[cur - k] != x)
                nums[cur++] = x;
        }
        return cur;
    }
}
