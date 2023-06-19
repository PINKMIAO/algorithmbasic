package com.pulsone;

/**
 * @author Baven
 * @date 2022/7/22 14:44
 */
public class MergeSort {
    public static void mergesort(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length);
    }

    public static void process(int[] arr, int L, int R) {

    }

    public static void main(String[] args) {
        int[] arr = generateRandomArray(10, 10);
        printArray(arr);
        mergesort(arr);
        printArray(arr);
    }

    public static int[] generateRandomArray(int max, int value) {
        int[] arr = new int[(int) (Math.random() * max)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * value);
        }
        return arr;
    }

    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
