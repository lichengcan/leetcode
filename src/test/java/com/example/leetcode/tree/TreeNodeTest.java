package com.example.leetcode.tree;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class TreeNodeTest {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    AtomicInteger count = new AtomicInteger();

    /**
     * 二叉树中的伪回文路径
     */
    public int pseudoPalindromicPaths() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        traversePaths(root);
        return count.get();
    }

    public void traversePaths(TreeNode root) {
        //1 根节点为空
        if(root==null) return;
        dfs(root, new ArrayList<>());
    }

    private void dfs(TreeNode node, List<Integer> path) {
        if (node.left == null && node.right == null) {
            // 遍历到叶子节点，输出路径
            path.add(node.val);
            System.out.println(path);
            if (canFormPalindrome(path)) {
                count.incrementAndGet();
            }
            // 移除当前节点，返回上一节点继续
            path.remove(path.size() - 1);
            return;
        }

        path.add(node.val);
        //4 左节点遍历

        if (node.left != null) {
            dfs(node.left, path);
        }
        //5 右节点遍历
        if (node.right != null) {
            dfs(node.right, path);
        }
        // 6 remove
        path.remove(path.size() - 1);
    }

    /**
     * 判断数组是否有回文数的组合，比如：1，1，2可以组合：1，2，1
     * 统计出现次数为奇数的数量，只能有一个出现次数为奇数的数
     * @param nums
     * @return
     */
    public boolean canFormPalindrome(List<Integer> nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        int oddCount = 0;
        for (int count : countMap.values()) {
            if (count % 2 != 0) {
                oddCount++;
            }
        }
        return oddCount <= 1;
    }

}
