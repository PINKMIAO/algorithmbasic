package com.baven.sort;

/**
 * for training
 */
public class SortTest {

    public static void mergeProcess(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        int M = (R + L) >> 1;
        mergeProcess(arr, L, M);
        mergeProcess(arr, M + 1, R);
        mergeSort(arr, L, M, R);
    }
    public static void mergeSort(int[] arr, int L, int M, int R) {
        int[] temp = new int[R - L + 1];
        int l = L;
        int r = M + 1;
        int i = 0;
        while (l <= M && r <= R) {
            temp[i++] = arr[l] < arr[r] ? arr[l++] : arr[r++];
        }
        while (l <= M) {
            temp[i++] = arr[l++];
        }
        while (r <= R) {
            temp[i++] = arr[r++];
        }
        for (i = 0; i < temp.length; i++) {
            arr[L++] = temp[i];
        }
    }

    public static void quickSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
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
        process1(arr, m+ 1, r);
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
            if (arr[index] <= arr[r]) {
                swag(arr, ++less, index);
            }
            index++;
        }
        swag(arr, ++less, r);
        return less;
    }
    public static void quickSort2(int[] arr) {
        if (arr == null || arr.length <=2) {
            return;
        }
        process2(arr, 0, arr.length - 1);
    }
    public static void process2(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        int[] M = netherLandsFlag(arr, L, R);
        process2(arr, L, M[0] - 1);
        process2(arr, M[1] + 1, R);
    }
    public static int[] netherLandsFlag(int[] arr, int L, int R) {
        if (L == R){
            return new int[] {L, R};
        }
        if (L > R) {
            return new int[] {-1, -1};
        }

        int less = L - 1;
        int index = L;
        int more = R - 1;
        while (index < more) {
            if (arr[index] == arr[R]) {
                index++;
            } else if (arr[index] < arr[R]) {
                swag(arr, ++less, index++);
            } else {
                swag(arr, index, more--);
            }
        }
        swag(arr, index, R);
        return new int[] {++less, more};
    }

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            int index = i;
            while (arr[index] > arr[(index - 1) / 2]) {
                swag(arr, index, (index - 1) / 2);
                index = (index - 1) / 2;
            }
        }
        int heapSize = arr.length - 1;
        swag(arr, 0, heapSize);

        while (heapSize > 0) {
            heapify(arr, 0, heapSize);
            swag(arr, 0, --heapSize);
        }
    }
    public static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;

            if (largest == index) {
                break;
            }
            swag(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }

    }

    public static void countSort(int[] arr) {
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

    public static void radixSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        radixSort(arr, 0, arr.length - 1, maxbits(arr));
    }
    public static void radixSort(int[] arr, int L, int R, int digit) {
        final int radix = 10;
        int i = 0, j = 0;

        int[] help = new int[R - L + 1];
        for (int d = 0; d < digit; d++) {
            int[] count = new int[10];
            for (i = L; i < R; i++) {
                j = getBits(arr[i], d);
                count[j]++;
            }
            for (i = 1; i < count.length; i++) {
                count[i] = count[i] + count[i - 1];
            }
            for (i = R; i >= L; i--) {
                j = getBits(arr[i], d);
                help[count[j] - 1] = arr[i];
                count[j]--;
            }
            for (i = L, j = 0; i <= R; i++, j++) {
                arr[i] = help[j];
            }
        }
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
    public static int getBits(int x, int d) {
        return ((x / ((int) Math.pow(10, d - 1))) % 10);
    }





    public static void main(String[] args) {
        int maxSize = 20;
        int maxValue = 20;
        int[] arr = createGroup(maxSize, maxValue);

        printGroup(arr);
        radixSort(arr);
        printGroup(arr);
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
    public static void swag(int[] arr, int i, int y){
        int temp = arr[i];
        arr[i] = arr[y];
        arr[y] = temp;
    }

}