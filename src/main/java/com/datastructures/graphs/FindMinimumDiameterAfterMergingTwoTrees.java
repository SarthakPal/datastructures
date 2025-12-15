package com.datastructures.graphs;

import java.util.*;

// https://leetcode.com/problems/find-minimum-diameter-after-merging-two-trees/
public class FindMinimumDiameterAfterMergingTwoTrees {

    public Map<Integer, List<Integer>> buildAdjList(int[][] edges)
    {
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for(int[] edge : edges)
        {
            int source = edge[0];
            int destination = edge[1];

            adjList.putIfAbsent(source, new ArrayList<>());
            adjList.putIfAbsent(destination, new ArrayList<>());

            adjList.get(source).add(destination);
            adjList.get(destination).add(source);
        }

        return adjList;
    }

    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {

        Map<Integer, List<Integer>> adjList1 = buildAdjList(edges1);
        Map<Integer, List<Integer>> adjList2 = buildAdjList(edges2);

        int d1, d2;

        if(edges1.length==0)
        {
            d1=0;
        }
        else
        {
            d1 = findDiameter(adjList1);
        }

        if(edges2.length==0)
        {
            d2=0;
        }
        else
        {
            d2 = findDiameter(adjList2);
        }

        int combined = (d1+1)/2 + (d2+1)/2 + 1;

        return Math.max(Math.max(d1, d2), combined);
    }

    public int findDiameter(Map<Integer, List<Integer>> adjList)
    {
        int[] farthestNode = findFarthestNode(adjList, 0);

        farthestNode = findFarthestNode(adjList, farthestNode[0]);

        return farthestNode[1];

    }

    public int[] findFarthestNode(Map<Integer, List<Integer>> adjList, int sourceNode)
    {

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(sourceNode);
        visited.add(sourceNode);

        int farthestNode = sourceNode;
        int level = 0;

        while(!queue.isEmpty())
        {
            int size = queue.size();

            for(int i=0;i<size;i++)
            {
                int currentNode = queue.poll();
                farthestNode = currentNode;

                for(Integer neighbour : adjList.get(currentNode))
                {
                    if(!visited.contains(neighbour))
                    {
                        queue.add(neighbour);
                        visited.add(neighbour);
                    }
                }
            }

            if(!queue.isEmpty())
            {
                level++;
            }

        }

        return new int[] {farthestNode, level};


    }

}
