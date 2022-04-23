package com.weekTrain.week2;

/**
 * @author Baven
 * @date 2022/4/1 9:44
 * 搜索二叉树
 */
public class B10_isBST {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Boolean isBST(Node head) {
        if (head == null) {
            return true;
        }
        return process(head).isBST;
    }

    public static class Info {
        public boolean isBST;
        public int max;
        public int min;

        public Info(boolean isBST, int max, int min) {
            this.isBST = isBST;
            this.max = max;
            this.min = min;
        }
    }

    public static Info process(Node x) {
        if (x == null) {
            return null;
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);
        boolean isBST = true;
        if (leftInfo != null && !leftInfo.isBST
                || rightInfo != null && !rightInfo.isBST) {
            isBST = false;
        }
        if (leftInfo != null && leftInfo.max >= x.value
                || rightInfo != null && rightInfo.min <= x.value) {
            isBST = false;
        }

        int max = x.value;
        int min = x.value;
        if (leftInfo != null) {
            max = Math.max(leftInfo.max, max);
            min = Math.min(leftInfo.min, min);
        }
        if (rightInfo != null) {
            max = Math.max(rightInfo.max, max);
            min = Math.min(rightInfo.min, min);
        }

        return new Info(isBST, max, min);
    }

    public static void in(Node node) {
        if (node == null) {
            return;
        }
        in(node.left);
        System.out.print(node.value + " ");
        in(node.right);
    }

    public static void main(String[] args) {
        Node head = new Node(4);
        head.left = new Node(2);
        head.right = new Node(6);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.right.left = new Node(5);
        head.right.right = new Node(7);
        // head.left.left.left = new Node(4);

        in(head);
        System.out.println();
        System.out.println(isBST(head));
    }
}
