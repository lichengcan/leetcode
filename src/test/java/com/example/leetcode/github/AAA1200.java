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

        String data = "2019-02-09";
        test.dayOfYear(data);

        String word = "abcdefd";
        char ch = 'd';
        test.reversePrefix(word, ch);

        int[][] ints = new int[][]{{2, 0, 0, 1}, {0, 3, 1, 0}, {0, 5, 2, 0}, {4, 0, 0, 2}};
        System.out.println("test.checkXMatrix(ints) = " + test.checkXMatrix(ints));

        int[] salary = new int[]{4000, 3000, 1000, 2000};
        System.out.println(test.average(salary));

        int[][] ints1 = new int[][]{{1,2}};

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


    //82
    public int countSeniors(String[] details) {
        int res = 0;
        for (String detail : details) {
            Integer substring = Integer.valueOf(detail.substring(11, 13));
            if (substring > 60) {
                res++;
            }
        }
        return res;
    }


    public int dayOfYear(String date) {
        int[] nums = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        Integer substring1 = Integer.valueOf(date.substring(5, 7));
        String substring2 = date.substring(8, 10);
        Integer integer1 = Integer.valueOf(date.substring(0, 4));

        int res = 0;
        for (Integer integer = 1; integer < substring1; integer++) {
            res += nums[integer];
        }
        if ((integer1 % 400 == 0 || (integer1 % 4 == 0 && integer1 % 100 != 0)) && substring1 > 2) {
            res++;
        }
        return res + Integer.valueOf(substring2);
    }

    //86 反转单词前缀
    public String reversePrefix(String word, char ch) {
        int i = word.indexOf(ch);
        final int length = word.length();
        String pre = word.substring(0, i + 1);
        String end = word.substring(i + 1, length);
        final char[] chars = pre.toCharArray();

        StringBuilder sb = new StringBuilder();
        for (int i1 = chars.length - 1; i1 >= 0; i1--) {
            sb.append(chars[i1]);
        }
        return sb + end;
    }

    // 88 判断矩阵是否是一个 X 矩阵
    public boolean checkXMatrix(int[][] grid) {
        //主要是怎么找到对角线上的数据
        //i==j : \
        //i+j==n-1 /
        final int length = grid.length;//行
        //矩阵遍历
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i == j || ((i + j) == (length - 1))) {
                    if (grid[i][j] == 0) {
                        return false;
                    }
                } else if (grid[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public double average(int[] salary) {
        Arrays.sort(salary);
        int sum = 0;
        int length = salary.length;
        for (int i = 1; i < length - 1; i++) {
            sum += salary[i];
        }
        return Double.valueOf(sum) / (length - 2);
    }


//   997 找到小镇的法官
//小镇里有 n 个人，按从 1 到 n 的顺序编号。传言称，这些人中有一个暗地里是小镇法官。
//
//如果小镇法官真的存在，那么：
//
//小镇法官不会信任任何人。
//每个人（除了小镇法官）都信任这位小镇法官。
//只有一个人同时满足属性 1 和属性 2 。...
    public static int findJudge(int n, int[][] trust) {
        int[] ru = new int[n+1];
        int[] chu = new int[n+1];

        for (int[] ints : trust) {
            //统计被信任的人
            final int a = ints[0];//当前人
            final int b = ints[1];//相信人
            ru[b]++;
            chu[a]++;
        }

        for (int j = 1; j <=n ; j++) {
            //当前被信任的票数=n-1 且这个人 不相信任何人
            if(ru[j]==n-1&&chu[j]==0){
                return j;
            }
        }
        return -1;
    }

    public int[] twoSum(int[] nums, int target) {
        return null;
    }

}
