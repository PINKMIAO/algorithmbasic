package com.baven;

/**
 * How Many Numbers Are Smaller Than the Current Number
 *
 * Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it.
 * That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].
 *
 * Return the answer in an array.
 */
public class Algorithm {
    public static void main(String[] args) {
        int[] nums = {9,5,2,7,3,8};
        int[] ans = new Solution().mergeSort(nums);
        for (int an : ans) {
            System.out.print(an + " ");
        }
    }
}


class Solution {
    // Violent Solution
    public int[] solution(int[] nums){
        int[] helper = new int[nums.length];

        for (int i = 0; i < helper.length; i++) {
            int count = 0;
            for (int j = 0; j < helper.length; j++) {
                if (nums[i] > nums[j]){
                    count++;
                }
            }
            helper[i] = count;
        }
        return helper;
    }

    // not Recursion
    public int[] mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        int N = arr.length;
        int mergeSize = 1;// 当前有序的，左组长度
        while (mergeSize < N) { // log N
            int L = 0;
            // 0....
            while (L < N) {
                // L...M  左组（mergeSize）
                int M = L + mergeSize - 1;
                if (M >= N) {
                    break;
                }
                //  L...M   M+1...R(mergeSize)
                int R = Math.min(M + mergeSize, N - 1);
                merge(arr, L, M, R);
                L = R + 1;
            }
            if (mergeSize > N / 2) {
                break;
            }
            mergeSize <<= 1;
        }
        return arr;
    }

    // recursion
    public void mergeSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }
    // 👇
    public void process(int[] arr, int L, int R) {
        if (L == R) { // base case
            return;
        }
        int mid = L + ((R - L) >> 1);
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    public void merge(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        while (p1 <= M && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        // 要么p1越界了，要么p2越界了
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
    }
}
