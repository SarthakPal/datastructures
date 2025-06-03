package com.datastructures.graphs;

import java.util.*;

/**
 * first we will take a set named as visited and a queue to keep track of the vertices.
 * We will start from the given vertex and mark it as visited.
 * Then we will push all its unvisited neighbors onto the queue.
 * We will continue this process until the queue is empty.
 */
public class BreadthFirstSearch {

    public void bfsIterative(Map<Integer, List<Integer>> adjacencyList, int start)
    {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited.add(start);

        while(!queue.isEmpty())
        {
            Integer currentVertex = queue.poll();
            System.out.print(currentVertex + " ");

            List<Integer> neighbors = adjacencyList.getOrDefault(currentVertex, Collections.emptyList());
            for(int neighbor : neighbors)
            {
                if(!visited.contains(neighbor))
                {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }

    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(1, 2));
        graph.put(1, Arrays.asList(0, 2, 3));
        graph.put(2, Arrays.asList(0, 1, 4));
        graph.put(3, Arrays.asList(1, 4));
        graph.put(4, Arrays.asList(2, 3));

        BreadthFirstSearch bfs = new BreadthFirstSearch();
        bfs.bfsIterative(graph, 0); // Starting BFS from node 0
    }

}
