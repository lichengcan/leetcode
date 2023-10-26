package com.example.leetcode.mianshi;

/**
 * @author: lichengcan
 * @date: 2023-10-26 10:59
 * @description
 **/
public class 验证回文串 {

    //如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
    //
    //字母和数字都属于字母数字字符。
    //
    //给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。

    public static void main(String[] args) {
        验证回文串 test = new 验证回文串();
        String s = "A man, a plan, a canal: Panama";
        test.isPalindrome(s);
    }

    public boolean isPalindrome(String s) {
        //大小写转换
        String s1 = s.toLowerCase();
        //移除
        String s2 = removeNonAlphaNumeric(s1);
        byte[] bytes = s2.getBytes();
        int left = 0, right = bytes.length - 1;
        while (left < right) {
            if (bytes[left] != bytes[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    static String removeNonAlphaNumeric(String s) {
        return s.replaceAll("[^a-zA-Z0-9]", "");
    }
}
