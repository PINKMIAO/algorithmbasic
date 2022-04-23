package com.weekTrain.week3;

import java.util.*;

/**
 * @author Baven
 * @date 2022/4/8 14:40
 */
public class B01_BFS {
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

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Node node = (Node) o;
            return value == node.value && in == node.in && out == node.out && Objects.equals(nexts, node.nexts) && Objects.equals(edges, node.edges);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, in, out, nexts, edges);
        }
    }

    public static Graph graphGenerator(int[][] matrix) {
        Graph graph = new Graph();
        for (int[] ints : matrix) {
            int weight = ints[0];
            int from = ints[1];
            int to = ints[2];
            if (!graph.nodes.containsKey(from)) {
                graph.nodes.put(from, new Node(from));
            }
            if (!graph.nodes.containsKey(to)) {
                graph.nodes.put(to, new Node(to));
            }
            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);
            Edge newEdge = new Edge(weight, fromNode, toNode);
            fromNode.nexts.add(toNode);
            fromNode.edges.add(newEdge);
            fromNode.out++;
            toNode.in++;
            graph.edges.add(newEdge);
        }
        return graph;
    }

    public static void bfs(Node start) {
        if (start == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();
        queue.add(start);
        set.add(start);
        Node node = null;
        while (!queue.isEmpty()) {
            node = queue.poll();
            System.out.print(node + " ");
            for (Node next : node.nexts) {
                if (!set.contains(node)) {
                    queue.add(node);
                    set.add(node);
                }
            }
        }
    }

}
