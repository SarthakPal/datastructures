package com.datastructures.graphs;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/description/
public class CountUnreachablePairsOfNodesInAnUndirectedGraph {

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

        public long countPairs(int n, int[][] edges) {

            int[] parent = new int[n];
            int[] rank = new int[n];

            for(int i=0;i<n;i++)
            {
                parent[i] = i;
                rank[i] = 0;
            }

            for(int[] edge : edges)
            {
                union(edge[0], edge[1], parent, rank);
            }

            Map<Integer, Integer> map = new HashMap<>();

            for(int i=0;i<n;i++)
            {
                int key = find(i, parent);
                map.put(key, map.getOrDefault(key, 0)+1);
            }

            long remaining = n;

            long result = 0;

            for(Integer value : map.values())
            {
                long currentSComponentSize = value;
                result+= currentSComponentSize * (remaining - currentSComponentSize);
                remaining-= currentSComponentSize;
            }

            return result;

        }

}
