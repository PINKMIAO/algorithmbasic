package com.weekTrain.week2;

/**
 * @author Baven
 * @date 2022/4/1 13:49
 * 满二叉
 */
public class B12_isFull {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public static class Info {
        public boolean isFull;
        public int height;

        public Info(boolean isFull, int height) {
            this.isFull = isFull;
            this.height = height;
        }
    }
    public static boolean isFull(Node head) {
        if (head == null) {
            return true;
        }
        return process(head).isFull;
    }

    public static Info process(Node x) {
        if (x == null) {
            return new Info(true, 0);
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);

        boolean isFull = leftInfo.isFull && rightInfo.isFull && leftInfo.height == rightInfo.height;
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        return new Info(isFull, height);
    }

    public static void main(String[] args) {

    }
}
