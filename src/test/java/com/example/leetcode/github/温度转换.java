package com.example.leetcode.github;

/**
 * @author: lichengcan
 * @date: 2023-10-07 16:06
 * @description
 **/
public class 温度转换 {
    public double[] convertTemperature(double celsius) {
        double kai = celsius+273.15;
        double hua = celsius*1.8+32.00;
        double[] doubles=new double[2];
        doubles[0]=kai;
        doubles[1]=hua;
        return doubles;
    }
}
