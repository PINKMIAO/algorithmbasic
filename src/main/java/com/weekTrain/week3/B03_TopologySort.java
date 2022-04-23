package com.weekTrain.week3;

import java.util.*;

/**
 * @author Baven
 * @date 2022/4/8 15:55
 */
public class B03_TopologySort {
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
        public ArrayList<Node> edges;

        public Node(int value) {
            this.value = value;
            in = 0;
            out = 0;
            nexts = new ArrayList<>();
            edges = new ArrayList<>();
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

    public static List<Node> sortedTopology(Graph graph) {
        // 这个节点有几个入度
        HashMap<Node, Integer> inMap = new HashMap<>();
        Queue<Node> zeroInQueue = new LinkedList<>();
        for (Node node : graph.nodes.values()) {
            inMap.put(node, node.in);
            if (node.in == 0) {
                zeroInQueue.add(node);
            }
        }

        ArrayList<Node> ans = new ArrayList<>();
        Node node = null;
        while (!zeroInQueue.isEmpty()) {
            node = zeroInQueue.poll();
            ans.add(node);
            for (Node next : node.nexts) {
                // 确认是否需要用到 inMap
                next.in--;
                if (node.in == 0) {
                    zeroInQueue.add(node);
                }
            }
        }
        return ans;
    }
}
