package com.datastructures.graphs;

import java.util.*;

// PQ wale example main ek baar hum {4,0} pe iterate karte hain phir {6,0} pe karte hain
// but jab {4,0} par kar chuke hain toh {6,0} pe karna ka koi sense nahi hai kyuki 6>4 and we want min distance
// isliye set ka use kar rahe hain kyuki set main se entry delete kar sakte hain but PQ main se nahi kar sakte hain

public class DijkstraShortestPathUsingSet {

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

        class Node implements Comparable<Node>
        {

            long distance;
            int vertex;

            Node(long distance, int vertex)
            {
                this.distance = distance;
                this.vertex = vertex;
            }

            @Override
            public int compareTo(Node other)
            {
                if(this.distance < other.distance) return -1;
                if(this.distance > other.distance) return 1;
                return Integer.compare(this.vertex, other.vertex);
            }
        }

        public int[] dijkstra(int V, int[][] edges, int src) {
            // code here
            List<List<Edge>> adjList = new ArrayList<>();

            for(int i=0;i<V;i++)
            {
                adjList.add(new ArrayList<>());
            }

            for(int[] edge : edges)
            {
                int source = edge[0];
                int destination = edge[1];
                int distance = edge[2];

                adjList.get(source).add(new Edge(destination, distance));
                adjList.get(destination).add(new Edge(source, distance));
            }

            final long INF = Long.MAX_VALUE / 4;

            long[] distanceArray = new long[V];

            Arrays.fill(distanceArray, INF);

            distanceArray[src] = 0L;

            TreeSet<Node> set = new TreeSet<>();
            set.add(new Node(0L, src));

            while(!set.isEmpty())
            {
                Node node = set.pollFirst();

                int currentNode = node.vertex;
                long distance = node.distance;

                for(Edge edge : adjList.get(currentNode))
                {
                    int destination = edge.destination;
                    int additionalDistance = edge.distance;

                    long newDistance = distance + (long) additionalDistance;

                    if(newDistance < distanceArray[destination])
                    {
                        if(distanceArray[destination]!=INF) set.remove(new Node(distanceArray[destination], destination));

                        distanceArray[destination] = newDistance;
                        set.add(new Node(newDistance, destination));
                    }

                }
            }

            int[] ans = new int[V];
            for (int i = 0; i < V; i++) ans[i] = (distanceArray[i] == INF) ? -1 : (int) distanceArray[i];
            return ans;
        }
}
