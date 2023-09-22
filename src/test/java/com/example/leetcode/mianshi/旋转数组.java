package com.example.leetcode.mianshi;

/**
 * @author: lichengcan
 * @date: 2023-09-19 18:19
 * @description
 **/
public class 旋转数组 {
    //    给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
//    示例 1:
//
//    输入: nums = [1,2,3,4,5,6,7], k = 3
//    输出: [5,6,7,1,2,3,4]
//    解释:
//    向右轮转 1 步: [7,1,2,3,4,5,6]
//    向右轮转 2 步: [6,7,1,2,3,4,5]
//    向右轮转 3 步: [5,6,7,1,2,3,4]
//    示例 2:
//
//    输入：nums = [-1,-100,3,99], k = 2
//    输出：[3,99,-1,-100]
//    解释:
//    向右轮转 1 步: [99,-1,-100,3]
//    向右轮转 2 步: [3,99,-1,-100]
    public static void main(String[] args) {
        旋转数组 test = new 旋转数组();
        int[] ints = new int[]{1, 2, 3, 4, 5, 6, 7};
        test.rotate(ints, 3);
    }

    /**
     * 写错了
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        final int length = nums.length;
        //10 3
        //length 9 3
        //0-6 右移 7-9放新数组最前面
        //0 - 3
        int[] res = new int[length];
        for (int i = 0; i < length - k; i++) {
            res[i + k] = nums[i];
        }
        int f = 0;
        for (int j = length - k; j < length; j++) {
            res[f] = nums[j];
            f++;
        }
        System.arraycopy(res, 0, nums, 0, length);
    }

    /**
     * 力扣官方题解
     *
     * @param nums
     * @param k
     */
    public void rotate1(int[] nums, int k) {
        int n = nums.length;
        int[] newArr = new int[n];

        for (int i = 0; i < n; ++i) {
            //i+k是代表当前元素跳后的位置，但是为了防止跳出数组，进行取模，跳出去了又会从0开始
            newArr[(i + k) % n] = nums[i];
        }
        System.arraycopy(newArr, 0, nums, 0, n);
    }

    /**
     * 环形替换 TODO
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int count = gcd(k, n);
        for (int start = 0; start < count; ++start) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
            } while (start != current);
        }
    }

    public int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }


}
