package com.example.leetcode.mianshi;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: lichengcan
 * @date: 2023-09-19 17:45
 * @description
 **/
public class 多数元素 {
    //    给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
//
//    你可以假设数组是非空的，并且给定的数组总是存在多数元素。

    public static void main(String[] args) {

        多数元素 test = new 多数元素();
        int[] ints = new int[]{2,2,1,1,1,2,2};
        int[] ints1 = new int[]{3,2,3};
        System.out.println(test.majorityElement(ints));
        System.out.println(test.majorityElement(ints1));
    }
    public int majorityElement(int[] nums) {
//         Arrays.sort(nums);
//         return nums[nums.length/2];
        int count = 0;
        int key = 0;
        HashMap<Integer, Integer> map = new HashMap();
        for (int num : nums) {
            map.put(num, map.get(num)==null?1:map.get(num) + 1);
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if (entry.getValue()>count) {
                count=entry.getValue();
                key=entry.getKey();
            }
        }
        return key;
    }
}
