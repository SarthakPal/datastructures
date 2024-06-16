package com.datastructures.recurrsion;

import java.util.ArrayList;
import java.util.List;

// Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
// You may return the answer in any order.
class Combinations {

    public void generateCombinations(int start, int n, int k, List<List<Integer>> res, List<Integer> curr)
    {
        if(curr.size()==k)
        {
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i=start;i<=n;i++)
        {
            curr.add(i);
            generateCombinations(i+1, n, k, res, curr);
            curr.remove(curr.size()-1);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        generateCombinations(1, n, k, res, curr);
        return res;
    }

}
