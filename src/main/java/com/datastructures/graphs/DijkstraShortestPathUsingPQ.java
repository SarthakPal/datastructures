package com.datastructures.graphs;

import java.util.*;

public class DijkstraShortestPathUsingPQ {

                public class Edge
                {
                        int destination;
                        int distance;
                        Edge(int destination, int distance)
                        {
                                this.destination = destination;
                                this.distance = distance;
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

                        long[] distanceArray = new long[V];

                        final long INF = Long.MAX_VALUE / 4;

                        Arrays.fill(distanceArray, INF);

                        distanceArray[src] = 0;

                        // in the PriorityQueue we will first insert distance then insert node because
                        // we need to compare based on distance.
                        // below comparison is the lambda version of
                        // PriorityQueue<long[]> pq = new PriorityQueue<>(new Comparator<long[]>() {
                        //    @Override
                        //    public int compare(long[] a, long[] b) {
                        //        return Long.compare(a[0], b[0]);
                        //    }
                        //    });
                        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));

                        pq.add(new long[] {0L, src});

                        while(!pq.isEmpty())
                        {
                                long[] cur = pq.poll();

                                int distance = (int) cur[0];
                                int current_node = (int) cur[1];

                                for(Edge edge : adjList.get(current_node))
                                {
                                        int destination = edge.destination;
                                        int additional_distance = edge.distance;

                                        long new_distance =distance + (long) additional_distance;

                                        if(new_distance < distanceArray[destination])
                                        {
                                                distanceArray[destination] = new_distance;
                                                pq.add(new long[] {new_distance, destination});
                                        }

                                }

                        }

                        int[] result = new int[V];

                        for(int i=0;i<V;i++)
                        {
                                result[i] = distanceArray[i] == INF ? -1 : (int) distanceArray[i];
                        }

                        return result;

                }

}
