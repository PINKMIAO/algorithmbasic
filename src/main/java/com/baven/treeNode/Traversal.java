package com.baven.treeNode;

import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

/**
 * 关于树的遍历
 */
public class Traversal {

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            this.val = x;
        }
    }
    // 根据递归遍历
    public static void traversalProcess(TreeNode root) {
        if (root == null) {
            return;
        }
        // 输出放在两递归中的不同位子就代表这先、中、后
        System.out.println(root.val);
        traversalProcess(root.left);
        traversalProcess(root.right);
    }
    // 利用栈先序遍历
    public static void pTraversalByStack(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.add(root);

        while (!stack.isEmpty()){
            TreeNode head = stack.pop();
            System.out.println(head.val);
            if (head.right != null) {
                stack.add(head.right);
            }
            if (head.left != null) {
                stack.add(head.left);
            }
        }
    }
    public static void lTraversalByStack(TreeNode root) {
        if (root != null) {
            Stack<TreeNode> stack = new Stack<TreeNode>();
            Stack<Integer> helper = new Stack<Integer>();
            stack.add(root);

            while (!stack.isEmpty()) {
                TreeNode head = stack.pop();
                helper.add(head.val);

                if (head.left != null) {
                    stack.push(head.left);
                }
                if (head.right != null) {
                    stack.push(head.right);
                }
            }

            while (!helper.isEmpty()) {
                System.out.println(helper.pop() + " ");
            }

        }
    }
    public static TreeNode generateRandomTree(int maxLevel, int maxValue) {
        return generate(1, maxLevel, maxValue);
    }

    public static TreeNode generate(int level, int maxLevel, int maxValue) {
        if (level > maxLevel || Math.random() < 0.3) {
            return null;
        }
        TreeNode head = new TreeNode((int) (Math.random() * maxValue));
        head.left = generate(level + 1, maxLevel, maxValue);
        head.right = generate(level + 1, maxLevel, maxValue);
        return head;
    }

    public static void main(String[] args) {
        int maxLevel = 5;
        int maxValue = 100;
        TreeNode root = generateRandomTree(maxLevel, maxValue);
        lTraversalByStack(root);
    }

}
