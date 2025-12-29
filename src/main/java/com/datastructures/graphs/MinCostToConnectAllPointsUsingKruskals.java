package com.datastructures.graphs;

import java.util.*;

// https://leetcode.com/problems/min-cost-to-connect-all-points/
public class MinCostToConnectAllPointsUsingKruskals {

    class Edge
    {
        int src;
        int destination;
        int distance;

        Edge(int src, int destination, int distance)
        {
            this.src = src;
            this.destination = destination;
            this.distance = distance;
        }

    }

    int[] parent;
    int[] rank;

    public int find(int x)
    {
        if(x==parent[x])
        {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    public void union(int x, int y)
    {
        int parent_x = parent[x];
        int parent_y = parent[y];

        if(parent_x == parent_y) return;

        if(rank[parent_x] > rank[parent_y])
        {
            parent[parent_y] = parent[parent_x];
        }
        else if(rank[parent_y] > rank[parent_x])
        {
            parent[parent_x] = parent[parent_y];
        }
        else
        {
            parent[parent_x] = parent[parent_y];
            rank[parent_y]++;
        }
    }

    public int kruskal(PriorityQueue<Edge> pq)
    {

        int sum = 0;

        while(!pq.isEmpty())
        {
            Edge currentEdge = pq.poll();

            int src = currentEdge.src;
            int destination = currentEdge.destination;
            int distance = currentEdge.distance;

            int parent_src = find(src);
            int parent_destination = find(destination);

            if(parent_src!=parent_destination)
            {
                union(src, destination);
                sum+=distance;
            }
        }

        return sum;
    }

    public int minCostConnectPoints(int[][] points) {

        int V = points.length;

        parent = new int[V];
        rank = new int[V];

        for(int i=0;i<V;i++)
        {
            parent[i] = i;
            rank[i] = 0;
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(a->a.distance));

        for(int i=0;i<V;i++)
        {
            for(int j=i+1;j<V;j++)
            {
                int x1 = points[i][0];
                int y1 = points[i][1];

                int x2 = points[j][0];
                int y2 = points[j][1];

                int dist = Math.abs(x1-x2) + Math.abs(y1-y2);

                pq.add(new Edge(i, j, dist));
            }
        }

        return kruskal(pq);
    }
}
