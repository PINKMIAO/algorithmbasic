package com.weekTrain.week3;

import java.util.*;

/**
 * @author Baven
 * @date 2022/4/8 20:32
 */
public class B05_Prim {
    public static class Edge {
        public int weight;
        public Node from;
        public Node to;

        public Edge(int weight, Node from, Node in) {
            this.weight = weight;
            this.from = from;
            this.to = in;
        }
    }

    public static class Graph {
        public HashMap<Integer, Node> nodes;
        public HashSet<Edge> edges;

        public Graph() {
            nodes = new HashMap<>();
            edges = new HashSet<>();
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

    public static class EdgeComparator implements Comparator<Edge> {
        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }
    }

    public static Set<Edge> prim(Graph graph) {
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
        HashSet<Node> set = new HashSet<>();
        HashSet<Edge> ans = new HashSet<>();

        for (Node node : graph.nodes.values()) {
            if (!set.contains(node)) {
                set.add(node);
                priorityQueue.addAll(node.edges);
                while (!priorityQueue.isEmpty()) {
                    Edge cur = priorityQueue.poll();
                    Node toNode = cur.to;
                    if (!set.contains(toNode)) {
                        set.add(toNode);
                        ans.add(cur);
                        priorityQueue.addAll(toNode.edges);
                    }
                }
            }
            // break;
        }
        return ans;
    }
}
