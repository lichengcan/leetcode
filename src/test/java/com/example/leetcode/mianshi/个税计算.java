package com.example.leetcode.mianshi;

/**
 * @author: lichengcan
 * @email ccnaive@qq.com
 * @date: 2024-01-25 16:00
 * @description
 **/
public class 个税计算 {
    ////实现个税的计算，输入一个金额，返回要缴多少税
    //
    ////下面是各个档位的一个当前税率 :如果工资10000，那么前面5000不用交税，3000-3%，2000-10% 以此类推
    //
    ////1~5000 税率 0
    //
    ////5001~8000 3%
    //
    ////8001~17000 10%

    public static double computeRate(double num) {
        if (num < 5000) {
            return 0;
        } else if (num >= 5000 && num < 8000) {
            return (num - 5000) * 0.03;
        } else if (num >= 8000 && num < 17000) {
            return (3000) * 0.03 + (num - 8000) * 0.1;
        } else {
            return (3000) * 0.03 + (9000) * 0.1 + (num - 17000) * 0.2;
        }
    }

    public static double computeRateSwitch(double num) {
        //获取千分位
        double sum = 0;
        final double qian = num / 1000;
        switch ((int) qian) {
            case 1, 2, 3, 4, 5:
                sum = 0;
                break;

            case 6, 7, 8:
                sum += (num - 5000) * 0.03;
                break;
            case 9, 10, 11, 12, 13, 14, 15, 16, 17:
                sum += 3000 * 0.03 + (num - 8000) * 0.1;
                break;
            default:
                sum += 3000 * 0.03 + (9000) * 0.1 + (num - 17000) * 0.2;
                break;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("computeRate() = " + computeRate(4999));
        System.out.println("computeRate() = " + computeRate(6000));
        System.out.println("computeRate() = " + computeRate(9000));
        System.out.println("computeRate() = " + computeRate(13000));
        System.out.println("computeRate() = " + computeRate(18000));

        System.out.println("computeRate() = " + computeRateSwitch(4999));
        System.out.println("computeRate() = " + computeRateSwitch(1234));
        System.out.println("computeRate() = " + computeRateSwitch(6000));
        System.out.println("computeRate() = " + computeRateSwitch(9000));
        System.out.println("computeRate() = " + computeRateSwitch(8899));
        System.out.println("computeRate() = " + computeRateSwitch(13000));
        System.out.println("computeRate() = " + computeRateSwitch(18000));
    }
}
