package com.example.leetcode.sort;

/**
 * @author: lichengcan
 * @date: 2023-11-17 11:18
 * @description 快速排序复习
 **/
public class QuickSortPractice {


    public static void main(String[] args) {
        int[] arr = new int[]{5,1,2,4,6,8,9,3,1};

        quickSort(arr,0,arr.length-1);
        for (int i : arr) {
            System.out.println(i+" ");
        }
    }


    static void quickSort(int[] arr, int low ,int high){
        int partion = partation(arr,low,high);
        partation(arr,low,partion);
        partation(arr,partion,high);
    }

    static int partation(int[] arr ,int low,int high){
        int base = arr[high];
        while(low<high){

            while (low<high&&arr[low]<=base){
                low++;
            }
            arr[high]=arr[low];

            while(low<high&&arr[high]>=base){
                high--;
            }
            arr[low]=arr[high];

        }
        arr[low]=base;
        return low;
    }
}
