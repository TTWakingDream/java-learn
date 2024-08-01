package com.cl.algorithm;


import jdk.jfr.DataAmount;
import lombok.Data;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 归并排序：分治法的典型；
 * 核心思维：通过递归拆分，每次拆分成两份，直至每个子数组长度小于等于2；
 * 再通过递归合并的思维，将子数组全部合并起来；（至于合并过程排序算法，可以自由选择）
 */
@Data
public class MergeSortDemo {

    private static AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) {
        int[] arr1 = CommonUtils.randomArray(5);
        int[] arr2 = CommonUtils.randomArray(5);
        System.out.println("原始数组：" + Arrays.toString(arr1));
        System.out.println("原始数组：" + Arrays.toString(arr2));
//        int[][] arrList = new int[10][10];
//        arraySplit(arr, arrList);
        int[] merge = merge(arr1, arr2);
        System.out.println("目标list" + Arrays.toString(merge));
    }

    public static void mergeSort(int[] arr){
        // 递归拆分
        if(arr.length < 2) {
            return;
        }

    }


    public static int[] merge(int[] arr1, int[] arr2) {
        int arr1Len = arr1.length;
        int arr2Len = arr2.length;
        int i = 0;
        int[] arr = new int[arr1Len + arr2Len];
        while (arr1Len > 0 && arr2Len > 0) {

            if (arr1[0] > arr2[0]) {
                arr[i++] = arr2[0];
                arr2 = Arrays.copyOfRange(arr2, 1, arr2Len--);
            } else {
                arr[i++] = arr1[0];
                arr1 = Arrays.copyOfRange(arr1, 1, arr1Len--);
            }
        }
        while (arr1Len > 0) {
            arr[i++] = arr1[0];
            arr1 = Arrays.copyOfRange(arr1, 1, arr1Len--);
        }
        while (arr2Len > 0) {
            arr[i++] = arr2[0];
            arr2 = Arrays.copyOfRange(arr2, 1, arr2Len--);
        }
        return arr;
    }
//
//    成功的定义：
//        耐心和细心
//        坚持和乐观

//    public static void arraySplit(int[] arr, int[][] arrList){
//        System.out.println("counter:"+counter);
//        if(arr == null || arr.length <= 2){
//            int andIncrement = counter.getAndIncrement();
//            arrList[andIncrement] = arr;
//            return;
//        }
//        int length = arr.length;
//        int count = length;
//        length /= 2;
//        int[] leftArr = new int[length];
//        int[] rightArr = new int[count - length];
//        System.arraycopy(arr, 0, leftArr, 0, leftArr.length);
//        System.out.println("leftArr" + Arrays.toString(leftArr));
//        System.arraycopy(arr, leftArr.length, rightArr, 0, rightArr.length);
//        System.out.println("rightArr" + Arrays.toString(rightArr));
//        arraySplit(leftArr, arrList);
//        arraySplit(rightArr, arrList);
//    }
}
