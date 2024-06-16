package com.datastructures.recurrsion;

import java.util.*;

class CombinationSumOne {

    public void combinationSumUtil(int idx, int[] nums, int target,
                                   List<List<Integer>> res, List<Integer> temp)
    {

        if(target==0)
        {
            res.add(new ArrayList<>(temp));
            return;
        }

        if(target<0)
        {
            return;
        }

        for(int i=idx;i<nums.length;i++)
        {
            temp.add(nums[i]);
            combinationSumUtil(i, nums, target-nums[i], res, temp);
            temp.remove(temp.size()-1);
        }

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target)
    {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        combinationSumUtil(0, candidates, target, res, temp);

        return res;

    }
}