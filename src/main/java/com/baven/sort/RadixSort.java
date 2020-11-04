package com.baven.sort;

/**
 * 桶排序 - 基数排序
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] arr = createGroup(20, 100);
        printGroup(arr);

        radixSort(arr);
        printGroup(arr);
    }
    // for test
    public static int[] createGroup(int maxSize, int maxValue) {
        int[] arr = new int[(int)(Math.random() * maxSize)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * maxValue) + 1;
        }
        return arr;
    }
    public static void printGroup(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void radixSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        radixSort(arr, 0, arr.length - 1, maxbits(arr));
    }

    public static int maxbits(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i : arr) {
            max = Math.max(max, i);
        }
        int bits = 0;
        while (max != 0) {
            bits++;
            max /= 10;
        }
        return bits;
    }

    public static void radixSort(int[] arr, int L, int R, int bits) {
        int i = 0, j = 0;
        int[] helper = new int[R - L + 1];

        for (int d = 1; d <= bits; d++) {

            int[] count  = new int[10];
            for (i = L; i < R; i++) {
                j = getBits(arr[i], d);
                count[j]++;
            }
            for (i = 1; i < 10; i++) {
                count[i] = count[i] + count[i - 1];
            }
            for (i = R; i > L; i--) {
                j = getBits(arr[i], d);
                helper[count[j] - 1] = arr[i];
                count[j]--;
            }
            for (i = L, j = 0; i <= R; i++, j++) {
                arr[i] = helper[j];
            }
        }
    }
    public static int getBits(int x, int d){
        // (10, 0) == 1 , (10, 1) == 10 , (10 , 2) == 100
        return ((x / ((int) Math.pow(10, d - 1))) % 10) ;
    }

}
