package com.weekTrain.week1;

/**
 * @author Baven
 * @date 2022/3/20 20:16
 */
public class A01_MergeSortTrain {
    public static void main(String[] args) {
        int[] arr = generateArray(10, 10);
        printArray(arr);
        mergeSort(arr);
        printArray(arr);
    }

    public static void mergeSort(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    public static void process(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int M = L + ((R - L) >> 1);
        process(arr, L, M);
        process(arr, M + 1, R);
        merge(arr, L, R, M);
    }

    public static void merge(int[] arr, int L, int R, int M) {
        int[] helper = new int[R - L + 1];
        int p = L;
        int q = M + 1;
        int i = 0;
        while (p <= M && q <= R) {
            helper[i++] = arr[p] <= arr[q] ? arr[p++] : arr[q++];
        }
        while (p <= M) {
            helper[i++] = arr[p++];
        }
        while (q <= R) {
            helper[i++] = arr[q++];
        }
        for (i = 0; i < helper.length; i++) {
            arr[L + i] = helper[i];
        }
    }

    public static int[] generateArray(int max, int value) {
        int[] arr = new int[(int) (Math.random() * max)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * value);
        }
        return arr;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
