package com.weekTrain.week1;

/**
 * @author Baven
 * @date 2022/3/26 21:31
 */
public class C02_MyHeap {
    private int[] heap;
    private final int limit;
    private int heapSize;

    public C02_MyHeap(int limit) {
        heap = new int[limit];
        this.limit = limit;
        heapSize = 0;
    }

    public boolean isEmpty() {
        return heapSize == 0;
    }
    public boolean isFull() {
        return heapSize == limit;
    }

    public void push(int value) {
        if (heapSize == limit) {
            throw new RuntimeException("is FUll ！");
        }
        heap[heapSize++] = value;

    }

    public int pop() {
        int ans = heap[0];
        swap(heap, 0, --heapSize);


        return ans;
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
