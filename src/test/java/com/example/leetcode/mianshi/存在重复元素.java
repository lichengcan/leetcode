package com.example.leetcode.mianshi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author: lichengcan
 * @date: 2023-11-28 11:18
 * @description
 **/
public class 存在重复元素 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, List<Integer>> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> ints = new ArrayList<>();
            if (map.containsKey(nums[i])) {
                ints.addAll(map.get(nums[i]));
                List<Integer> list = map.get(nums[i]);
                for (Integer integer : list) {
                    if (Math.abs(integer -i) <= k) {
                        return true;
                    }
                }
            }
            ints.add(i);
            map.put(nums[i], ints);
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
