package com.datastructures.graphs;

import java.util.*;

public class KruskalsAlgorithm {

    public List<GraphEdge> minimumSpanningTree(WeightedGraph graph)
    {

        PriorityQueue<GraphEdge> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(GraphEdge::getWeight));

        for(List<GraphEdge> edges : graph.getAdjacencyList())
        {
            priorityQueue.addAll(edges);
        }

        Set<Integer> visited = new HashSet<>();

        List<GraphEdge> mstEdges = new ArrayList<>();

        while(!priorityQueue.isEmpty())
        {
            GraphEdge currentEdge = priorityQueue.poll();

            int source = currentEdge.getSource();
            int destination = currentEdge.getDestination();

            if(mstEdges.contains(source) && mstEdges.contains(destination))
            {
                continue;
            }

            visited.add(source);
            visited.add(destination);

            mstEdges.add(currentEdge);

        }

        return mstEdges;
    }

}
