package com.weekTrain.week3;

import java.util.*;

/**
 * @author Baven
 * @date 2022/4/8 19:15
 */
public class B04_Kruskal {
    public static class Graph {
        public HashMap<Integer, Node> nodes;
        public HashSet<Edge> edges;

        public Graph() {
            nodes = new HashMap<>();
            edges = new HashSet<>();
        }
    }

    public static class Edge {
        public int weight;
        public Node from;
        public Node to;

        public Edge(int weight, Node from, Node to) {
            this.weight = weight;
            this.from = from;
            this.to = to;
        }
    }

    public static class Node {
        public int value;
        public int in;
        public int out;
        public ArrayList<Node> nexts;
        public ArrayList<Edge> edges;

        public Node(int value) {
            this.value = value;
            in = 0;
            out = 0;
            nexts = new ArrayList<>();
            edges = new ArrayList<>();
        }
    }

    public static class UnionFind {
        private HashMap<Node, Node> parents;
        private HashMap<Node, Integer> sizeMap;

        public UnionFind() {
            parents = new HashMap<>();
            sizeMap = new HashMap<>();
        }

        // Collection : List Set 的上级
        public void makeSets(Collection<Node> nodes) {
            parents.clear();
            sizeMap.clear();
            for (Node node : nodes) {
                parents.put(node, node);
                sizeMap.put(node, 1);
            }
        }

        public Node findFather(Node node) {
            Stack<Node> stack = new Stack<>();
            while (parents.get(node) != node) {
                stack.push(node);
                node = parents.get(node);
            }
            while (!stack.isEmpty()) {
                parents.put(stack.pop(), node);
            }
            return node;
        }

        public boolean isSameSet(Node a, Node b) {
            return findFather(a) == findFather(b);
        }

        public void union(Node a, Node b) {
            if (!isSameSet(a, b)) {
                Node headA = findFather(a);
                Node headB = findFather(b);
                int sizeA = sizeMap.get(headA);
                int sizeB = sizeMap.get(headB);
                if (sizeA >= sizeB) {
                    parents.put(headB, headA);
                    sizeMap.put(headA, sizeA + sizeB);
                    sizeMap.remove(headB);
                } else {
                    parents.put(headA, headB);
                    sizeMap.put(headB, sizeA + sizeB);
                    sizeMap.remove(headA);
                }

            }
        }
    }

    public static class EdgeComparator implements Comparator<Edge> {
        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }
    }

    public static Set<Edge> kruskal(Graph graph) {
        UnionFind unionFind = new UnionFind();
        unionFind.makeSets(graph.nodes.values());
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
        for (Edge edge : graph.edges) {
            priorityQueue.add(edge);
        }
        // priorityQueue.addAll(graph.edges); 也可试用新的api，集体添加
        HashSet<Edge> ans = new HashSet<>();
        Edge cur = null;
        while (!priorityQueue.isEmpty()) {
            cur = priorityQueue.poll();
            if (!unionFind.isSameSet(cur.from, cur.to)) {
                ans.add(cur);
                unionFind.union(cur.from, cur.to);
            }
        }
        return ans;
    }
}
