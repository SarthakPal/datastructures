package com.datastructures.graphs;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraShortestPath {

        public int[] findShortestPath(WeightedGraph graph, int source)
        {

                int[] distances = new int[graph.getVertices()];
                List<GraphEdge>[] vertices = graph.getAdjacencyList();

                PriorityQueue<GraphEdge> priorityQueue = new PriorityQueue<>(Comparator.comparing(GraphEdge::getWeight));

                distances[source] = 0;
                priorityQueue.add(new GraphEdge(source, source, 0));

                while(!priorityQueue.isEmpty())
                {

                        GraphEdge currentEdge = priorityQueue.poll();
                        int destination = currentEdge.getDestination();

                        for(GraphEdge edge : vertices[destination])
                        {
                                int newDistance = distances[destination] + edge.getWeight();

                                if(newDistance < distances[edge.getDestination()])
                                {
                                        distances[edge.getDestination()] = newDistance;
                                        priorityQueue.add(new GraphEdge(edge.getSource(), edge.getDestination(), edge.getWeight()));
                                }
                        }
                }

                return distances;
        }

}
