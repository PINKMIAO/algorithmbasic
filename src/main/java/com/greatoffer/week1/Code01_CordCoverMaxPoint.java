package com.greatoffer.week1;

import java.util.Arrays;

/**
 * @author Baven
 * @date 2022/6/7 19:29
 */
public class Code01_CordCoverMaxPoint {

    public static int maxPoint1(int[] arr, int K) {
        int res = 1;
        for (int i = 0; i < arr.length; i++) {
            int nearest = nearestIndex(arr, i, arr[i] - K);
            res = Math.max(res, i - nearest + 1);
        }
        return res;
    }

    public static int nearestIndex(int[] arr, int R, int value) {
        int L = 0;
        int index = R;
        while (L <= R) {
            int mid = L + ((R - L) >> 1);
            if (arr[mid] >= value) {
                index = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return index;
    }

    public static int maxPoint2(int[] arr, int K) {
        int left = 0;
        int right = 0;
        int len = arr.length;
        int max = 0;
        while (left < len) {
            while (right < len && arr[right] - arr[left] <= K) {
                right++;
            }
            max = Math.max(max, right - (left++));
        }
        return max;
    }

    public static int[] generateArray(int len, int max) {
        int[] ans = new int[(int) (Math.random() * len) + 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = (int) (Math.random() * max);
        }
        Arrays.sort(ans);
        return ans;
    }

    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int K = 2;
        int[] arr = generateArray(10, 10);
        printArray(arr);
        System.out.println(maxPoint1(arr, K));
    }
}
