package com.weekTrain.week1;

/**
 * @author Baven
 * @date 2022/3/21 16:05
 */
public class A_CountOfRangSum {
    public static int flag = 0;

    public static void main(String[] args) {
        // long[] arr = generaArray(10, 10);
        // arr[3] = 3; arr[4] = 2; arr[5] = 1;
        long[] arr = new long[6];
        arr[0] = -3;
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = -2;
        arr[4] = 2;
        arr[5] = -2;
        printArray(arr);
        System.out.println(countRangeSum(arr, -3, -1));
    }

    public static int countRangeSum(long[] arr, int lower, int upper) {
        if (null == arr || arr.length == 0) {
            return 0;
        }
        long[] sum = new long[arr.length];
        sum[0] = arr[0];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + arr[i];
        }
        printArray(sum);
        return process(sum, 0, arr.length - 1, lower, upper);
    }

    public static int process(long[] arr, int L, int R, int lower, int upper) {
        if (L == R) {
            return arr[L] >= lower && arr[L] <= upper ? 1 : 0;
        }

        int M = L + ((R - L) >> 1);
        return process(arr, L, M, lower, upper)
                + process(arr, M + 1, R, lower, upper)
                + merge(arr, L, R, M, lower, upper);
    }

    public static int merge(long[] arr, int L, int R, int M, int lower, int upper) {
        int ans = 0;
        int windowL = L;
        int windowR = L;
        for (int i = M + 1; i <= R; i++) {
            long min = arr[i] - upper;
            long max = arr[i] - lower;
            // 条件忘加windowR的边界，不能大于M，下同
            while (windowR <= M && arr[windowR] <= max) {
                windowR++;
            }
            while (windowL <= M && arr[windowL] < min) {
                windowL++;
            }
            ans += windowR - windowL;
        }

        long[] helper = new long[R - L + 1];
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

    public static long[] generaArray(int max, int value) {
        long[] arr = new long[(int) (Math.random() * max) + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * value) + 1;
        }
        return arr;
    }

    public static void printArray(long[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
