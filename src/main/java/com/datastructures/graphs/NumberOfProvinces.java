package com.datastructures.graphs;

import java.util.*;

// https://leetcode.com/problems/number-of-provinces/

// jab jab parent for loop ki condition true hoti hai tab count increase karo
// matlab jab jab ek naya disconnected node mile count increase hoga
// jisse pata chalega ki kitne disconnected graphs hai

public class NumberOfProvinces {

    public void noOfProvincesUsingBFS(int currentVertex, int[][] isConnected, Set<Integer> visited)
    {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(currentVertex);
        visited.add(currentVertex);

        while(!queue.isEmpty())
        {
            int vertex = queue.poll();

            for(int col=0; col<isConnected.length; col++)
            {
                if(!visited.contains(col) && isConnected[vertex][col]==1)
                {
                    visited.add(col);
                    queue.add(col);
                }
            }
        }
    }

    public void noOfProvincesUsingDFS(int currentVertex, int[][] isConnected, Set<Integer> visited)
    {

        visited.add(currentVertex);

        for(int col=0; col<isConnected.length; col++)
        {
            if(!visited.contains(col) && isConnected[currentVertex][col]==1)
            {
                noOfProvincesUsingDFS(col, isConnected, visited);
            }
        }

    }

    public int findCircleNum(int[][] isConnected) {

        int vertices = isConnected.length;

        Set<Integer> visited = new HashSet<>();

        int count=0;

        for(int i=0;i<vertices;i++)
        {
            if(!visited.contains(i))
            {
                count++;
                noOfProvincesUsingDFS(i, isConnected, visited);
            }
        }

        return count;

    }

}
