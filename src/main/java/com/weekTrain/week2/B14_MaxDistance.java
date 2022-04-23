package com.weekTrain.week2;

/**
 * @author Baven
 * @date 2022/4/1 19:42
 */
public class B14_MaxDistance {
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
        public int maxDis;
        public int height;

        public Info(int maxDis, int height) {
            this.maxDis = maxDis;
            this.height = height;
        }
    }

    public static Info process(Node x) {
        if (x == null) {
            return new Info(0,0);
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);
        int height = 1;
        height = Math.max(leftInfo.height, rightInfo.height) + 1;

        int maxDis = 1;
        int p1 = leftInfo.maxDis;
        int p2 = rightInfo.maxDis;
        int p3 = leftInfo.height + rightInfo.height + 1;

        maxDis = Math.max(Math.max(p1, p2), p3);
        return new Info(maxDis, height);
    }

    public static void main(String[] args) {

    }
}
