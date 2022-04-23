package com.weekTrain.week2;

/**
 * @author Baven 链表的两道超难点之一 找两条链表初次相交的点
 * @date 2022/3/30 12:33
 */
public class A05_FindFristIntersectNode {
    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node getIntersectNode(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        if (loop1 == null && loop2 == null) {
            return noLoop(head1, head2);
        }
        if (loop1 != null && loop2 != null) {
            return bothLoop(head1, head2, loop1, loop2);
        }

        return null;
    }

    public static Node noLoop(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        int length = 0;
        Node n1 = head1;
        Node n2 = head2;
        while (n1.next != null) {
            length++;
            n1 = n1.next;
        }
        while (n2.next != null) {
            length--;
            n2 = n2.next;
        }
        if (n1 != n2) {
            return null;
        }
        n1 = length > 0 ? head1 : head2;
        n2 = n1 == head1 ? head2 : head1;
        length = Math.abs(length);
        while (length != 0) {
            length--;
            n1 = n1.next;
        }
        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }

    public static Node bothLoop(Node head1, Node head2, Node loop1, Node loop2) {
        Node c1 = null;
        Node c2 = null;
        if (loop1 == loop2) {
            c1 = head1;
            c2 = head2;
            int l = 0;
            while (c1.next != loop1) {
                l++;
                c1 = c1.next;
            }
            while (c2.next != loop1) {
                l--;
                c2 = c2.next;
            }
            c1 = l > 0 ? head1 : head2;
            c2 = c1 == head1 ? head2 : head1;
            l = Math.abs(l);
            while (l != 0) {
                l--;
                c1 = c1.next;
            }
            while (c1 != c2) {
                c1 = c1.next;
                c2 = c2.next;
            }
            return c1;

        } else {
            c1 = loop1.next;
            while (c1 != loop1) {
                if (c1 == loop2) {
                    return loop1;
                }
                c1 = c1.next;
            }
        }
        return null;
    }

    public static Node getLoopNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
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
        return fast;
    }

    public static void printNodeList(Node node) {
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Node node1 = null;
        node1 = new Node(9);
        node1.next = new Node(4);
        node1.next.next = new Node(2);
        node1.next.next.next = new Node(5);
        node1.next.next.next.next = new Node(3); // 相交
        node1.next.next.next.next.next = new Node(6);  // 入环
        node1.next.next.next.next.next.next = new Node(8);
        node1.next.next.next.next.next.next.next = new Node(2);
        node1.next.next.next.next.next.next.next.next = new Node(4);
        // node1.next.next.next.next.next.next.next.next.next = node1.next.next.next.next.next;

        Node node2 = null;
        node2 = new Node(4);
        node2.next = new Node(1);
        node2.next.next = node1.next.next.next.next;

        System.out.println(getIntersectNode(node1, node2).value);
    }
}
