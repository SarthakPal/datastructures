package com.datastructures.graphs;

import java.util.Arrays;

//https://www.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/1
public class BellmanFordAlgorithm {

    public int[] bellmanFord(int V, int[][] edges, int source) {

        int[] distance = new int[V];
        Arrays.fill(distance, 100000000);

        distance[source] = 0;

        for(int i=1;i<=V-1;i++)
        {
            for(int[] edge : edges)
            {
                int src = edge[0];
                int destn = edge[1];
                int cost = edge[2];

                if(distance[src]!=100000000 &&
                        distance[src]+cost<distance[destn])
                {
                    distance[destn] = distance[src]+cost;
                }
            }
        }

        // detect cycle
        for(int[] edge : edges)
        {
            int src = edge[0];
            int destn = edge[1];
            int cost = edge[2];

            if(distance[src]!=100000000 && distance[src]+cost<distance[destn])
            {
                return new int[]{-1};
            }
        }

        return distance;

    }
}
