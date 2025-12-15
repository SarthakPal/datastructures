package com.datastructures.graphs;

//  https://leetcode.com/problems/number-of-operations-to-make-network-connected/description/

public class NumberOfOperationsToMakeNetworkConnected {

        public int find(int x, int[] parent)
        {
            int parent_x = parent[x];

            if(x==parent_x)
            {
                return x;
            }

            return parent[x] = find(parent[x], parent);
        }

        public void union(int x, int y, int[] parent, int[] rank)
        {
            int parent_x = find(x, parent);
            int parent_y = find(y, parent);

            if(parent_x == parent_y) return;

            if(rank[parent_x] > rank[parent_y])
            {
                parent[parent_y] = parent_x;
            }

            else if(rank[parent_y] > rank[parent_x])
            {
                parent[parent_x] = parent_y;
            }

            else
            {
                parent[parent_x] = parent_y;
                rank[parent_y]++;
            }

        }

        public int makeConnected(int n, int[][] connections) {

            if (connections.length < n - 1) {
                return -1;
            }

            int[] parent = new int[n];
            int[] rank = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }

            int components = n;

            for (int[] edge : connections) {
                int source = edge[0];
                int destination = edge[1];

                int parent_source = find(source, parent);
                int parent_destination = find(destination, parent);

                if (parent_source == parent_destination) {
                    continue;
                } else {
                    union(source, destination, parent, rank);
                    components--;
                }
            }

            return components - 1;
        }

}
