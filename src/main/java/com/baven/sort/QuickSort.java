package com.baven.sort;

/**
 * 快速排序 Quick Sort
 * All three version
 */
public class QuickSort {

    public static void main(String[] args) {
<<<<<<< HEAD
        int maxSize = 20;
        int maxValue = 20;
        int[] arr = createGroup(maxSize, maxValue);

        printGroup(arr);
        quickSort3(arr);
        printGroup(arr);
=======
        int[] arr = {5,3,2,6,1,5,3,9,7,4,2};

        quickSort3(arr);

        for (int num : arr) {
            System.out.print(num + " ");
        }
>>>>>>> 065c37711a50f8ca653bdbef0bb53f99ebdd28d4
    }

    public static void swag(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static int[] netherlandsFlags(int[] arr, int l, int r) {
        if (l > r) {
            return new int[] {-1, -1};
        }
        if (l == r) {
<<<<<<< HEAD
            return new int[] {l, r};
=======
            return new int[] {l , r};
>>>>>>> 065c37711a50f8ca653bdbef0bb53f99ebdd28d4
        }

        int less = l - 1;
        int more = r;
        int index = l;

        while (index < more) {
            if (arr[index] == arr[r]) {
                index++;
            } else if (arr[index] < arr[r]) {
                swag(arr, index++, ++less);
            } else {
                swag(arr, index, --more);
            }
        }
        swag(arr, more, r);
        return new int[] {++less, more};
    }
    public static int partition(int[] arr, int l, int r) {
        if (l > r) {
            return -1;
        }
        if (l == r) {
            return l;
        }

        int less = l - 1;
        int index = l;
        while (index < r) {
            if (arr[index] <= arr[r]){
                swag(arr, index, ++less);
            }
            index++;
        }
        swag(arr, ++less, r);
        return less;
    }


    /**
     * version 1.0
     * @param arr
     */
    public static void quickSort1(int[] arr) {
        if (arr == null && arr.length < 2) {
            return;
        }
        process1(arr, 0, arr.length - 1);
    }
    public static void process1(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int m = partition(arr, l, r);
        process1(arr, l, m - 1);
        process1(arr, m + 1, r);
    }

    /**
     * version 2.0
     * @param arr
     */
    public static void quickSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process2(arr, 0, arr.length - 1);
    }
    public static void process2(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int[] m = netherlandsFlags(arr, l, r);
        process2(arr, l, m[0] - 1);
        process2(arr,m[1] + 1, r);
    }

    /**
     * version 3.0
     * @param arr
     */
    public static void quickSort3(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process3(arr, 0, arr.length - 1);
    }
    public static void process3(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        swag(arr, l + (int)(Math.random() * (r - l +1)), r);
        int[] m = netherlandsFlags(arr, l, r);
        process3(arr, l, m[0] - 1);
        process3(arr, m[1] + 1, r);
    }
<<<<<<< HEAD


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
=======
>>>>>>> 065c37711a50f8ca653bdbef0bb53f99ebdd28d4
}
