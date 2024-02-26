package com.example.leetcode.Switch;

/**
 * @author: lichengcan
 * @email ccnaive@qq.com
 * @date: 2024-02-26 16:23
 * @description
 **/
public class SwitchCase {
    /**
     * case穿透
     * @param args
     */
    public static void main(String[] args) {
        switch (1) {
            case (2):
                System.out.println("2 = ");
            default:
                System.out.println("default = ");
            case (3):
                System.out.println("3 =");
        }
    }
}
