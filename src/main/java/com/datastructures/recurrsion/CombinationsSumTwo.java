package com.datastructures.recurrsion;

import java.util.*;

public class CombinationsSumTwo {

    public void generateCombinations(int idx, int nums[], int target,
                                     List<List<Integer>> res, List<Integer> curr) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            if (nums[i] > target || (i > idx && nums[i - 1] == nums[i])) {
                continue;
            }
            curr.add(nums[i]);
            generateCombinations(i + 1, nums, target - nums[i], res, curr);
            curr.remove(curr.size() - 1);
        }

    }

    public List<List<Integer>> combinationSum2(int[] nums, int target) {

        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        generateCombinations(0, nums, target, res, curr);
        return res;

    }


}
