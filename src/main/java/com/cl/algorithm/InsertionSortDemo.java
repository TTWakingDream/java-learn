package com.cl.algorithm;


import java.util.Arrays;

/**
 * 插入排序，通过构建有序队列来插入，实现有序目的, 实际将第一个数看作有序数列，从第二个元素开始，跟之前的有序数列比较，找到插入位置插入进去，插入位置往后的元素依次往后移1位；
 *
 */
public class InsertionSortDemo {

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 4,11,55,66,99,88,77,66,55,44,33,22,11,0};
//        insertionSort(arr);
//        insertionSortOptimized(arr);
        standardInsertionSort(arr);
        System.out.println(Arrays.toString(arr));

    }


    /**
     * 最简单直接，找到有序数组的插入位置，记录下标，再把有序数组依次往后移动；最后把该值填入插入位置
     * @param arr
     */
    public static void insertionSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int index = i;
            for (int j = i-1; j >= 0; j--) {
                if(temp < arr[j]){
                    index = j;
                }
            }
            for (int j = i ; j > index ; ) {
                arr[j] = arr[--j];
            }
            arr[index] = temp;

        }
    }


    /**
     * 优化，对比有序数组，小于两个互换位置，依次进行；优点是减少循环次数
     */
    public static void insertionSortOptimized(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 ; j--) {
                if(arr[j] < arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
    }

    /**
     * 标准版
     */

    public static void standardInsertionSort(int[] arr){
        int preIndex, current;
        for (int i = 1; i < arr.length; i++) {
            preIndex = i -1 ;
            current = arr[i];
            while (preIndex >= 0 && arr[preIndex] > current){
                arr[preIndex+1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex+1] = current;
        }
    }
}
