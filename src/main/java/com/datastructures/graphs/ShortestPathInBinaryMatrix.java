package com.datastructures.graphs;

import java.util.*;

// https://leetcode.com/problems/shortest-path-in-binary-matrix/description/
public class ShortestPathInBinaryMatrix {

    int[][] directions = {
            {1,1}, {0,1}, {1,0}, {0,-1},
            {-1,0}, {-1,-1}, {1,-1}, {-1,1}
    };

    public int shortestPathBinaryMatrixUsingBFS(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        if(rows==0 || cols == 0 || grid[0][0] == 1 || grid[rows - 1][cols - 1] == 1)
        {
            return -1;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});

        grid[0][0] = 1;

        int steps = 1;

        while(!queue.isEmpty())
        {
            int size = queue.size();

            // ek level pe jitne bhi cells hain unko ek sath process karne ke liye
            // queue ki size pe iterate kar rahe hain
            while(size-- > 0)
            {
                int[] currCell = queue.poll();

                int x = currCell[0];
                int y = currCell[1];

                if(x==rows-1 && y==cols-1)
                {
                    return steps;
                }

                for(int[] dir : directions)
                {
                    int newX = x + dir[0];
                    int newY = y + dir[1];

                    if(isSafe(newX, newY, rows, cols) && grid[newX][newY]==0)
                    {
                        queue.add(new int[]{newX,newY});
                        grid[newX][newY]=1;
                    }
                }

            }

            // jaise hi ek level iterate ho jayga count bada denge.
            steps++;

        }

        return -1;
    }

    public boolean isSafe(int x, int y,  int rows, int cols)
    {
        return x>=0 && x<rows && y>=0 && y<cols;
    }

    class Node
    {
        int dist;
        int x;
        int y;

        Node(int dist, int x, int y)
        {
            this.dist = dist;
            this.x = x;
            this.y = y;
        }

    }

    public int shortestPathBinaryMatrix(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        if(rows==0 || cols==0 || grid[0][0]==1 || grid[rows-1][cols-1]==1)
        {
            return -1;
        }

        int result[][] = new int[rows][cols];

        for(int i=0;i<rows;i++)
        {
            Arrays.fill(result[i], Integer.MAX_VALUE);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.dist));

        pq.add(new Node(0,0,0));
        result[0][0] = 0;

        while(!pq.isEmpty())
        {
            Node currNode = pq.poll();

            int dist = currNode.dist;
            int x = currNode.x;
            int y = currNode.y;

            for(int[] dir : directions)
            {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if(isSafe(newX, newY, rows, cols) && grid[newX][newY]==0
                        && 1+dist<result[newX][newY])
                {
                    pq.add(new Node(1+dist, newX, newY));
                    grid[newX][newY] = 1;
                    result[newX][newY] = 1+dist;
                }

            }
        }

        if(result[rows-1][cols-1]==Integer.MAX_VALUE) return -1;

        return result[rows-1][cols-1]+1;
    }
}
