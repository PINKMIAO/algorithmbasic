package com.weekTrain.week2;

/**
 * 递归遍历先中后
 * @author Baven
 * @date 2022/3/30 15:22
 */
public class B01_RecursiveTraversalBT {


    public static void pre(Node head) {
        if (head == null) {
            return;
        }
        System.out.print(head.value + " ");
        pre(head.left);
        pre(head.right);
    }

    public static void in(Node head) {
        if (head == null) {
            return;
        }
        in(head.left);
        System.out.print(head.value + " ");
        in(head.right);
    }

    public static void pos(Node head) {
        if (head == null) {
            return;
        }
        pos(head.left);
        pos(head.right);
        System.out.print(head.value + " ");
    }

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    // 		  1
    // 		/   \
    //     2     3
    //    / \   / \
    //   4   5 6   7
    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        pre(head);
        System.out.println();
        in(head);
        System.out.println();
        pos(head);
    }
}
