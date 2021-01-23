package com.baven.treeNode;

public class TreeTest {
    public static class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;
        public TreeNode(int value) {
            this.value = value;
        }
    }
    public static void traversalProcess(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.value);
        traversalProcess(root.left);
        traversalProcess(root.right);

    }


    public static void main(String[] args) {
        int maxLevel = 5;
        int maxValue = 30;
        TreeNode head = createRandomTree(maxLevel, maxValue);

        traversalProcess(head);
    }
    public static TreeNode createRandomTree(int maxLevel, int maxValue) {
        return create(1, maxLevel, maxValue);
    }
    public static TreeNode create(int level, int maxLevel, int maxValue) {
        if (level > maxLevel || Math.random() < 0.3) {
            return null;
        }
        TreeNode head = new TreeNode((int) (Math.random() * maxValue));
        head.left = create(level + 1, maxLevel, maxValue);
        head.right = create(level + 1, maxLevel, maxValue);
        return head;
    }

}
