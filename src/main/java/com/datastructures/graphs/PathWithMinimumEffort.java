package com.datastructures.graphs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// https://leetcode.com/problems/path-with-minimum-effort/description/
public class PathWithMinimumEffort {

    class Node
    {
        int diff;
        int x;
        int y;

        Node(int diff, int x, int y)
        {
            this.diff = diff;
            this.x = x;
            this.y = y;
        }

    }

    int[][] directions = {
            {-1,0}, {1,0}, {0,1}, {0,-1}
    };

    public int minimumEffortPath(int[][] heights) {

        int rows = heights.length;
        int cols = heights[0].length;

        int result[][] = new int[rows][cols];

        for(int i=0;i<rows;i++)
        {
            Arrays.fill(result[i], Integer.MAX_VALUE);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.diff));

        pq.add(new Node(0,0,0));
        result[0][0] = 0;

        while(!pq.isEmpty())
        {
            Node currNode = pq.poll();

            int currDiff = currNode.diff;
            int x = currNode.x;
            int y = currNode.y;

            if(x==rows-1 && y==cols-1)
            {
                return currDiff;
            }

            for(int[] dir : directions)
            {
                int newX = x+dir[0];
                int newY = y+dir[1];

                if(isSafe(newX, newY, rows, cols))
                {
                    int newDiff = Math.max(currDiff,
                            Math.abs(heights[x][y] - heights[newX][newY]));
                    if(newDiff<result[newX][newY])
                    {
                        result[newX][newY] = newDiff;
                        pq.add(new Node(newDiff, newX, newY));
                    }
                }

            }

        }

        return result[rows-1][cols-1];

    }

    public boolean isSafe(int newX, int newY, int rows, int cols)
    {
        return newX>=0 && newX<rows && newY>=0 && newY<cols;
    }

}
