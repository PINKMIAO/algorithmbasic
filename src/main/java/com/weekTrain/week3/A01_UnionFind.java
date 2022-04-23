package com.weekTrain.week3;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * @author Baven
 * @date 2022/4/6 15:08
 */
public class A01_UnionFind {
    public static class Node<V> {
        V value;
        public Node(V v) {
            value = v;
        }
    }

    public static class unionFind<V> {
        public HashMap<V, Node<V>> nodes;
        public HashMap<Node<V>, Node<V>> parents;
        public HashMap<Node<V>, Integer> sizeMap;

        public unionFind(List<V> values) {
            nodes = new HashMap<>();
            parents = new HashMap<>();
            sizeMap = new HashMap<>();
            for (V value : values) {
                Node<V> node = new Node<>(value);
                nodes.put(value, node);
                parents.put(node, node);
                sizeMap.put(node, 1);
            }
        }

        public Node<V> findFather(Node<V> node) {
            Stack<Node<V>> path = new Stack<>();
            while (node != parents.get(node)) {
                path.push(node);
                node = parents.get(node);
            }
            while (!path.isEmpty()) {
                parents.put(path.pop(), node);
            }
            return node;
        }

        public boolean isSameSet(V a, V b) {
            return findFather(nodes.get(a)) == findFather(nodes.get(b));
        }

        public void union(V a, V b) {
            Node<V> headA = findFather(nodes.get(a));
            Node<V> headB = findFather(nodes.get(b));
            if (headA != headB) {
                int sizeA = sizeMap.get(headA);
                int sizeB = sizeMap.get(headB);
                Node<V> big = sizeA >= sizeB ? headA : headB;
                Node<V> small = big == headA ? headB : headA;
                parents.put(small, big);
                sizeMap.put(big, sizeA + sizeB);
                sizeMap.remove(small);
            }
        }

        public int set() {
            return sizeMap.size();
        }
    }

    public static class Node2 {
        int value;
        public Node2(int v) {
            value = v;
        }
    }

    public static class unionFind2 {
        public int[] parents;
        public int[] size;

        public unionFind2(int[] arr) {
            parents = new int[arr.length];
            size = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                parents[i] = arr[i];
                size[i] = 1;
            }
        }

        public boolean isSameSet(int a, int b) {
            return parents[a] == parents[b];
        }

        public void union(int a, int b) {
            int headA = parents[a];
            int headB = parents[b];
            if (headA != headB) {
                if (size[headA] > size[headB]) {
                    parents[b] = headA;
                    size[headA] += size[headB];
                } else {
                    parents[a] = headB;
                    size[headB] += size[headA];
                }
            }
        }
    }
}
