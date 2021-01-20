package com.baven.treeNode;

import java.util.ArrayList;

public class IsBST {
    /**
     * 树节点
     */
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 方法一
     * @param head
     * @return
     */
    public static boolean isBST1(TreeNode head) {
        if (head == null) {
            return true;
        }
        ArrayList<TreeNode> arr = new ArrayList<TreeNode>();
        in(head, arr);
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i).val <= arr.get(i - 1).val) {
                return false;
            }
        }
        return true;
    }
    // 将二叉树装进集合中
    public static void in(TreeNode head, ArrayList<TreeNode> arr) {
        if (head == null) {
            return;
        }
        in(head.left, arr);
        arr.add(head);
        in(head.right, arr);
    }

    /**
     * 方法二
     */
    // 信息表
    static class Info{
        boolean isBST;
        int min;
        int max;
        Info(boolean is, int mi, int ma) {
            isBST = is;
            min = mi;
            max = ma;
        }
    }
    // 方法二入口
    public static boolean isBST2(TreeNode head){
        if (head == null) {
            return true;
        }
        return process(head).isBST;
    }

    public static Info process(TreeNode head) {
        if (head == null) {
            return null;
        }
        Info leftInfo = process(head.left);
        Info rightInfo = process(head.right);

        int min = head.val;
        int max = head.val;

        if (leftInfo != null) {
            min = Math.min(min, leftInfo.min);
            max = Math.max(max, leftInfo.max);
        }
        if (rightInfo != null) {
            min = Math.min(min, rightInfo.min);
            max = Math.max(max, rightInfo.max);
        }
        boolean isBST = false;
        if(
                (leftInfo == null ? true : (leftInfo.isBST && leftInfo.max < head.val))
                &&
                (rightInfo == null ? true : (rightInfo.isBST && rightInfo.min > head.val))
        ) {
            isBST = true;
        }
        return new Info(isBST, min, max);
    }




    // for test
    public static TreeNode generateRandomBST(int maxLevel, int maxValue) {
        return generate(1, maxLevel, maxValue);
    }
    // for test
    public static TreeNode generate(int level, int maxLevel, int maxValue) {
        if (level > maxLevel || Math.random() < 0.5) {
            return null;
        }
        TreeNode head = new TreeNode((int)(Math.random() * maxValue));
        head.left = generate(level + 1, maxLevel, maxValue);
        head.right = generate(level + 1, maxLevel, maxValue);
        return head;
    }

    public static void main(String[] args) {
        int maxLevel = 5;
        int maxValue = 20;
        TreeNode head = generateRandomBST(maxLevel, maxValue);

    }

}
