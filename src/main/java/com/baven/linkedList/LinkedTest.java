package com.baven.linkedList;

public class LinkedTest {

    public static class Node {
        int value;
        Node next;
        public Node(int value) {
            this.value = value;
        }
    }
    public static Node getLoop(Node head) {
        Node slow = head.next;
        Node fast = head.next.next;
        while (slow != fast) {
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        System.out.println(slow.value);
        return slow;
    }
    public static Node reserveLink(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node temp = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = temp;
            temp = head;
            head = next;
        }
        return temp;
    }






    public static void main(String[] args) {
        Node test = null;
        test = new Node(3);
        test.next = new Node(2);
        test.next.next = new Node(4);
        test.next.next.next = new Node(7);
        test.next.next.next.next = new Node(5);
        test.next.next.next.next.next = new Node(1);
        test.next.next.next.next.next.next = new Node(2);
        test.next.next.next.next.next.next.next = new Node(4);
//        test.next.next.next.next.next.next.next.next = test.next.next.next.next;

//        getLoop(test);
        printLinked(test);
        Node node = reserveLink(test);
        printLinked(node);
    }
    public static void printLinked(Node head) {
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }
}
