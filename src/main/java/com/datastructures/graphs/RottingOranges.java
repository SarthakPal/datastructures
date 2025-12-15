package com.datastructures.graphs;

import java.util.*;

// https://leetcode.com/problems/rotting-oranges/
public class RottingOranges {

    public int orangesRotting(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        int freshCount = 0;

        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                if(grid[i][j]==2)
                {
                    queue.add(new int[]{i,j});
                }
                else if(grid[i][j]==1)
                {
                    freshCount++;
                }
            }
        }

        if(freshCount==0)
        {
            return 0;
        }

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int time = 0;

        while(!queue.isEmpty())
        {
            int size = queue.size();

            for(int i=0;i<size;i++)
            {
                int[] current = queue.poll();

                int currX = current[0];
                int currY = current[1];

                for(int[] dir : directions)
                {
                    int newX = currX + dir[0];
                    int newY = currY + dir[1];

                    if(isSafe(newX, newY, rows, cols) && grid[newX][newY]==1)
                    {
                        grid[newX][newY]=2;
                        queue.add(new int[]{newX, newY});
                        freshCount--;
                    }
                }

            }

            if(!queue.isEmpty())
            {
                time++;
            }
        }

        return freshCount==0 ? time : -1;

    }

    public boolean isSafe(int x, int y, int rows, int cols)
    {
        return x>=0 && x<rows && y>=0 && y<cols;
    }

}
