package com.weekTrain.week1;

/**
 * @author Baven
 * @date 2022/3/21 13:58
 */
public class A_BiggerThanRightTwice {
    public static void main(String[] args) {
        // int[] arr = generaArray(10, 10);
        int[] arr = new int[6];
        arr[0] = 6; arr[1] = 5; arr[2] = 4; arr[3] = 3; arr[4] = 2; arr[5] = 1;
        printArray(arr);
        System.out.println(testtt(arr));
        printArray(arr);
    }

    public static int reversePairs(int[] arr) {
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
        return process(arr, L, M)
                + process(arr, M + 1, R)
                + merge(arr, L, R, M);
    }

    public static int merge(int[] arr, int L, int R, int M) {
        int ans = 0;
        int windowR = M + 1;
        for (int i = L; i <= M; i++) {
            while (windowR <= R && arr[i] > arr[windowR] * 2) {
                windowR++;
            }
            // 左侧的数 如果这么对比大于右侧，那么左侧当前数 后方的所有数都大于右侧当前数，
            // 为了不漏掉已经++的windowR，所以每次for后要补进去
            ans += windowR - M - 1;
        }

        int[] helper = new int[R - L + 1];
        int i = 0;
        int p = L;
        int q = M + 1;
        while (p <= M && q <= R) {
            helper[i++] = arr[p] >= arr[q] ? arr[q++] : arr[p++];
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

    public static int testtt(int[] arr) {
        int ans = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if ((long)arr[i] > (long)arr[j] * 2) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
