package com.example.leetcode.random;

import java.util.Arrays;

/**
 * @author: lichengcan
 * @date: 2023-09-13 14:12
 * @description
 **/
public class 有序数组的平方 {
//    给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
//
//
//
//    示例 1：
//
//    输入：nums = [-4,-1,0,3,10]
//    输出：[0,1,9,16,100]
//    解释：平方后，数组变为 [16,1,0,9,100]
//    排序后，数组变为 [0,1,9,16,100]
//    示例 2：
//
//    输入：nums = [-7,-3,2,3,11]
//    输出：[4,9,9,49,121]

    public static void main(String[] args) {
        有序数组的平方 n = new 有序数组的平方();
    }

    /**
     * 简单
     *
     * @param nums
     * @return
     */
    public int[] sortedSquares(int[] nums) {

        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            ans[i] = nums[i] * nums[i];
        }
        Arrays.sort(ans);
        return ans;
    }

    //    方法二：双指针
//            思路与算法
//
//    方法一没有利用「数组 nums\textit{nums}nums 已经按照升序排序」这个条件。
//    显然，如果数组 nums\textit{nums}nums 中的所有数都是非负数，那么将每个数平方后，数组仍然保持升序；
//    如果数组 nums\textit{nums}nums 中的所有数都是负数，那么将每个数平方后，数组会保持降序。
//
//    这样一来，如果我们能够找到数组 nums\textit{nums}nums 中负数与非负数的分界线，那么就可以用类似「归并排序」的方法了。
//    具体地，我们设 neg\textit{neg}neg 为数组 nums\textit{nums}nums 中负数与非负数的分界线，
//    也就是说，nums[0]\textit{nums}[0]nums[0] 到 nums[neg]\textit{nums}[\textit{neg}]nums[neg] 均为负数，
//    而 nums[neg+1]\textit{nums}[\textit{neg}+1]nums[neg+1] 到 nums[n−1]\textit{nums}[n-1]nums[n−1] 均为非负数。
//    当我们将数组 nums\textit{nums}nums 中的数平方后，
//    那么 nums[0]\textit{nums}[0]nums[0] 到 nums[neg]\textit{nums}[\textit{neg}]nums[neg] 单调递减，
//    nums[neg+1]\textit{nums}[\textit{neg}+1]nums[neg+1] 到 nums[n−1]\textit{nums}[n-1]nums[n−1] 单调递增。
//
//    由于我们得到了两个已经有序的子数组，因此就可以使用归并的方法进行排序了
//    。具体地，使用两个指针分别指向位置 neg\textit{neg}neg 和 neg+1\textit{neg}+1neg+1，
//    每次比较两个指针对应的数，选择较小的那个放入答案并移动指针。当某一指针移至边界时，将另一指针还未遍历到的数依次放入答案。


    public int[] sortedSquares1(int[] nums) {
        int n = nums.length;
        int negative = -1;
        //找到正负临界值
        for (int i = 0; i < n; ++i) {
            if (nums[i] < 0) {
                negative = i;
            } else {
                break;
            }
        }

        int[] ans = new int[n];
        //i 左指针 往左走 --  // j右指针 ++
        int index = 0, i = negative, j = negative + 1;
        //i到达最左边之前，j到右边
        while (i >= 0 || j < n) {
            //下面四个if解决了排序，每次都是找到最小的数 然后相乘 存入目标数组
            //i<0 等于全是正数
            if (i < 0) {
                ans[index] = nums[j] * nums[j];
                ++j;
                //全是负数
            } else if (j == n) {
                ans[index] = nums[i] * nums[i];
                --i;
                //左侧 < 右侧
            } else if (nums[i] * nums[i] < nums[j] * nums[j]) {
                //先把左侧更小的放到目标数组
                ans[index] = nums[i] * nums[i];
                --i;
            } else {
                //右<=左的情况
                //右侧放入到目标数组
                ans[index] = nums[j] * nums[j];
                ++j;
            }
            ++index;
        }

        return ans;
    }

}
