package com.datastructures.graphs;

import java.util.*;

// https://leetcode.com/problems/valid-arrangement-of-pairs/
public class HierholzersAlgorithm {

    Map<Integer, List<Integer>> adjList = new HashMap<>();

    Map<Integer, Integer> indegree = new HashMap<>();
    Map<Integer, Integer> outdegree = new HashMap<>();

    public int[][] validArrangement(int[][] pairs) {

        for(int[] edge : pairs)
        {
            int source = edge[0];
            int destination = edge[1];

            adjList.computeIfAbsent(source, k->new ArrayList<>()).add(destination);

            outdegree.put(source, outdegree.getOrDefault(source, 0)+1);
            indegree.put(destination, indegree.getOrDefault(destination, 0)+1);
        }

        int startNode = pairs[0][0];

        for(int node : adjList.keySet())
        {
            if(outdegree.getOrDefault(node,0) - indegree.getOrDefault(node,0) == 1)
            {
                startNode = node;
                break;
            }
        }

        List<Integer> eulerPath = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        stack.push(startNode);

        while(!stack.isEmpty())
        {
            int currNode = stack.peek();

            if(adjList.containsKey(currNode) && !adjList.get(currNode).isEmpty())
            {
                int neighbour = adjList.get(currNode).remove(adjList.get(currNode).size()-1);
                stack.push(neighbour);
            }
            else
            {
                eulerPath.add(currNode);
                stack.pop();
            }

        }

        // using recursion
        // dfs(startNode, eulerPath);

        Collections.reverse(eulerPath);

        int[][] result = new int[eulerPath.size()-1][2];

        for(int i=0;i<eulerPath.size()-1;i++)
        {
            result[i][0] = eulerPath.get(i);
            result[i][1] = eulerPath.get(i+1);
        }

        return result;
    }

    public void dfs(int currNode, List<Integer> eulerPath)
    {
        while(adjList.containsKey(currNode) && !adjList.get(currNode).isEmpty())
        {
            int neighbour = adjList.get(currNode).remove(adjList.get(currNode).size()-1);
            dfs(neighbour, eulerPath);
        }
        eulerPath.add(currNode);
    }

}
