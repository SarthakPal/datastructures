package com.datastructures.graphs;

import java.util.*;

public class DetectCycleInUndirectedGraphUsingDFS {

        public static boolean isCycleDFS(List<List<Integer>> adj, int currentVertex,
                                         boolean[] visited, int parent)
        {
            visited[currentVertex] = true;

            for(int neighbour : adj.get(currentVertex))
            {
                if(!visited[neighbour])
                {
                    if(isCycleDFS(adj, neighbour, visited, currentVertex)) {
                        return true;
                    }
                }
                else if(neighbour != parent)
                {
                    return true;
                }

            }

            return false;
        }

        public boolean isCycle(int V, int[][] edges) {
            // Build adjacency list
            List<List<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

            for (int[] e : edges) {
                int u = e[0];
                int v = e[1];
                adj.get(u).add(v);
                adj.get(v).add(u);
            }

            boolean[] visited = new boolean[V];

            for(int i=0;i<V;i++)
            {
                if(!visited[i] && isCycleDFS(adj, i, visited, -1))
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
