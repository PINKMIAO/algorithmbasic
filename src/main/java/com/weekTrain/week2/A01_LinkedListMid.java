package com.weekTrain.week2;

import java.util.ArrayList;

/**
 * @author Baven
 * @date 2022/3/29 11:18
 */
public class A01_LinkedListMid {
    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node midOrDownMidNode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node slow = head.next;
        Node fast = head.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node midOrUpMidNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        Node slow = head.next;
        Node fast = head.next.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node midOrUpMidPreNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        Node slow = head;
        Node fast = head.next.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node newLand(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node midOrDownMidPreNode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node slow = head;
        Node fast = head.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node right1(Node head) { // 笔试的时候使用
        if (head == null) {
            return head;
        }
        Node curr = head;
        ArrayList<Node> arr = new ArrayList<>();
        while (curr != null) {
            arr.add(curr);
            curr = curr.next;
        }
        return arr.get((arr.size() - 2) / 2);
    }

    public static void printNodeList(Node node) {
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // 0 1 2 3 4 5 6 7 8 9
        Node test = null;
        test = new Node(0);
        test.next = new Node(1);
        test.next.next = new Node(2);
        test.next.next.next = new Node(3);
        test.next.next.next.next = new Node(4);
        test.next.next.next.next.next = new Node(5);
        test.next.next.next.next.next.next = new Node(6);
        test.next.next.next.next.next.next.next = new Node(7);
        test.next.next.next.next.next.next.next.next = new Node(8);
        test.next.next.next.next.next.next.next.next.next = new Node(9);

        printNodeList(test);
        Node node = right1(test);
        System.out.println("笔试用： " + node.value);

        // Node node1 = midOrUpMidNode(test);
        // System.out.println("偶中上：" + node1.value);
        // Node node3 = midOrUpMidPreNode(test);
        // System.out.println("基中前或偶中上前：" + node3.value);
        //
        // Node node2 = midOrDownMidNode(test);
        // System.out.println("偶中下："+ node2.value);
        // Node node4 = midOrDownMidPreNode(test);
        // System.out.println("基中前或偶中下前：" + node4.value);

        Node node4 = newLand(test);
        System.out.println("newland：" + node4.value);

    }
}
