package com.baven.sort;

public class HeapSort {

    public static void main(String[] args) {
        int[] arr = creatGroup(20, 20);

        printGroup(arr);
        heapSort(arr);
        printGroup(arr);
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static int[] creatGroup(int maxSize, int maxValue) {
        int[] nums = new int[(int)(Math.random() * maxSize)];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int)(Math.random() * maxValue) - (int)(Math.random() * maxValue);
        }
        return nums;
    }
    public static void printGroup(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    /**
     * 大根堆
     * @param arr
     */
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        // 排出大根堆
        for (int i = 0; i < arr.length; i++) {
            int index = i;
            while (arr[index] > arr[(index - 1) / 2]) {
                swap(arr, index, (index - 1) / 2);
                index = (index - 1) / 2;
            }
        }

        // 将位于大根堆第一位的值移动到最后一位，在把位于第一位的值进行单方面的移动
        int heapSize = arr.length - 1;
        swap(arr, 0, heapSize);

        while (heapSize > 0) {
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }

    }

    public static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            // 判断是否有右孩子，且是否比左孩子大
            int largest = left + 1 < heapSize && arr[left + 1] > arr [left] ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;

            if (largest == index) {
                break;
            }
            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }


    // for learn
    // heap Model
    public static class MyMaxHeap {
        private int[] heap;
        private final int limit;
        private int heapSize;

        public MyMaxHeap(int limit) {
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
                throw new RuntimeException("heap is full");
            }
            heap[heapSize] = value;
            // value  heapSize
            heapInsert(heap, heapSize++);
        }

        // 用户此时，让你返回最大值，并且在大根堆中，把最大值删掉
        // 剩下的数，依然保持大根堆组织
        public int pop() {
            int ans = heap[0];
            swap(heap, 0, --heapSize);
            heapify(heap, 0, heapSize);
            return ans;
        }

        private void heapInsert(int[] arr, int index) {
            // arr[index]
            // arr[index] 不比 arr[index父]大了 ， 停
            // index = 0;
            while (arr[index] > arr[(index - 1) / 2]) {
                swap(arr, index, (index - 1) / 2);
                index = (index - 1) / 2;
            }
        }

        // 从index位置，往下看，不断的下沉，
        // 停：我的孩子都不再比我大；已经没孩子了
        private void heapify(int[] arr, int index, int heapSize) {
            int left = index * 2 + 1;
            while (left < heapSize) {
                // 左右两个孩子中，谁大，谁把自己的下标给largest
                // 右  ->  1) 有右孩子   && 2）右孩子的值比左孩子大才行
                // 否则，左
                int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
                largest = arr[largest] > arr[index] ? largest : index;
                if (largest == index) {
                    break;
                }
                swap(arr, largest, index);
                index = largest;
                left = index * 2 + 1;
            }
        }

        private void swap(int[] arr, int i, int j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }

    }


}
