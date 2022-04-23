package com.weekTrain.week1;

/**
 * @author Baven
 * @date 2022/3/29 10:02
 */
public class E01_CountOrRadixSort {
    public static void main(String[] args) {
        int[] arr = generateArray(15, 50);
        printArray(arr);
        // CountSort(arr);
        RadixSort(arr);
        printArray(arr);
    }

    public static void CountSort(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        int max = Integer.MIN_VALUE;
        for (int i : arr) {
            max = Math.max(max, i);
        }
        int[] bucket = new int[max + 1];
        for (int i : arr) {
            bucket[i]++;
        }
        int index = 0;
        for (int i = 0; i < bucket.length; i++) {
            for (int j = 0; j < bucket[i]; j++) {
                arr[index++] = i;
            }
            // while (bucket[i]-- > 0) {
            //     arr[index++] = i;
            // }
        }
    }

    public static void RadixSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        RadixSort(arr, 0, arr.length - 1, maxBits(arr));
    }

    public static void RadixSort(int[] arr, int L, int R, int digit) {
        int[] helper = new int[R - L + 1];
        int i = 0;
        int j = 0;
        for (int d = 1; d <= digit; d++) {
            int[] count = new int[10];
            for (i = L; i <= R; i++) {
                j = getDigit(arr[i], d);
                count[j]++;
            }
            for (i = 1; i < count.length; i++) {
                count[i] = count[i] + count[i - 1];
            }
            for (i = R; i >= L; i--) {
                j = getDigit(arr[i], d);
                helper[count[j] - 1] = arr[i];
                count[j]--;
            }
            for (i = L, j = 0; i <= R; i++) {
                arr[i] = helper[i];
            }
        }

    }

    public static int getDigit(int num, int d) {
        return ((num / ((int) Math.pow(10, d - 1))) % 10);
    }

    public static int maxBits(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i : arr) {
            max = Math.max(max, i);
        }
        int ans = 0;
        while (max != 0) {
            ans++;
            max /= 10;
        }
        return ans;
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
