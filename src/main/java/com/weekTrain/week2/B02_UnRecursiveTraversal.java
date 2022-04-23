package com.weekTrain.week2;

import java.util.Stack;

/**
 * @author Baven
 * @date 2022/3/30 15:31
 */
public class B02_UnRecursiveTraversal {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void pre(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        Node cur = null;
        while (!stack.isEmpty()) {
            cur = stack.pop();
            System.out.print(cur.value + " ");
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    public static void in(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || head != null){
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                System.out.print(head.value + " ");
                head = head.right;
            }
        }
    }

    public static void pos(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Stack<Node> ans = new Stack<>();
        stack.push(head);
        Node cur = null;
        while (!stack.isEmpty()) {
            cur = stack.pop();
            ans.push(cur);
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }
        while (!ans.isEmpty()) {
            System.out.print(ans.pop().value + " ");
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);
        // 1 2 4 5 3 6 7
        // 4 2 5 1 6 3 7
        // 4 5 2 6 7 3 1

        pre(head);
        System.out.println();
        in(head);
        System.out.println();
        pos(head);
    }
}
