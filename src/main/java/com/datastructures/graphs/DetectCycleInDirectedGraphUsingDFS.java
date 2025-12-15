package com.datastructures.graphs;

import java.util.ArrayList;
import java.util.List;

public class DetectCycleInDirectedGraphUsingDFS {

    public boolean isCycleDFS(int currentVertex, boolean[] visited, boolean[] inRecursion, List<List<Integer>> adj)
    {

        visited[currentVertex] = true;
        inRecursion[currentVertex] = true;

        for(int neighbour : adj.get(currentVertex))
        {
            if(!visited[neighbour] && isCycleDFS(neighbour, visited, inRecursion, adj))
            {
                return true;
            }
            else if (inRecursion[neighbour])
            {
                return true;
            }
        }

        inRecursion[currentVertex] = false;
        return false;

    }

    public boolean isCycle(int vertices, int[][] edges)
    {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<vertices;i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges)
        {
            int source = edge[0];
            int destination = edge[1];

            adj.get(source).add(destination);
        }

        boolean[] visited = new boolean[vertices];
        boolean[] inRecursion = new boolean[vertices];

        for(int i=0;i<vertices;i++)
        {
            if(!visited[i] && isCycleDFS(i, visited, inRecursion, adj))
            {
                return true;
            }
        }

        return false;

    }

    public static void main(String[] args) {
        int V = 3;
        int[][] edges = {{0,1}, {2,1}};

        DetectCycleInDirectedGraphUsingDFS sol = new DetectCycleInDirectedGraphUsingDFS();
        System.out.println(sol.isCycle(V, edges));
    }

}
