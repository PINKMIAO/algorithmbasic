package com.weekTrain.week1;

/**
 * @author Baven
 * @date 2022/3/21 12:12
 */
public class A_ReversePair {
    public static void main(String[] args) {
        int[] arr = generaArray(10, 10);
        printArray(arr);
        System.out.println(mergeSort(arr));
        printArray(arr);
    }

    public static int mergeSort(int[] arr) {
        if (null == arr || arr.length < 2) {
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
        int p = M;
        int q = R;
        int i = helper.length - 1;
        int ans = 0;
        while (p >= L && q >= M + 1) {
            ans += arr[p] > arr[q] ? (q - M) : 0;
            helper[i--] = arr[p] > arr[q] ? arr[p--] : arr[q--];
        }
        while (p >= L) {
            helper[i--] = arr[p--];
        }
        while (q > M) {
            helper[i--] = arr[q--];
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
