package com.datastructures.recurrsion;

import java.util.*;
public class SubsetsTwo {

        public void generateSubsets(int idx, int nums[], List<List<Integer>> res, List<Integer> curr)
        {
            res.add(new ArrayList<>(curr));

            for(int i=idx;i<nums.length;i++)
            {
                if(i>idx && nums[i-1]==nums[i])
                {
                    continue;
                }
                curr.add(nums[i]);
                generateSubsets(i+1, nums, res, curr);
                curr.remove(curr.size()-1);
            }

        }

        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> curr = new ArrayList<>();
            generateSubsets(0, nums, res, curr);
            return res;
        }


}
