package com.datastructures.graphs;

import java.util.ArrayList;
import java.util.List;

public class WeightedGraph {

    private int vertices;

    private List<GraphEdge>[] adjacencyList;

    public WeightedGraph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new java.util.ArrayList<>();
        }
    }

    public void addDirectedEdge(int source, int destination, int weight) {
        adjacencyList[source].add(new GraphEdge(source, destination, weight));
    }

    public void addUndirectedEdge(int source, int destination, int weight) {
        adjacencyList[source].add(new GraphEdge(source, destination, weight));
        adjacencyList[destination].add(new GraphEdge(destination, source, weight));
    }

    public int getVertices() {
        return vertices;
    }

    public List<GraphEdge>[] getAdjacencyList() {
        return adjacencyList;
    }

}
