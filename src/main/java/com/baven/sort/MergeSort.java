package com.baven.sort;

/**
 * 归并排序
 */
public class MergeSort {

    public static void main(String[] args) {
        int maxSize = 20;
        int maxValue = 20;
        int[] nums = createGroup(maxSize, maxValue);

        printGroup(nums);
        process(nums, 0, nums.length - 1);
        printGroup(nums);
    }

    public static void process(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int M = L + ((R - L) >> 1);
        process(arr, L, M);
        process(arr, M + 1, R);
        merge(arr, L, M, R);
    }

    public static void merge(int[] nums, int l, int m, int r) {
        int[] helper = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = m + 1;
        while(p1 <= m && p2 <= r) {
            helper[i++] = nums[p1] < nums[p2] ? nums[p1++] : nums[p2++];
        }
        while (p1 <= m) {
            helper[i++] = nums[p1++];
        }
        while (p2 <= r) {
            helper[i++] = nums[p2++];
        }
        for (i = 0; i < helper.length; i++) {
            nums[l + i] = helper[i];
        }
    }

    public static int[] createGroup(int maxSize, int maxValue) {
        int[] arr = new int[(int) (Math.random() * maxSize)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * maxValue);
        }
        return arr;
    }
    public static void printGroup(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
