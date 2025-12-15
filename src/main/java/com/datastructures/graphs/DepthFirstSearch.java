package com.datastructures.graphs;

import java.util.*;

public class DepthFirstSearch {

    /**
     * first we will take a set named as visited and a stack to keep track of the vertices.
     * We will start from the given vertex and mark it as visited.
     * Then we will push all its unvisited neighbors onto the stack.
     * We will continue this process until the stack is empty.
     */

    Map<Integer, List<Integer>> adjacencyList = new HashMap<>();

    public void dfsIterative(Map<Integer, List<Integer>> adjacencyList, int start)
    {
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        stack.add(start);

        while(!stack.isEmpty())
        {
            Integer currentVertex = stack.pop();
            visited.add(start);
            System.out.print(currentVertex + " ");

            List<Integer> neighbors = adjacencyList.getOrDefault(currentVertex, Collections.emptyList());
            for(int neighbor : neighbors)
            {
                if(!visited.contains(neighbor))
                {
                    stack.add(neighbor);
                }
            }
        }

    }

    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // Code here

        int startVertex = 0;
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[adj.size()];
        ArrayList<Integer> result = new ArrayList<>();

        stack.push(startVertex);

        while (!stack.isEmpty()) {
            int current = stack.pop();

            // If already visited (popped duplicate), skip
            if (visited[current]) continue;

            // Now mark visited and record the node
            visited[current] = true;
            result.add(current);

            // Push neighbors in reverse order so that the traversal
            // follows the adjacency list order when popped.
            List<Integer> neighbors = adj.get(current);
            for (int i = neighbors.size() - 1; i >= 0; i--) {
                int neigh = neighbors.get(i);
                if (!visited[neigh]) {
                    stack.push(neigh);
                }
            }
        }

        return result;
    }

    public void dfs(int startVertex)
    {
        Set<Integer> visited = new HashSet<>();
        dfsRecursive(startVertex, visited);
    }

    public void dfsRecursive(int vertex, Set<Integer> visited)
    {
        visited.add(vertex);
        System.out.println(vertex+ " ");

        List<Integer> neighbors = adjacencyList.getOrDefault(vertex, Collections.emptyList());

        for(int neighbour : neighbors)
        {
            if(!visited.contains(neighbour))
            {
                dfsRecursive(neighbour, visited);
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

        DepthFirstSearch dfs = new DepthFirstSearch();
        dfs.dfsIterative(graph, 0); // Starting BFS from node 0
    }

}
