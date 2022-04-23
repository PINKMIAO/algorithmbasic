package com.weekTrain.week2;

import java.util.Stack;

/**
 * @author Baven
 * @date 2022/3/29 19:28
 */
public class A02_isPalindromeList {
    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static boolean isPalindrome1(Node head) {
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (head != null) {
            if (head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }
    public static boolean isPalindrome2(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node L = head.next;
        Node R = head;
        while (R.next != null && R.next.next != null) {
            L = L.next;
            R = R.next.next;
        }
        Stack<Node> stack = new Stack<>();
        while (L != null) {
            stack.push(L);
            L = L.next;
        }
        while (!stack.isEmpty()) {
            if (head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }
    public static boolean isPalindrome3(Node head) {
        if (head != null || head.next == null) {
            return true;
        }
        Node n1 = head;
        Node n2 = head;
        while (n2.next != null && n2.next.next != null) {
            n1 = n1.next;
            n2 = n2.next.next;
        }

        n2 = n1.next;
        n1.next = null;
        Node n3 = null;
        while (n2.next != null) {
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }
        n3 = n1;
        n2 = head;
        boolean res =true;
        while (n1 != null && n2 != null) {
            if (n1.value != n2.value)    {
                res = false;
                break;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        n1 = n3.next;
        n3.next = null;
        while (n1 != null) {
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        return res;
    }

    public static void printNodeList(Node head) {
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node test = null;
        test = new Node(1);
        test.next = new Node(2);
        test.next.next = new Node(3);
        test.next.next.next = new Node(3);
        test.next.next.next.next = new Node(2);
        test.next.next.next.next.next = new Node(1);
        printNodeList(test);

        System.out.print(isPalindrome1(test) + " | ");
        System.out.print(isPalindrome2(test) + " | ");
        System.out.print(isPalindrome3(test));
    }
}
