package com.datastructures.graphs;

import java.util.*;

public class MinCostToConnectAllPointsUsingPrims {

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

    class Node
    {
        int distance;
        int vertex;

        Node(int distance, int vertex)
        {
            this.distance = distance;
            this.vertex = vertex;
        }
    }

    public int findUsingPrims(int v, List<List<Edge>> adjList)
    {
        boolean inMst[] = new boolean[v];

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a->a.distance));

        pq.add(new Node(0,0));

        int sum = 0;

        while(!pq.isEmpty())
        {
            Node currNode = pq.poll();

            int distance = currNode.distance;
            int vertex = currNode.vertex;

            if(inMst[vertex]) continue;

            inMst[vertex] = true;
            sum+=distance;

            for(Edge edge : adjList.get(vertex))
            {
                int nghVertex = edge.destination;
                int nghDistance = edge.distance;

                if(inMst[nghVertex]==false)
                {
                    pq.add(new Node(nghDistance, nghVertex));
                }
            }
        }

        return sum;
    }

    public int minCostConnectPoints(int[][] points) {

        int v = points.length;

        List<List<Edge>> adjList = new ArrayList<>();

        for(int i=0;i<v;i++)
        {
            adjList.add(new ArrayList<>());
        }

        for(int i=0;i<v;i++)
        {
            for(int j=i+1;j<v;j++)
            {
                int x1 = points[i][0];
                int y1 = points[i][1];

                int x2 = points[j][0];
                int y2 = points[j][1];

                int dist = Math.abs(x1-x2) + Math.abs(y1-y2);

                adjList.get(i).add(new Edge(j, dist));
                adjList.get(j).add(new Edge(i, dist));
            }
        }

        return findUsingPrims(v, adjList);
    }
}
