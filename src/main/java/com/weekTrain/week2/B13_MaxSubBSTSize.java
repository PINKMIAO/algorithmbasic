package com.weekTrain.week2;

/**
 * 最大搜索子树大小
 * @author Baven
 * @date 2022/4/1 16:24
 */
public class B13_MaxSubBSTSize {
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
        public int maxBSTSubtreeSize;
        public int allSize;
        public boolean isBST;
        public int max;
        public int min;

        public Info(int maxBSTSubtreeSize, int allSize, int max, int min) {
            this.maxBSTSubtreeSize = maxBSTSubtreeSize;
            this.allSize = allSize;
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
        int allSize = 1;
        int max = x.value;
        int min = x.value;
        boolean isBST = true;
        int maxBSTSubtreeSize = -1;
        if (leftInfo != null) {
            max = Math.max(leftInfo.max, max);
            min = Math.min(leftInfo.min, min);
            allSize += leftInfo.allSize;
            maxBSTSubtreeSize = Math.max(leftInfo.maxBSTSubtreeSize, maxBSTSubtreeSize);
        }
        if (rightInfo != null) {
            max = Math.max(rightInfo.max, max);
            min = Math.min(rightInfo.min, min);
            allSize += rightInfo.allSize;
            maxBSTSubtreeSize = Math.max(rightInfo.maxBSTSubtreeSize, maxBSTSubtreeSize);
        }

        if (leftInfo != null && !leftInfo.isBST
                || rightInfo != null && !rightInfo.isBST) {
            isBST = false;
        }
        if (leftInfo != null && leftInfo.max >= x.value
                || rightInfo != null && rightInfo.min <= x.value) {
            isBST = false;
        }
        if (isBST) {
            int leftSize = leftInfo == null ? 0 : leftInfo.allSize;
            int rightSize = rightInfo == null ? 0 : rightInfo.allSize;
            maxBSTSubtreeSize = Math.max((leftSize + rightSize + 1), maxBSTSubtreeSize);
        }

        return new Info(maxBSTSubtreeSize, allSize, max, min);
    }



    public static void main(String[] args) {

    }
}
