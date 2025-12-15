package com.datastructures.graphs;

import java.util.*;

public class DiameterOfGraph {

    public int treeDiameter(int[][] edges) {

        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];

            adjList.putIfAbsent(u, new java.util.ArrayList<>());
            adjList.putIfAbsent(v, new java.util.ArrayList<>());

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        return findDiameter(adjList);
    }

    public int findDiameter(Map<Integer, List<Integer>> adjList) {

        int[] farthestNode = findFartheseNode(adjList, 0);

        int[] diameterInfo = findFartheseNode(adjList, farthestNode[0]);

        return diameterInfo[1];
    }

    public int[] findFartheseNode(Map<Integer, List<Integer>> adjList, int sourceNode) {
        // Perform BFS from an arbitrary node (e.g., node 0)
        // to find the farthest node from it.

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(sourceNode);
        visited.add(sourceNode);

        int farthestNode = sourceNode;
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int currentNode = queue.poll();
                farthestNode = currentNode;

                for (Integer neighbor : adjList.get(currentNode)) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.add(neighbor);
                    }
                }
            }

            if (!queue.isEmpty()) {
                level++;
            }
        }

        return new int[]{farthestNode, level};
    }

}
