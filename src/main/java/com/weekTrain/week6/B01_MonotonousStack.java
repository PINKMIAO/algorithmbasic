package com.weekTrain.week6;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Baven
 * @date 2022/4/28 20:22
 */
public class B01_MonotonousStack {

    public static int[][] right1(int[] arr) {  // 不重复
        int[][] res = new int[arr.length][2];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                int j = stack.pop();
                int leftLessIndex = stack.isEmpty() ? -1 : stack.peek();
                res[j][0] = leftLessIndex;
                res[j][1] = i;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int j = stack.pop();
            int leftLessIndex = stack.isEmpty() ? -1 : stack.peek();
            res[j][0] = leftLessIndex;
            res[j][1] = -1;
        }
        return res;
    }

    public static int[][] getNearLess(int[] arr) {
        int[][] res = new int[arr.length][2];
        Stack<List<Integer>> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek().get(0)] > arr[i]) {
                List<Integer> popis = stack.pop();
                int leftLessIndex = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
                for (Integer j : popis) {
                    res[j][0] = leftLessIndex;
                    res[j][1] = i;
                }
            }
            if (!stack.isEmpty() && stack.peek().get(0) == i) {
                stack.peek().add(i);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                stack.push(list);
            }
        }
        while (!stack.isEmpty()) {
            List<Integer> popis = stack.pop();
            int leftLessIndex = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
            for (Integer j : popis) {
                res[j][0] = leftLessIndex;
                res[j][1] = -1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 7, 4, 3, 6, 9, 0};
        int[][] ints = getNearLess(arr);
        for (int[] anInt : ints) {
            for (int i : anInt) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
