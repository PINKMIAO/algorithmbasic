package com.weekTrain.week1;

/**
 * @author Baven
 * @date 2022/3/20 22:05
 */
public class A_PreSumMerge {
    public static void main(String[] args) {
        int[] ints = generaArray(6, 10);
        printArray(ints);
        System.out.println(mergeSort(ints));
        printArray(ints);
    }

    public static int mergeSort(int[] arr) {
        if (null == arr) {
            return -1;
        }
        if (arr.length < 2) {
            return 0;
        }
        return process(arr, 0, arr.length - 1);
    }

    public static int process(int[] arr, int L, int R) {
        if (L == R) {
            return 0;
        }

        int M = L + ((R - L) >> 1);
        return process(arr, L, M) + process(arr, M + 1, R) + merge(arr, L, R, M);
    }

    public static int merge(int[] arr, int L, int R, int M) {
        int[] helper = new int[R - L + 1];
        int i = 0;
        int p = L;
        int q = M + 1;
        int ans = 0;
        while (p <= M && q <= R) {
            ans += arr[p] < arr[q] ? arr[p] * (R - q + 1) : 0;
            helper[i++] = arr[p] < arr[q] ? arr[p++] : arr[q++];
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
        return ans;
    }


    public static int[] generaArray(int max, int value) {
        int[] arr = new int[(int) (Math.random() * max) + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * value) + 1;
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
