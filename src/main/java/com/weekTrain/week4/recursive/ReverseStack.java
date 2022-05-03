package com.weekTrain.week4.recursive;

import java.util.Stack;

/**
 * @author Baven
 * @date 2022/4/18 11:15
 */
public class ReverseStack {
    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int i = func(stack);
        reverse(stack);
        stack.push(i);
    }

    public static int func(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        }
        int i = func(stack);
        stack.push(result);
        return i;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        reverse(stack);
        while (!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }
}
