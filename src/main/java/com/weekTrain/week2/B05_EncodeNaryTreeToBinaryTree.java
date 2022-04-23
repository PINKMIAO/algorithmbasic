package com.weekTrain.week2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Baven
 * @date 2022/3/31 10:19
 */
public class B05_EncodeNaryTreeToBinaryTree {
    // 提交时不要提交这个类
    public static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    // 提交时不要提交这个类
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Codec {
        public TreeNode encode(Node node) {
            if (node == null) {
                return null;
            }
            TreeNode head = new TreeNode(node.val);
            head.left = en(node.children);
            return head;
        }
        public TreeNode en(List<Node> children) {
            TreeNode head = null;
            TreeNode cur = null;
            for (Node c : children) {
                TreeNode toNode = new TreeNode(c.val);
                if (head == null) {
                    head = toNode;
                } else {
                    cur.right = toNode;
                }
                cur = toNode;
                cur.left = en(c.children);
            }
            return head;
        }

        public Node decode(TreeNode root) {
            if (root == null) {
                return null;
            }
            return new Node(root.val, de(root.left));
        }
        public List<Node> de(TreeNode root) {
            List<Node> children = new ArrayList<>();
            while (root != null) {
                Node cur = new Node(root.val, de(root.left));
                children.add(cur);
                root = root.right;
            }
            return children;
        }
    }
}
