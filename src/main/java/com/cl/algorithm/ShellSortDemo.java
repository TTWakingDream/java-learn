package com.cl.algorithm;


import java.util.Arrays;

/**
 * 希尔排序：插入排序的改进版，第一批次冲出O(n^2)的排序算法，通过分组，减少比较次数，从而达到O(nlogn)的时间复杂度，
 * Donald Shell 1959年提出
 * 核心是：在快速插入的基础上，进行分组，通过分组数据间交换，减少比较次数
 */
public class ShellSortDemo {
    public static void main(String[] args) {
//        int[] arr = {10, 38,45,6,7,11,12,15,20,21,26,27,28,33,37,42,44};

        int[] arr = CommonUtils.randomArray(1000);
        System.out.println(Arrays.toString(arr));
        System.out.println(System.currentTimeMillis());
        ShellSort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(System.currentTimeMillis());
    }




    public static void ShellSort(int[] arr) {
        // 如何确定分组大小
        int length = arr.length;
        for (int gap = length / 2; gap > 0; gap /= 2) {
            for (int j = gap; j < length; j++) {
                int temp = arr[j];
                int i = j-gap ;
                for (; i >= 0 && arr[i] > temp ; i-=gap) {
                    // 对当前组的所有值往后移gap位
                    arr[i+gap] = arr[i];
                }
                arr[i+gap] = temp;
            }
        }
        // 分组交换
        // 当分组等于1时，退出循环；
    }
}
