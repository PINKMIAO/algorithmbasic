package com.baven.sort;

/**
 * 计数排序
 */
public class CountSort {

    public static void main(String[] args) {
        int[] arr = createGroup(10, 10);
        printGroup(arr);
        countSort(arr);
        printGroup(arr);
    }

    // for test
    public static int[] createGroup(int maxSize, int maxValue){
        int[] arr = new int[(int)(Math.random() * maxSize)];
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

    public static void countSort(int[] arr){
        if (arr == null || arr.length < 2) {
            return;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        int[] help = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {
            help[arr[i]]++;
        }
        int temp = 0;
        for (int i = 0; i < help.length; i++) {
            while (help[i]-- > 0) {
                arr[temp++] = i;
            }
        }

    }

}
