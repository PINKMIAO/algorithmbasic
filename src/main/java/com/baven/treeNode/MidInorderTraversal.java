package com.baven.treeNode;

import java.util.ArrayList;
import java.util.List;

public class MidInorderTraversal {

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        return solution(root, ans);
    }

    public List<Integer> solution(TreeNode root, List<Integer> ans){
        if (root == null) {
            return ans;
        }
        solution(root.left, ans);
        ans.add(root.val);
        solution(root.right, ans);
        return ans;
    }

}
