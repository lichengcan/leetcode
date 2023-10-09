package com.example.leetcode.github;

import java.util.*;

/**
 * @author: lichengcan
 * @date: 2023-10-07 16:21
 * @description
 **/
public class AAA1200 {

    //34.基于排列构建数组
    public int[] buildArray(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[nums[i]];
        }
        return ans;
    }

    //35.好数对的数目
    public int numIdenticalPairs(int[] nums) {
        final int length = nums.length;
        int res = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                if (i < j && nums[i] == nums[j]) {
                    res++;
                }
            }
        }
        return res;
    }

    //36 在长度 2N 的数组中找出重复 N 次的元素
    public int repeatedNTimes(int[] nums) {
        HashMap<Integer, Integer> list = new HashMap<>();
        for (int num : nums) {
            if (list.containsKey(num)) {
                list.put(num, list.get(num) + 1);
            } else {
                list.put(num, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : list.entrySet()) {
            if (entry.getValue().equals(nums.length / 2)) {
                return entry.getKey();
            }
        }
        return 0;
    }

    //37 字母在字符串中的百分比
    public int percentageLetter(String s, char letter) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            final char c = s.charAt(i);
            if (c == letter) {
                count++;
            }
        }
        return count * 100 / s.length();
    }

    //38 将数字变成 0 的操作次数
    public int numberOfSteps(int num) {
        int res = 0;
        while (num != 0) {
            if (num % 2 == 0) {
                //1.进行除法
                num = num / 2;
            } else {
                num--;
            }
            res++;
        }
        return res;
    }

    //39 生成每种字符都是奇数个的字符串
    public String generateTheString(int n) {
        StringBuilder sb = new StringBuilder();
        if (n % 2 == 0) {
            sb.append("a");
            for (int i = 0; i < n - 1; i++) {
                sb.append("b");
            }
        } else {
            for (int i = 0; i < n; i++) {
                sb.append("b");
            }
        }
        return sb.toString();
    }


    // 75 重新排列字符串
    public String restoreString(String s, int[] indices) {
        StringBuilder sb = new StringBuilder();
        Character[] cc = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            final char c = s.charAt(i);
            cc[indices[i]] = c;
        }
        for (Character character : cc) {
            sb.append(character);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        AAA1200 test = new AAA1200();
        int[] nums = new int[]{1, 2, 3, 4};
        int[][] queries = new int[][]{{1, 0}, {-3, 1}, {-4, 0}, {2, 3}};
        test.sumEvenAfterQueries(nums, queries);
    }

    //80 查询后的偶数和
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        final int length = queries.length;

        int[] sums = new int[length];
        int tempSum = 0;
        for (int x : nums) tempSum += x % 2 == 0 ? x : 0;
        for (int i = 0; i < length; i++) {
            int val = queries[i][0];
            int index = queries[i][1];
            //如果原值是偶 删
            if (nums[index] % 2 == 0) tempSum -= nums[index];
            nums[index] += val;
            //更改后是偶数 加
            if (nums[index] % 2 == 0) tempSum += nums[index];
            sums[i] = tempSum;
        }
        return sums;
    }

    //81 最小绝对差
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();
        int cha = arr[1] - arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(arr[i]);
            list.add(arr[i + 1]);
            int tem = arr[i + 1] - arr[i];
            if (tem < cha) {
                cha = tem;
                res.clear();
            }
            if (tem == cha) {
                res.add(list);
            }
        }
        return res;
    }


    public int countSeniors(String[] details) {

    }

}
