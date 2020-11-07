package com.baven.linkedList;

/**
 * 根据给定的值，划分 小于区 、等于区 、大于区
 */
public class SmallEqualBigger {

    public static class Node{
        public int value;
        public Node next;
        public Node(int value){
            this.value = value;
        }
    }

    public static Node listPartition(Node head, int pivot) {
        if (head == null) {
            return head;
        }
        Node curr = head;
        int i = 0;
        while (curr != null) {
            i++;
            curr = curr.next;
        }

        Node[] nodeArr = new Node[i];
        i = 0;
        curr = head;
        for (i = 0; i < nodeArr.length; i++) {
            nodeArr[i] = curr;
            curr = curr.next;
        }
        arrPartition(nodeArr, pivot);
        for (i = 1; i < nodeArr.length; i++) {
            nodeArr[i - 1].next = nodeArr[i];
        }
        nodeArr[i - 1].next = null;
        return nodeArr[0];
    }

    public static void arrPartition(Node[] nodeArr, int pivot) {
        int small = -1;
        int big = nodeArr.length;
        int index = 0;

        while (index < big) {
            if (nodeArr[index].value == pivot) {
                index++;
            } else if (nodeArr[index].value < pivot) {
                swag(nodeArr, index++, ++small);
            } else if (nodeArr[index].value > pivot) {
                swag(nodeArr, index, --big);
            }
        }
    }
    public static void swag(Node[] nodeArr, int i, int j) {
        Node temp = nodeArr[i];
        nodeArr[i] = nodeArr[j];
        nodeArr[j] = temp;
    }
    public static void printLinked(Node head) {
        System.out.print("LinkedList: ");
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
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
        test.next.next.next.next.next.next.next = new Node(3);
        test.next.next.next.next.next.next.next.next = new Node(3);

        printLinked(test);
        Node node = listPartition(test, 3);
        printLinked(node);
        //getLoop(test);
    }

}
