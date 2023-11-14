package com.example.leetcode.sort;

/**
 * @author: lichengcan
 * @date: 2023-11-14 15:29
 * @description
 **/
public class QuickSort {

    public static void main(String[] args) {
        int[] array = {64, 12, 34, 25, 12, 22, 11, 90, 111, 2, 7, 1, 88, 33};
        int[] array2 = {64, 12, 34, 25, 12, 22, 11, 90, 111, 2, 7, 1, 88, 33};
        System.out.println("原始数组：");
        for (int anInt : array) {
            System.out.print(" " + anInt);
        }
        int[] ints = quickSort(array, 0, array.length - 1);


        System.out.println("\n排序后的数组：");
        for (int anInt : ints) {
            System.out.print(" " + anInt);
        }
    }

    public static int[] quickSort(int array[], int start, int end) {
        //循环条件
        if (start < end) {
            int partion = partion(array, start, end);
            //继续给base位置左侧的元素排序
            quickSort(array, start, partion - 1);
            //继续给base位置右侧的元素排序
            quickSort(array, partion + 1, end);
        }
        return array;
    }

    public static int partion(int array[], int left, int right) {
        int base = array[left];//基准元素
        //继续循环
        while (left < right) {
            //从右往左走，因为替换的时候是和左侧的base进行交换，左侧应该放小的，所以需要找到小的数时才进行替换
            //所以下面需要用一个while
            //从右--》左，找到大的就--，找到小的就替换base位置
            //下面array[right] >= base一定要加上‘=’号，不然在相等的时候指针就不动了，会进入无线循环
            while (left < right && array[right] >= base) {
                right--;
            }
            //小的，替换base位置的值
            //这时base位置变成了 array[right]
            array[left] = array[right];
            //从左--》右，找到小的就--
            while (left < right && array[left] <= base) {
                left++;
            }
            //找到大的就替换base位置的值
            //这时base位置变成array[left]
            array[right] = array[left];
        }
        //当left = right 代表当前一小轮结束了
        //用base值替换指针位置的值
        array[left] = base;
        return left;
    }

}
