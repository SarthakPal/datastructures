package com.datastructures.recurrsion;

import java.util.ArrayList;
import java.util.List;
public class PermutationsTwo {

    public void generatePermuations(int nums[], List<List<Integer>> res, List<Integer> curr,
                                    boolean[] flag) {
        if (curr.size() == nums.length && !res.contains(curr)) {
            res.add(new ArrayList<>(curr));
        }
        for (int i = 0; i < nums.length; i++) {
            if (flag[i] == true) {
                continue;
            }
            flag[i] = true;
            curr.add(nums[i]);
            generatePermuations(nums, res, curr, flag);
            flag[i] = false;
            curr.remove(curr.size() - 1);
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        boolean flag[] = new boolean[n];
        generatePermuations(nums, res, curr, flag);
        return res;
    }


}
