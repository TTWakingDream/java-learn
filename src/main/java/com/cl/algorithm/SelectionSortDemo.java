package com.cl.algorithm;

import java.util.Arrays;

/**
 * 遍历数列，选择最小的一个，放到第一位；依此方法，遍历所有；知道排序完成；
 * 算法复杂度总是O(n^2)，唯一的好处就是不需要额外的内存空间，适合小规模数据排序
 */
public class SelectionSortDemo {


    public static void main(String[] args) {
        int[] arr = {5, 3, 6, 2, 1, 9, 4, 7, 8};
//        selectionSort(arr);
        standardSelectionSort(arr);
        System.out.println(Arrays.toString(arr));

    }


    /**
     * 我的
     * @param arr
     */
    public static void selectionSort(int[] arr){

        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            int index = i;
            for (int j = i; j < arr.length; j++) {
                if(temp > arr[j]) {
                    temp = arr[j];
                    index = j;
                }
            }
            arr[index] = arr[i];
            arr[i] = temp;
        }
    }


    public static void standardSelectionSort(int[] arr){
        int minIndex = 0;
        int temp;
        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[minIndex] > arr [j]){
                    minIndex = j;
                }
            }
            temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}
