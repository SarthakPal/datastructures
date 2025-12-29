package com.datastructures.test;

import java.util.*;

public class Test {

    public static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // code here

        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();

        int start = 0;

        stack.push(start);
        //visited.add(start);

        ArrayList<Integer> result = new ArrayList<>();

        while(!stack.isEmpty())
        {
            Integer curr = stack.pop();

            if(visited.contains(curr)) continue;

            result.add(curr);
            visited.add(curr);

            List<Integer> neighbours = adj.get(curr);

            for(int i=neighbours.size()-1;i>=0;i--)
            {
                Integer neighbour = neighbours.get(i);
                if(!visited.contains(neighbour))
                {
                    stack.push(neighbour);
                    //visited.add(neighbour);
                }
            }
        }

        return result;

    }

    public static void main(String args[])
    {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            adjList.add(new ArrayList<>());
        }

        // Add edges manually as per your data
        adjList.get(0).addAll(Arrays.asList(1, 2, 4, 8));
        adjList.get(1).addAll(Arrays.asList(0, 5, 6, 9));
        adjList.get(2).addAll(Arrays.asList(0, 4));
        adjList.get(3).addAll(Arrays.asList(7, 8));
        adjList.get(4).addAll(Arrays.asList(0, 2));
        adjList.get(5).addAll(Arrays.asList(1, 8));
        adjList.get(6).addAll(Arrays.asList(1, 7, 9));
        adjList.get(7).addAll(Arrays.asList(3, 6));
        adjList.get(8).addAll(Arrays.asList(0, 3, 5));
        adjList.get(9).addAll(Arrays.asList(1, 6));

        ArrayList<Integer> result = dfs(adjList);

        for(int i=0;i<result.size();i++)
        {
            System.out.println(result.get(i)+" ");
        }

    }

}
