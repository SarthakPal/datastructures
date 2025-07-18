package com.datastructures.graphs;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class PrimsAlgorithm {

    public List<GraphEdge> minimumSpanningTree(WeightedGraph graph)
    {
        List<GraphEdge> mstEdges = new java.util.ArrayList<>();

        List<GraphEdge>[] vertices = graph.getAdjacencyList();

        boolean[] inMst = new boolean[graph.getVertices()];

        PriorityQueue<GraphEdge> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(GraphEdge::getWeight));

        int startVertex = 0;
        inMst[startVertex] = true;

        priorityQueue.addAll(vertices[startVertex]);

        while(!priorityQueue.isEmpty())
        {
            GraphEdge edge = priorityQueue.poll();

            if(inMst[edge.getDestination()])
            {
                continue;
            }

            // Add the edge to the MST
            mstEdges.add(edge);
            inMst[edge.getDestination()] = true;

            priorityQueue.addAll(vertices[edge.getDestination()]);
        }
        return mstEdges;
    }



}
