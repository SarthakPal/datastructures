package com.datastructures.graphs;

import java.util.List;

public class DetectCycleInUndirectedGraphUsingBFS {

    public static boolean isCycleBFS(List<List<Integer>> adj, int start, boolean[] visited)
    {
        java.util.Queue<int[]> queue = new java.util.LinkedList<>();
        queue.add(new int[]{start, -1}); // {node,parent}

        while(!queue.isEmpty())
        {
            int[] node = queue.poll();
            int current = node[0];
            int parent = node[1];

            visited[current] = true;

            for(int neighbor : adj.get(current))
            {
                if(!visited[neighbor])
                {
                    queue.add(new int[]{neighbor, current});
                }
                else if(neighbor != parent)
                {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCycle(int V, int[][] edges) {

        List<List<Integer>> adj = new java.util.ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new java.util.ArrayList<>());
        }

        for(int[] edge : edges)
        {
            int source = edge[0];
            int destination = edge[1];

            adj.get(source).add(destination);
            adj.get(destination).add(source);

        }

        boolean[] visited = new boolean[V];

        for(int i=0;i<V;i++)
        {
            if(!visited[i] && isCycleBFS(adj, i, visited))
            {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int V = 4;
        int[][] edges = {{1,2}, {1,3}, {2,1}, {2,3}, {3,1}, {3,2}};

        DetectCycleInUndirectedGraphUsingDFS sol = new DetectCycleInUndirectedGraphUsingDFS();
        System.out.println(sol.isCycle(V, edges));
    }

}
