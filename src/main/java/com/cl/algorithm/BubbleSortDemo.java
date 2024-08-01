package com.cl.algorithm;

import java.util.Arrays;

/**
 * 核心原理，相邻位置互换，每一次循环能够把最大或者最小的元素放到最上边，实现排序；
 * 算法复杂度O(n^2)
 */
public class BubbleSortDemo {


    public static void main(String[] args) {
        int[] arr = {11,11,11,11,11,11,11,3,4,11};
        standardBubbleSort(arr);
//        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    /**
     * 我写的
     * @param arr
     */
    public static void bubbleSort(int[] arr) {

        for (int j = arr.length - 1; j > 0; ) {
            int temp = 0;
            int max = arr[0];
            int index = 0;
            for (int i = 0; i < j; i++) {
                if (arr[i] > arr[i + 1]) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;

                }
                if (max <= arr[i+1]){
                    max = arr[i+1];
                    index = i+1;
                }
            }
            if(index == j){
                j--;
            }
        }

    }

    /**
     * 标准的
     * @param arr
     */
    public static void standardBubbleSort(int[] arr){
        int temp = 0;
        for (int i = 0; i < arr.length-1; i++) {
            Boolean flag = true;
            for (int j = 0; j < arr.length-1-i; j++) {
                if(arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = false;
                }
            }
            if(flag){
                break;
            }
        }
    }
}
