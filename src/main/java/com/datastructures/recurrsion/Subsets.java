package com.datastructures.recurrsion;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static void generateSubsetsUtil(int idx, int nums[], List<List<Integer>> res, List<Integer> curr)
    {
        res.add(new ArrayList<>(curr));
        for(int i=idx;i<nums.length;i++)
        {
            curr.add(nums[i]);
            generateSubsetsUtil(i+1, nums, res, curr);
            curr.remove(curr.size()-1);
        }
    }

    public static List<List<Integer>> generateSubsets(int nums[])
    {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        generateSubsetsUtil(0, nums, res, curr);
        return res;
    }

    public static void main(String args[])
    {
        int nums[] = {1, 2, 2,3};
        List<List<Integer>> res = generateSubsets(nums);
        for(int i=0;i<res.size();i++)
        {
            List<Integer> temp = res.get(i);
            for(int j=0;j<temp.size();j++)
            {
                System.out.print(temp.get(j));
            }
            System.out.println();
        }
    }

}
