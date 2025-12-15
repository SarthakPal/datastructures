package com.datastructures.graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class EulerPathAndCircuit {

    public void DFS(int startVertex, ArrayList<ArrayList<Integer>> adj, Set<Integer> visited)
    {
        visited.add(startVertex);

        for(Integer neighbour : adj.get(startVertex))
        {
            if(!visited.contains(neighbour))
            {
                DFS(neighbour, adj, visited);
            }
        }

    }

    public boolean isConnected(int V, ArrayList<ArrayList<Integer>> adj)
    {

        int nonZeroDegreeVertex = -1;
        for(int i=0;i<V;i++)
        {
            if(adj.get(i).size()!=0)
            {
                nonZeroDegreeVertex = i;
                break;
            }
        }

        Set<Integer> visited = new HashSet<>();
        DFS(nonZeroDegreeVertex, adj, visited);

        for(int i=0;i<V;i++)
        {
            if(!visited.contains(i) && adj.get(i).size()!=0)
            {
                return false;
            }
        }

        return true;

    }

    public int isEulerCircuit(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here

        if(!isConnected(V, adj))
        {
            return 0;
        }

        int oddVertexCount = 0;

        for(int i=0;i<V;i++)
        {
            if(adj.get(i).size()%2!=0)
            {
                oddVertexCount++;
            }
        }

        if(oddVertexCount>2)
        {
            return 0;
        }

        if(oddVertexCount==2)
        {
            return 1;
        }

        return 2;

    }
}
