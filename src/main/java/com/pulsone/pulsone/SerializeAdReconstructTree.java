package com.pulsone.pulsone;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Baven
 * @date 2022/4/12 14:02
 */
public class SerializeAdReconstructTree {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Queue<String> levelS(Node node) {
        if (node == null) {
            return null;
        }
        Queue<String> ans = new LinkedList<>();
        Queue<String> queue = new LinkedList<>();
        ans.add(String.valueOf(node.value));
        Node cur = null;
        while (!queue.isEmpty()) {

        }
        return ans;
    }

    public static void pres(Node node, Queue<String> ans) {
        if (node == null) {
            ans.add(null);
        } else {
            ans.add(String.valueOf(node.value));
            pres(node.left, ans);
            pres(node.right, ans);
        }
    }

    public static Node preb(Queue<String> strings) {
        String poll = strings.poll();
        if (poll == null) {
            return null;
        }
        Node node = new Node(Integer.parseInt(poll));
        node.left = preb(strings);
        node.right = preb(strings);
        return node;
    }



    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        Queue<String> ans = new LinkedList<>();
        pres(head, ans);

        // while (!ans.isEmpty()) {
        //     System.out.print(ans.poll() + " ");
        // }

    }
}
