package com.weekTrain.week6;

import java.util.LinkedList;

/**
 * @author Baven
 * @date 2022/4/28 19:58
 */
public class A01_SlidingWindowMaxArray {
    public static int[] right(int[] arr, int w) {
        LinkedList<Integer> qmax = new LinkedList<>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for (int R = 0; R < arr.length; R++) {
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[R]) {
                qmax.pollLast();
            }
            qmax.addLast(R);
            if (qmax.peekFirst() == R - w) {
                qmax.pollFirst();
            }
            if (R >= w - 1) {
                res[index++] = qmax.peekFirst();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 7, 4, 2, 6, 4, 1};
        int w = 3;
        int[] right = right(arr, w);
        for (int i : right) {
            System.out.print(i + " ");
        }
    }
}
