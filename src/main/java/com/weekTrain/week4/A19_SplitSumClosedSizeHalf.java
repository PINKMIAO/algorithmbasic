package com.weekTrain.week4;

/**
 * @author Baven
 * @date 2022/4/28 19:34
 */
public class A19_SplitSumClosedSizeHalf {
    public static int right(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        if ((arr.length & 1) == 0) {
            return process(arr, 0, arr.length / 2, sum / 2);
        } else {
            return Math.min(process(arr, 0, arr.length / 2, sum / 2), process(arr, 0, (arr.length + 1) / 2, sum / 2));
        }
    }

    public static int process(int[] arr, int i, int size, int rest) {
        if (i == arr.length) {
            return size == 0 ? 0 : -1;
        } else {
            int p1 = process(arr, i + 1, size, rest);
            int p2 = 0;
            if (arr[i] <= rest) {
                p2 = arr[i] + process(arr, i + 1, size - 1, rest - arr[i]);
            }
            return Math.max(p1, p2);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 7, 4, 2, 6, 4, 1};
        System.out.println(right(arr));
    }
}
