package com.datastructures.graphs;

public class FloydWarshallAlgorithm {

    public void floydWarshall(int[][] dist) {
        // Code here

        int rows = dist.length;
        int cols = dist[0].length;

        int INF = (int)100000000;

        for(int via=0;via<rows;via++)
        {
            for(int i=0;i<rows;i++)
            {
                for(int j=0;j<cols;j++)
                {

                    // If either leg is unreachable, skip
                    if (dist[i][via] == INF || dist[via][j] == INF) {
                        continue;
                    }

                    dist[i][j] = Math.min(dist[i][j], dist[i][via]+dist[via][j]);
                }
            }
        }
    }
}
