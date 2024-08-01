package com.cl.algorithm;

public class AlgorithmDemo {


    public static void main(String[] args) {

    }
    public static int[] randomArray(int length){
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = (int) (Math.random() * length);
        }
        return arr;
    }

}
