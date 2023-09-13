package com.example.leetcode.random;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lichengcan
 * @date: 2023-09-13 15:13
 * @description
 **/
public class 全排列 {

//    给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。



//    示例 1：

//    输入：nums = [1,2,3]
//    输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//    示例 2：

//    输入：nums = [0,1]
//    输出：[[0,1],[1,0]]
//    示例 3：

//    输入：nums = [1]
//    输出：[[1]]

    //https://leetcode.cn/problems/permutations/description/
    //TODO
    public List<List<Integer>> permute(int[] nums) {
        //结果
        List<List<Integer>> res = new ArrayList<>();
        //
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[nums.length]; // 标记元素是否已经被使用过
        dfs(nums, path, used, res);
        return res;
    }

    private void dfs(int[] nums, List<Integer> path, boolean[] used, List<List<Integer>> res) {
        if (path.size() == nums.length) { // 如果 path 中的元素个数已经等于 nums 的大小，说明找到了一种排列
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; ++i) {
            if (used[i]) { // 如果元素已经被使用过，则跳过
                continue;
            }
            path.add(nums[i]); // 将当前元素加入 path 中
            used[i] = true; // 标记当前元素已经被使用过
            dfs(nums, path, used, res); // 递归调用 dfs
            used[i] = false; // 回溯，将当前元素的使用状态重置
            path.remove(path.size() - 1); // 回溯，将当前元素从 path 中移除
        }
    }

}
