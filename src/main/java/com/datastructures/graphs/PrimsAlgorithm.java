package com.datastructures.graphs;

import java.util.*;

// https://www.geeksforgeeks.org/problems/minimum-spanning-tree/1?utm_medium=article&utm_campaign=bottom_sticky_on_article&utm_source=gfg

public class PrimsAlgorithm {

    class Edge
    {
        int destination;
        int weight;

        Edge(int destination, int weight)
        {
            this.destination = destination;
            this.weight = weight;
        }
    }

    class Node
    {
        int weight;
        int vertex;
        int parent;

        Node(int weight, int vertex, int parent)
        {
            this.weight = weight;
            this.vertex = vertex;
            this.parent = parent;
        }
    }

    public int spanningTree(int V, int[][] edges) {

        List<List<Edge>> adjList = new ArrayList<>();

        for(int i=0;i<V;i++)
        {
            adjList.add(new ArrayList<>());
        }

        for(int[] edge : edges)
        {
            int src = edge[0];
            int dstn = edge[1];
            int weight = edge[2];

            adjList.get(src).add(new Edge(dstn , weight));
            adjList.get(dstn).add(new Edge(src , weight));

        }

        boolean[] inMst = new boolean[V];

        int[] parent = new int[V];
        Arrays.fill(parent, -1);

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a->a.weight));

        pq.add(new Node(0,0,-1));

        int sum = 0;

        while(!pq.isEmpty())
        {
            Node currNode = pq.poll();

            int weight = currNode.weight;
            int vertex = currNode.vertex;
            int prnt = currNode.parent;

            if(inMst[vertex]) continue;

            inMst[vertex] = true;
            parent[vertex] = prnt;
            sum+=weight;

            for(Edge edge : adjList.get(vertex))
            {
                int nghWeight = edge.weight;
                int nghVertex = edge.destination;

                if(inMst[nghVertex]==false)
                {
                    pq.add(new Node(nghWeight, nghVertex, vertex));
                }
            }
        }

        return sum;
    }

}
