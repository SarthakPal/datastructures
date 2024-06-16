package com.datastructures.recurrsion;

import java.util.ArrayList;
import java.util.List;

public class SubsetSumsOne {

    // Recursive utility function to generate sums of subsets
    public static void generateSubsetSumsUtil(int idx, int nums[], List<Integer> res, int currentSum) {
        // Add the current sum to the result list
        res.add(currentSum);
        for (int i = idx; i < nums.length; i++) {
            // Include the current element in the sum
            currentSum = currentSum+nums[i];
            generateSubsetSumsUtil(i + 1, nums, res, currentSum);
            currentSum = currentSum-nums[i];
        }
    }

    // Method to generate sums of all subsets of the given array
    public static List<Integer> generateSubsetSums(int nums[]) {
        List<Integer> res = new ArrayList<>();
        // Start the recursive process from index 0 and initial sum 0
        generateSubsetSumsUtil(0, nums, res, 0);
        return res;
    }

    public static void main(String args[]) {
        int nums[] = {4, 5, 6};
        // Generate sums of all subsets of the given array
        List<Integer> res = generateSubsetSums(nums);
        // Print each sum
        for (int sum : res) {
            System.out.println(sum);
        }
    }
}

