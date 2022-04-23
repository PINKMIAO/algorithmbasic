package com.weekTrain.week2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Baven
 * @date 2022/3/30 20:27
 */
public class B04_SerializeAndReconstructTree {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Queue<String> preSerial(Node head) {
        Queue<String> ans = new LinkedList<>();
        pres(head, ans);
        return ans;
    }
    public static void pres(Node head, Queue<String> ans) {
        if (head == null) {
            ans.add(null);
        } else {
            ans.add(String.valueOf(head.value));
            pres(head.left, ans);
            pres(head.right, ans);
        }
    }

    public static Node buildByPreQueue(Queue<String> strings) {
        if (strings == null || strings.size() == 0) {
            return null;
        }
        return preb(strings);
    }
    public static Node preb(Queue<String> strings) {
        String poll = strings.poll();
        if (poll == null) {
            return null;
        }
        Node node = new Node(Integer.valueOf(poll));
        node.left = preb(strings);
        node.right = preb(strings);
        return node;
    }

    public static Queue<String> levelSerial(Node head) {
        Queue<String> ans = new LinkedList<>();
        if (head == null) {
            ans.add(null);
        } else {
            Queue<Node> queue = new LinkedList<>();
            queue.add(head);
            Node cur = null;
            ans.add(String.valueOf(head.value));
            while (!queue.isEmpty()) {
                cur = queue.poll();
                if (cur.left != null) {
                    queue.add(cur.left);
                    ans.add(String.valueOf(cur.left.value));
                } else {
                    ans.add(null);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                    ans.add(String.valueOf(cur.right.value));
                } else {
                    ans.add(null);
                }
            }
        }
        return ans;
    }
    public static Node buildByLevel(Queue<String> levellist) {
        if (levellist == null || levellist.size() == 0) {
            return null;
        }
        Node head = generateNode(levellist.poll());
        Queue<Node> queue = new LinkedList<>();
        if (head != null) {
            queue.add(head);
        }
        Node node = null;
        while (!queue.isEmpty()) {
            node = queue.poll();
            node.left = generateNode(levellist.poll());
            node.right = generateNode(levellist.poll());
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return head;
    }
    public static Node generateNode(String value) {
        if (value == null) {
            return null;
        }
        return new Node(Integer.valueOf(value));
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        // Queue<String> strings = levelSerial(head);
        // while (!strings.isEmpty()) {
        //     System.out.print(strings.poll() + " ");
        // }
        // System.out.println();

        // Node node = buildByLevel(strings);
        // System.out.println(node.value);
        // Queue<Node> queue = new LinkedList<>();
        // Node cur = null;
        // queue.add(node);
        // while (!queue.isEmpty()) {
        //     cur = queue.poll();
        //     System.out.print(cur.value + " ");
        //     if (cur.left != null) {
        //         queue.add(cur.left);
        //     }
        //     if (cur.right != null) {
        //         queue.add(cur.right);
        //     }
        // }
        Queue<String> queue = preSerial(head);
        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }
    }
}
