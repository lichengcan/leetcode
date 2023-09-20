package com.example.leetcode.mianshi;

import java.util.Arrays;

/**
 * @author: lichengcan
 * @date: 2023-09-19 15:22
 * @description
 **/
public class 合并两个有序数组 {

//    给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
//
//    请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
//
//    注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，

//    其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。

    public static void main(String[] args) {
        合并两个有序数组 test = new 合并两个有序数组();
        int[] num1 = new int[]{1,2,3,0,0,0};
        int[] num2 = new int[]{2,5,6};
        final int length1 = num1.length;
        final int length2 = num2.length;
        test.merge(num1,length1-length2,num2,length2);
    }

    /**
     * 简单实现
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        for (int i = 0; i != n; ++i) {
            nums1[m + i] = nums2[i];
        }

        Arrays.sort(nums1);
    }

    /**
     * 双指针实现
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int m1=0,n2=0;
        int[] res = new int[m];
        int i  = 0;
        while (m1<m||n2<n){
            if (nums1[m1]<nums2[n2]) {
                res[i]=nums1[m1];
                m1++;
            }else {
                res[i]=nums2[n2];
                n2++;
            }
            i++;
        }
    }

    public void merge3(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0;
        //m 数组1非0大小 n数组2大小
        //合并后总容量
        int[] sorted = new int[m + n];
        // 当前值
        int cur;
        while (p1 < m || p2 < n) {
            //数组1遍历结束
            if (p1 == m) {
                cur = nums2[p2++];
                //数组2结束
            } else if (p2 == n) {
                cur = nums1[p1++];
                //1<2
            } else if (nums1[p1] < nums2[p2]) {
                cur = nums1[p1++];
            } else {
                cur = nums2[p2++];
            }
            //每次遍历都找到最小的数
            sorted[p1 + p2 - 1] = cur;
        }
        //覆盖返回
        for (int i = 0; i != m + n; ++i) {
            nums1[i] = sorted[i];
        }
    }

}
