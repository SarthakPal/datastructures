package com.datastructures.test;

import java.util.*;

public class Test {

    public static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int startVertex = 0;

        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();
        ArrayList<Integer> result = new ArrayList<>();

        stack.add(startVertex);
        visited.add(startVertex);

        while(!stack.isEmpty())
        {
            Integer currentVertex = stack.pop();
            result.add(currentVertex);

            if(!adj.get(currentVertex).isEmpty())
            {
                for(int i=adj.get(currentVertex).size();i>0;i--)
                {
                    int neighbour = adj.get(currentVertex).get(i-1);
                    if(!visited.contains(neighbour))
                    {
                        stack.add(neighbour);
                        visited.add(neighbour);
                    }
                }
            }
        }

        return result;
    }

    public static void main(String args[])
    {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            adjList.add(new ArrayList<>());
        }

        // Add edges manually as per your data
        adjList.get(0).addAll(Arrays.asList(2, 3, 1));
        adjList.get(1).addAll(Arrays.asList(0));
        adjList.get(2).addAll(Arrays.asList(0, 4));
        adjList.get(3).addAll(Arrays.asList(0));
        adjList.get(4).addAll(Arrays.asList(2));

        ArrayList<Integer> result = dfs(adjList);

        for(int i=0;i<result.size();i++)
        {
            System.out.println(result.get(i)+" ");
        }

    }

}
