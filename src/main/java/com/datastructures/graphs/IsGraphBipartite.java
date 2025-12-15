package com.datastructures.graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class IsGraphBipartite {

        public boolean isBipartiteUsingBFSUtil(int[][] graph, int[] vertexColors, int currentColor, int start)
        {

            Queue<Integer> queue = new LinkedList<>();
            queue.add(start);
            vertexColors[start] = currentColor;

            while(!queue.isEmpty())
            {
                int currentVertex = queue.poll();

                for(Integer neighbour : graph[currentVertex])
                {
                    if(vertexColors[currentVertex] == vertexColors[neighbour])
                    {
                        return false;
                    }

                    if(vertexColors[neighbour] == -1)
                    {
                        vertexColors[neighbour] = 1 - vertexColors[currentVertex];
                        queue.add(neighbour);
                    }

                }

            }

            return true;
        }

        public boolean isBipartiteUsingBFS(int[][] graph)
        {
            int vertices = graph.length;

            int[] vertexColors = new int[vertices];
            Arrays.fill(vertexColors, -1);

            return isBipartiteUsingBFSUtil(graph, vertexColors, 1, 0);
        }

         public boolean isBipartiteUsingDFSUtil(int currentVertex, int currentColor, int[][] graph, int[] vertexColors)
         {
             vertexColors[currentVertex] = currentColor;

             for(Integer neighbour : graph[currentVertex])
             {
                 if(vertexColors[currentVertex] == vertexColors[neighbour])
                 {
                     return false;
                 }

                 if(vertexColors[neighbour] == -1)
                 {
                     if(!isBipartiteUsingDFSUtil(neighbour, 1 - currentColor, graph, vertexColors))
                     {
                         return false;
                     }
                 }

             }

             return true;

         }

         public boolean isBipartiteUsingDFS(int[][] graph) {

             int vertices = graph.length;

             int[] vertexColors = new int[vertices];
             Arrays.fill(vertexColors, -1);

             for(int i=0;i<vertices;i++)
             {
                 if(vertexColors[i]==-1)
                 {
                     if(!isBipartiteUsingDFSUtil(i, 1, graph, vertexColors))
                     {
                         return false;
                     }
                 }
             }

             return true;
         }

}


