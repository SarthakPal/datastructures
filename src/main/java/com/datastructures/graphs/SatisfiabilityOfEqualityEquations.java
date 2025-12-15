package com.datastructures.graphs;

// https://leetcode.com/problems/satisfiability-of-equality-equations/
public class SatisfiabilityOfEqualityEquations {

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

            int parent_x = parent[x];
            int parent_y = parent[y];

            if(parent_x == parent_y)
            {
                return;
            }

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

        public boolean equationsPossible(String[] equations) {

            int[] parent = new int[26];
            int[] rank = new int[26];

            for(int i=0;i<26;i++)
            {
                parent[i] = i;
                rank[i] = 0;
            }

            for(String str : equations)
            {
                if(str.charAt(1) == '=')
                {
                    union(str.charAt(0)-'a', str.charAt(3)-'a', parent, rank);
                }
            }

            for(String str : equations)
            {
                if(str.charAt(1) == '!')
                {
                    int parent_first = find(str.charAt(0) - 'a', parent);
                    int parent_second = find(str.charAt(3) - 'a', parent);

                    if(parent_first == parent_second)
                    {
                        return false;
                    }
                }
            }

            return true;
        }
}
