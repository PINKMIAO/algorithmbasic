package com.weekTrain.week2;

/**
 * @author Baven
 * @date 2022/3/29 22:44
 */
public class A03_SmallerEqualBigger {
    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node listPartition1(Node head, int pivot) {
        if (head == null) {
            return head;
        }
        int i = 0;
        Node cur = head;
        while (cur != null) {
            i++;
            cur = cur.next;
        }
        Node[] nodeArr = new Node[i];
        cur = head;
        i = 0;
        while (cur != null) {
            nodeArr[i++] = cur;
            cur = cur.next;
        }
        arrPartition(nodeArr, pivot);
        for (i = 1; i < nodeArr.length; i++) {
            nodeArr[i - 1].next = nodeArr[i];
        }
        nodeArr[i - 1].next = null;
        return nodeArr[0];
    }

    public static void arrPartition(Node[] arr, int num) {
        int less = -1;
        int more = arr.length;
        int index = 0;
        while (index < more) {
            if (arr[index].value == num) {
                index++;
            } else if (arr[index].value < num) {
                swap(arr, index++, ++less);
            } else {
                swap(arr, index, --more);
            }
        }
    }

    public static void swap(Node[] arr, int i, int j) {
        Node tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static Node listPartition2(Node head, int pivot) {
        Node sh = null;
        Node st = null;
        Node eh = null;
        Node et = null;
        Node bh = null;
        Node bt = null;
        Node next = null;
        while (head != null) {
            // 注意置空
            next = head.next;
            head.next = null;
            if (head.value < pivot) {
                if (sh == null) {
                    sh = head;
                    st = head;
                } else {
                    st.next = head;
                    st = head;
                }
            } else if (head.value == pivot) {
                if (eh == null) {
                    eh = head;
                    et = head;
                } else {
                    et.next = head;
                    et = head;
                }
            } else {
                if (bh == null) {
                    bh = head;
                    bt = head;
                } else {
                    bt.next = head;
                    bt = head;
                }
            }
            head = next;
        }
        // printNodeList(sh);
        // printNodeList(eh);
        // printNodeList(bh);
        if (st != null) {
            st.next = eh;
            et = et == null ? st : et;
        }
        if (et != null) {
            et.next = bh;
        }
        return sh != null ? sh : (eh != null ? eh : bh);
    }

    public static void printNodeList(Node node) {
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node node = null;
        node = new Node(9);
        node.next = new Node(4);
        node.next.next = new Node(2);
        node.next.next.next = new Node(5);
        node.next.next.next.next = new Node(3);
        node.next.next.next.next.next = new Node(6);
        node.next.next.next.next.next.next = new Node(8);
        node.next.next.next.next.next.next.next = new Node(2);
        node.next.next.next.next.next.next.next.next = new Node(4);
        node.next.next.next.next.next.next.next.next.next = new Node(6);

        printNodeList(node);
        // printNodeList(listPartition1(node, 5));
        printNodeList(listPartition2(node, 5));
    }
}
