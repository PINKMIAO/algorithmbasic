package com.baven;

import com.baven.linkedList.GetLinkedListLoop;

/**
 * Given a singly linked list L: L0 → L1 → … → Ln-1 → Ln,
 * reorder it to: L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
 */
public class ReverseList_143 {

    public static class Node {
        public int val;
        public Node next;

        public Node(int val) {
            this.val = val;
        }
    }


    public static void main(String[] args) {
        Node head = null;
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        //head.next.next.next = new Node(4);

        printList(head);
        reorderList(head);
        printList(head);
    }

    public static void printList(Node head) {
        System.out.print("ListNode: ");
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }


    public static void reorderList(Node head) {
        Node mid = midOrDownMid(head);

        Node L = mid;
        Node R = mid.next;
        mid.next = null;
        Node temp = null;
        while (R.next != null) {
            temp = R.next;
            R.next = L;
            L = R;
            R = temp;
        }
        R.next = L;

        L = head;
        int count = 0;
        while (L != null) {
            count++;
            L = L.next;
        }

        L = head;
        Node n1 = null, n2 = null;
        while (L != mid && R != mid) {
            n1 = L.next;
            n2 = R.next;
            L.next = R;
            R.next = n1;

            L = n1;
            R = n2;
        }
        if (0 == (count % 2)) {
            L.next = R;
        }

    }

    public static Node midOrDownMid(Node head) {
        Node slow = head.next;
        Node fast = head.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
