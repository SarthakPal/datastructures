package com.datastructures.graphs;

import java.util.ArrayList;

// https://www.geeksforgeeks.org/problems/detect-cycle-using-dsu/1
public class DetectCycleUsingDSU {

        public int find(int vertex, int[] parent)
        {
            int parent_vertex = parent[vertex];
            if(vertex==parent_vertex)
            {
                return vertex;
            }

            return parent[vertex] = find(parent_vertex, parent);
        }

        public void union(int x, int y, int[] parent, int[] rank)
        {

            int x_parent = find(x, parent);
            int y_parent = find(y, parent);

            if(x_parent==y_parent)
            {
                return;
            }

            if(rank[x_parent] > rank[y_parent])
            {
                parent[y_parent] = x_parent;
            }

            else if(rank[y_parent] > rank[x_parent])
            {
                parent[x_parent] = y_parent;
            }

            else
            {
                parent[x_parent] = y_parent;
                rank[y_parent]+=1;
            }

        }

        public int detectCycle(int V, ArrayList<ArrayList<Integer>> adj) {
            // Code here

            int[] parent = new int[V];
            int[] rank = new int[V];

            for (int i = 0; i < V; i++) {
                parent[i] = i;
                rank[i] = 0;
            }

            for (int source = 0; source < V; source++) {
                for (Integer destination : adj.get(source)) {
                    if (source < destination) {
                        int source_parent = find(source, parent);
                        int destination_parent = find(destination, parent);

                        if (source_parent == destination_parent) {
                            return 1;
                        }

                        union(source, destination, parent, rank);

                    }
                }
            }

            return 0;
        }

}
