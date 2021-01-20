package com.baven.linkedList;

import java.util.Stack;

/**
 * 判断回文的 4 种方法
 */
public class IsPalindromeList {

    public static class Node{
        public Node next;
        public int value;

        public Node(int value){
            this.value = value;
        }
    }

    // 全部放入栈中，从后往前对比
    public static boolean isPalindrome1(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Stack<Node> stack = new Stack<Node>();
        Node curr = head;
        while (curr != null){
            stack.push(curr);
            curr = curr.next;
        }
        curr = head;
        while (curr != null) {
            if (curr.value != stack.pop().value) {
                return false;
            }
            curr = curr.next;
        }
        return true;
    }

    // 折半放进栈中，额外的一个栈空间
    public static boolean isPalindrome2(Node head) {

        if (head == null || head.next == null) {
            return true;
        }
        Node slow = head.next;
        Node fast = head.next.next;

        while (fast.next != null && fast.next.next != null) {       // 1 1 1 1 1 1 1
            slow = slow.next;
            fast = fast.next.next;
        }

        Stack<Node> stack = new Stack<Node>();
        slow = slow.next;
        while (slow != null) {
            stack.push(slow);
            slow = slow.next;
        }
        slow = head;
        System.out.println(stack.size());
        for (int i = 0; i < stack.size(); i++) {
            if (slow.value != stack.pop().value) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome3 (Node head){
        if (head == null || head.next == null) {
            return true;
        }
        Node L = head.next;
        Node R = head.next.next;
        while (R.next != null && R.next.next != null) {
            L = L.next;
            R = R.next.next;
        }
        // 将后面的链表逆转过来
        R = L.next;
        L.next = null;
        Node temp = null;
        while (R.next != null) {
            temp = R.next;
            R.next = L;
            L = R;
            R = temp;
        }
        R.next = L;
        temp = R;

        L = head;
        boolean ans = true;
        while (L.next != null && R.next != null) {
            if (L.value != R.value) {
                ans = false;
                break;
            }
            L = L.next;
            R = R.next;
        }

        R = temp;
        L = R.next;
        R.next = null;
        while (L != null) {
            temp = L.next;
            L.next = R;
            R = L;
            L = temp;
        }

        return ans;
    }

    public static void main(String[] args) {
        Node test = null;   // 0 1 2 3 4 5 6 7 8
        test = new Node(1);
        test.next = new Node(2);
        test.next.next = new Node(3);
        test.next.next.next = new Node(2);
        test.next.next.next.next = new Node(1);
//        test.next.next.next.next.next = new LinkedListMid.Node(5);
//        test.next.next.next.next.next.next = new LinkedListMid.Node(6);
//        test.next.next.next.next.next.next.next = new LinkedListMid.Node(7);
//        test.next.next.next.next.next.next.next.next = new LinkedListMid.Node(8);

        System.out.println(isPalindrome3(test));
    }
}
