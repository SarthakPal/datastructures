package com.datastructures.graphs;

import java.util.*;

public class TopologicalSortUsingDFS {

    public static void dfs(int currentVertex, Set<Integer> visited, Stack<Integer> stack,
                           List<List<Integer>> adjacencyList)
    {

        visited.add(currentVertex);

        for(Integer neighbour : adjacencyList.get(currentVertex))
        {
            if(!visited.contains(neighbour))
            {
                dfs(neighbour, visited, stack, adjacencyList);
            }
        }

        stack.push(currentVertex);

    }

    public static ArrayList<Integer> topoSort(int vertices, int[][] edges) {
        // code here

        List<List<Integer>> adjList = new ArrayList<>();

        for(int i=0;i<vertices;i++)
        {
            adjList.add(new ArrayList<>());
        }

        for(int[] edge : edges)
        {
            int source = edge[0];
            int destination = edge[1];

            adjList.get(source).add(destination);
        }

        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();


        for(int i=0;i<vertices;i++)
        {
            if(!visited.contains(i))
            {
                dfs(i, visited, stack, adjList);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        while(!stack.isEmpty())
        {
            result.add(stack.pop());
        }

        return result;

    }

}
