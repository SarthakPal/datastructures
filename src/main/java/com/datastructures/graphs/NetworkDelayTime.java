package com.datastructures.graphs;

import java.util.*;

//https://leetcode.com/problems/network-delay-time/
public class NetworkDelayTime {

    class Edge
    {
        int destination;
        int distance;

        Edge(int destination, int distance)
        {
            this.destination = destination;
            this.distance = distance;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {

        List<List<Edge>> adjList = new ArrayList<>();

        for(int i=0;i<n+1;i++)
        {
            adjList.add(new ArrayList<>());
        }

        for(int edge[] : times)
        {
            int source = edge[0];
            int destination = edge[1];
            int distance = edge[2];

            adjList.get(source).add(new Edge(destination, distance));
        }

        int[] distanceArray = new int[n+1];
        Arrays.fill(distanceArray, Integer.MAX_VALUE);

        int src = k;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a->a[0]));
        pq.add(new int[]{0, src});

        distanceArray[src] = 0;

        while(!pq.isEmpty())
        {
            int[] currNode = pq.poll();

            int distance = currNode[0];
            int currVertex = currNode[1];

            for(Edge neighbour : adjList.get(currVertex))
            {
                int destination = neighbour.destination;
                int addDist = neighbour.distance;

                int newDist = distance + addDist;

                if(newDist < distanceArray[destination])
                {
                    distanceArray[destination] = newDist;
                    pq.add(new int[]{newDist, destination});
                }

            }
        }

        int ans = Integer.MIN_VALUE;

        for(int i=1;i<n+1;i++)
        {
            if(distanceArray[i]==Integer.MAX_VALUE)
            {
                return -1;
            }

            ans = Math.max(ans, distanceArray[i]);
        }

        return ans;
    }
}
