package com.example.leetcode.hashtable;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author: lichengcan
 * @date: 2023-09-11 15:42
 * @description
 **/
@SpringBootTest
public class 两数之和 {

    @Test
    void contextLoads() {
        int[] ints = new int[]{3, 2, 4};
        int target = 6;
        final int[] ints1 = twoSum(ints, target);
        for (int i : ints1) {
            System.out.println("i = " + i);
        }
    }


    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; i++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
