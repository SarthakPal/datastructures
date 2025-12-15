package com.datastructures.graphs;

import java.util.ArrayList;
import java.util.List;


// we will use the logic of topological sort using BFS (Kahn's Algorithm).
// if every node is processed in topological sort, then there is no cycle. that means indegree of every node becomes 0 at some point.
// if count of processed nodes is not equal to total number of nodes, then there is a cycle.
public class DetectCycleInDirectedGraphUsingBFS {

    public static boolean isCycle(int vertices, int[][] edges) {

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[vertices];

        for(int[] edge : edges)
        {
            int source = edge[0];
            int destination = edge[1];

            adj.get(source).add(destination);
            indegree[destination]++;
        }

        java.util.Queue<Integer> queue = new java.util.LinkedList<>();

        for(int i=0;i<vertices;i++)
        {
            if(indegree[i] == 0)
            {
                queue.add(i);
            }
        }

        int count = 0;

        while(!queue.isEmpty())
        {

            int currentVertex = queue.poll();
            count++;

            for(Integer neighbor : adj.get(currentVertex))
            {
                indegree[neighbor]--;

                if(indegree[neighbor] == 0)
                {
                    queue.add(neighbor);
                }
            }
        }

        return count != vertices;

    }

    public static void main(String[] args) {
        int V = 3;
        int[][] edges = {{0,1}, {2,1}};

        DetectCycleInDirectedGraphUsingBFS sol = new DetectCycleInDirectedGraphUsingBFS();
        System.out.println(isCycle(V, edges));
    }

}
