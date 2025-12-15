package com.datastructures.graphs;

import java.util.*;

// https://www.geeksforgeeks.org/problems/strongly-connected-components-kosarajus-algo/1
public class KosarajuAlgorithmStronglyConnectedComponents {

    public void populateStack(int start, ArrayList<ArrayList<Integer>> adj,
                              Set<Integer> visited, Stack<Integer> stack)
    {
        visited.add(start);

        for(Integer neighbour : adj.get(start))
        {
            if(!visited.contains(neighbour))
            {
                populateStack(neighbour, adj, visited, stack);
            }
        }

        stack.add(start);
    }

    public void dfs(int start, ArrayList<ArrayList<Integer>> adj, Set<Integer> visited)
    {
        visited.add(start);

        for(Integer neighbour : adj.get(start))
        {
            if(!visited.contains(neighbour))
            {
                dfs(neighbour, adj, visited);
            }
        }
    }

    public int kosaraju(ArrayList<ArrayList<Integer>> adj) {
        // code here

        int v = adj.size();

        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();

        for(int i=0;i<v;i++)
        {
            if(!visited.contains(i))
            {
                populateStack(i, adj, visited, stack);
            }
        }

        ArrayList<ArrayList<Integer>> reversedEdges = new ArrayList<>();

        for(int k=0;k<v;k++)
        {
            reversedEdges.add(new ArrayList<>());
        }

        for(int k=0;k<v;k++)
        {
            for(Integer neighbour : adj.get(k))
            {
                reversedEdges.get(neighbour).add(k);
            }
        }

        visited = new HashSet<>();

        int scc = 0;

        while(!stack.isEmpty())
        {
            Integer currentVertex = stack.pop();

            if(!visited.contains(currentVertex))
            {
                dfs(currentVertex, reversedEdges, visited);
                scc++;
            }
        }

        return scc;
    }
}
