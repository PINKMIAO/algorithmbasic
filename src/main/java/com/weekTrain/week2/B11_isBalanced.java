package com.weekTrain.week2;

/**
 * @author Baven
 * @date 2022/4/1 9:44
 * 平衡
 */
public class B11_isBalanced {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static class Info {
        public boolean isBalanced;
        public int height;

        public Info(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    public static Boolean isBalance(Node head) {
        if (head == null) {
            return true;
        }
        return process(head).isBalanced;
    }

    public static Info process(Node head) {
        if (head == null) {
            return new Info(true, 0);
        }
        Info leftInfo = process(head.left);
        Info rightInfo = process(head.right);
        boolean isBalanced = false;
        int height = 1;

        if (leftInfo.isBalanced && rightInfo.isBalanced) {
            isBalanced = true;
        }
        if (Math.abs((leftInfo.height - rightInfo.height)) > 1) {
            isBalanced = false;
        }
        height = Math.max(leftInfo.height, rightInfo.height) + 1;

        return new Info(isBalanced, height);
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);
        head.left.left.left = new Node(4);

        System.out.println(isBalance(head));
    }
}
