package com.datastructures.recurrsion;

import java.util.*;
public class CombinationsSumThree {

    public static void generateCombinations(int start, int end, int k, int target,
                                     List<List<Integer>> res, List<Integer> curr) {
        if (target == 0 && curr.size() == k) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i = start; i <= end; i++) {
            curr.add(i);
            generateCombinations(i + 1, end, k, target - i, res, curr);
            curr.remove(curr.size() - 1);
        }
    }

    public static List<List<Integer>> combinationSum3   (int k, int n) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        generateCombinations(1, 9, k, n, res, curr);
        return res;

    }

    public static void main(String args[])
    {
        combinationSum3(1, 2);
    }


}
