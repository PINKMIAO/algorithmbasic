package com.pulsone.pulsone;

import com.weekTrain.week2.B01_RecursiveTraversalBT;

import java.sql.Statement;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Baven
 * @date 2022/4/12 10:22
 */
public class RecursiveTraversalBT {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void pre(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");
        pre(node.left);
        pre(node.right);
    }

    public static void in(Node node) {
        if (node == null) {
            return;
        }
        in(node.left);
        System.out.print(node.value + " ");
        in(node.right);
    }

    public static void pos(Node node) {
        if (node == null) {
            return;
        }
        pos(node.left);
        pos(node.right);
        System.out.print(node.value + " ");
    }

    public static void unPre(Node node) {
        if (node == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(node);
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

    public static void unPos(Node node) {
        if (node == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Stack<Node> ans = new Stack<>();
        stack.push(node);
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

    public static void unIn(Node node) {
        if (node == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || node != null) {
            if (node!= null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                System.out.print(node.value + " ");
                node = node.right;
            }
        }
    }

    public static void bfs(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        Node cur = null;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            System.out.print(cur.value + " ");
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
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

        pre(head);
        System.out.print("==============");
        unPre(head);
        System.out.println();
        in(head);
        System.out.print("==============");
        unIn(head);
        System.out.println();
        pos(head);
        System.out.print("==============");
        unPos(head);
        System.out.println();
        bfs(head);
    }
}
