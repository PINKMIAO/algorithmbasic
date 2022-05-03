package com.weekTrain.week4;

/**
 * @author Baven
 * @date 2022/4/28 19:12
 */
public class A18_SplitSumClosed {

    public static int right(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return process(arr, 0, sum / 2);
    }

    public static int process(int[] arr, int i, int rest) {
        if (i == arr.length) {
            return 0;
        } else {
            int p1 = process(arr, i + 1, rest);
            int p2 = 0;
            if (arr[i] <= rest) {
                p2 = arr[i] + process(arr, i + 1, rest - arr[i]);
            }
            return Math.max(p1, p2);
        }

    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 7, 4, 2, 6, 4, 1};
        System.out.println(right(arr));
    }
}
