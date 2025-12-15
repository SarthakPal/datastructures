package com.datastructures.graphs;

import java.util.*;

// https://www.geeksforgeeks.org/problems/shortest-path-in-weighted-undirected-graph/1
// Dijkstra's algo ka hi code likhna hai bas ye add karna hai ki
// jab bhi kisi vertex ka distance update hota hai toh us vertex ka parent bhi update karna hai
// jis vertex ki wajah se distance update ho rha hai
public class ShortestPathInWeightedUndirectedGraph {

    class Edge {
        int destination;
        int distance;

        Edge(int destination, int distance) {
            this.destination = destination;
            this.distance = distance;
        }
    }

    class Node implements Comparable<Node> {
        int vertex;
        long distance;

        Node(long distance, int vertex) {
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node other) {
            if (this.distance < other.distance) return -1;
            if (this.distance > other.distance) return 1;
            return Integer.compare(this.vertex, other.vertex);
        }
    }

    public List<Integer> shortestPath(int n, int m, int edges[][]) {

        List<List<Edge>> adjList = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int source = edge[0];
            int destination = edge[1];
            int weight = edge[2];

            adjList.get(source).add(new Edge(destination, weight));
            adjList.get(destination).add(new Edge(source, weight));
        }

        final Long INF = Long.MAX_VALUE / 4;

        long[] distanceArray = new long[n + 1];

        Arrays.fill(distanceArray, INF);

        distanceArray[1] = 0L;

        TreeSet<Node> set = new TreeSet<>();
        set.add(new Node(0L, 1));

        int[] parent = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            parent[i] = i;
        }

        while (!set.isEmpty()) {
            Node node = set.pollFirst();

            int currentNode = node.vertex;
            long distance = node.distance;

            for (Edge edge : adjList.get(currentNode)) {
                int destination = edge.destination;
                int additionalDistance = edge.distance;


                long newDistance = distance + (long) additionalDistance;

                if (newDistance < distanceArray[destination]) {
                    if (distanceArray[destination] != INF) {
                        set.remove(new Node(distanceArray[destination], destination));
                    }

                    set.add(new Node(newDistance, destination));
                    parent[destination] = currentNode;
                    distanceArray[destination] = newDistance;
                }

            }
        }

        List<Integer> result = new ArrayList<>();

        if (distanceArray[n] == INF) {
            result.add(-1);
            return result;
        }

        result.add((int) distanceArray[n]);

        Stack<Integer> stack = new Stack<>();

        while (parent[n] != n) {
            stack.add(n);
            n = parent[n];
        }
        stack.add(1);

        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result;
    }


}
