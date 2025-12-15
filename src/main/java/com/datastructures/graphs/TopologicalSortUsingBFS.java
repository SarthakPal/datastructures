package com.datastructures.graphs;

import java.util.ArrayList;
import java.util.List;

public class TopologicalSortUsingBFS {

    public static ArrayList<Integer> topoSort(int vertices, int[][] edges) {
        // code here

        List<List<Integer>> adjList = new ArrayList<>();

        for(int i=0;i<vertices;i++)
        {
            adjList.add(new ArrayList<>());
        }

        int[] inDegree = new int[vertices];

        for(int[] edge : edges)
        {
            int source = edge[0];
            int destination = edge[1];

            adjList.get(source).add(destination);
            inDegree[destination]++;
        }

        java.util.Queue<Integer> queue = new java.util.LinkedList<>();

        for(int i=0;i<vertices;i++)
        {
            if(inDegree[i] == 0)
            {
                queue.add(i);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        while(!queue.isEmpty())
        {
            int currentVertex = queue.poll();
            result.add(currentVertex);

            for(Integer neighbor : adjList.get(currentVertex))
            {
                inDegree[neighbor]--;

                if(inDegree[neighbor] == 0)
                {
                    queue.add(neighbor);
                }
            }
        }

        return result;
    }

}
