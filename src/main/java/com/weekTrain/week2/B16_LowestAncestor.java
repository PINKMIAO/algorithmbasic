package com.weekTrain.week2;

/**
 * @author Baven
 * @date 2022/4/1 20:37
 */
public class B16_LowestAncestor {
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
        public boolean findA;
        public boolean findB;
        public Node node;

        public Info(boolean findA, boolean findB, Node node) {
            this.findA = findA;
            this.findB = findB;
            this.node = node;
        }
    }

    public static Info process(Node x, Node A, Node B) {
        if (x == null) {
            return new Info(true,true,null);
        }
        Info leftInfo = process(x.left, A, B);
        Info rightInfo = process(x.right, A, B);
        boolean findA = x == A || leftInfo.findA || rightInfo.findA;
        boolean findB = x == B || leftInfo.findB || rightInfo.findB;
        Node node = null;
        if (leftInfo.node != null ){
            node = leftInfo.node;
        } else if (rightInfo.node != null) {
            node = rightInfo.node;
        } else {
            if (findA && findB) {
                node = x;
            }
        }

        return new Info(findA, findB, node);
    }


    public static void main(String[] args) {

    }
}
