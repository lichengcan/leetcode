package com.example.leetcode.mianshi;

public class QuickSort {
    public static void main(String[] args) {
//        int[] array = {12, 4, 5, 6, 7, 3, 1, 15};
        int[] array = {64, 12, 34, 25, 12, 22, 11, 90, 111, 2, 7, 1, 88, 33};
//        int[] array = {5,1,2,4,6,8,9,3};
        System.out.println("原始数组：");
        printArray(array);

        quickSort(array, 0, array.length - 1);

        System.out.println("排序后的数组：");
        printArray(array);
    }

    static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            // 获取分区点索引
            int partitionIndex = partition(array, low, high);

            // 递归对分区点左右两侧进行排序
            quickSort(array, low, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, high);
        }
    }

    static int partition(int[] array, int low, int high) {
        // 选择最右边的元素作为基准
        int pivot = array[high];

        // 小于基准的元素放在左边，大于基准的元素放在右边
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                swap(array, i, j);
            }
        }

        // 将基准元素放在正确的位置
        swap(array, i + 1, high);

        // 返回基准元素的索引
        return i + 1;
    }

    static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
