package com.baven.linkedList;

import java.util.ArrayList;

/**
 * 取 基数链表的中位， 偶数链表的上中位或下中位等
 */
public class LinkedListMid {

    public static class Node{
        public int value;
        public Node next;

        public Node(int value){
            this.value = value;
        }
    }

    // 面试时候要用这个方式
    public static Node midOrUpMidNode(Node head){ // 获取基数中位，偶数上中位
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        Node slow = head.next;          // 要从这里开始，否则数字对不上
        Node fast = head.next.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public static Node midOrDownMidNode(Node head) { // 获取基数中位数，偶数下中位
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
    public static Node midOrUpMidPreNode(Node head){ // 获取基数中位前一个，偶数上中位的前一个
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        Node slow = head;
        Node fast = head.next.next;
        while (fast.next != null && fast.next.next != null ){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node right1(Node head) {      // 笔试的时候可以用这个
        if (head == null) {
            return head;
        }
        Node curr = head;
        ArrayList<Node> arr = new ArrayList<Node>();
        while (curr != null) {
            arr.add(curr);
            curr = curr.next;
        }
        return arr.get((arr.size() - 1) / 2);   // 根据不同的情况返回不同的中间位
        // return arr.get((arr.size() - 2) / 2);
    }



    public static void main(String[] args) {
        Node test = null;   // 0 1 2 3 4 5 6 7 8
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
        Node ans = midOrDownMidNode(test);
        System.out.println(ans.value);
    }

}
