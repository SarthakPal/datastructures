package com.datastructures.dynamicprogramming;

import java.util.Arrays;

// https://leetcode.com/problems/maximum-alternating-subsequence-sum/

public class MaximumAlternatingSubsequenceSum {

    long[][] dp;

    public long solve(int index, int[] nums, boolean isEven)
    {
        if(index>=nums.length) return 0;

        int evenIndex = isEven ? 1 : 0;

        if (dp[index][evenIndex] != -1) {
            return dp[index][evenIndex];
        }

        long skip = solve(index+1, nums, isEven);

        long val = nums[index];

        if(!isEven)
        {
            val = -val;
        }

        long take = solve(index+1, nums, !isEven) + val;

        return dp[index][evenIndex] = Math.max(skip, take);
    }

    public long maxAlternatingSum(int[] nums) {

        int n = nums.length;

        dp = new long[n][2];

        for(int i=0;i<n;i++)
        {
            Arrays.fill(dp[i], -1);
        }

        return solve(0, nums, true);
    }

    public long maxAlternatingSumUsingTopDown(int[] nums) {

        int n = nums.length;

        int temp[][] = new int[n+1][2];

        for(int i=1;i<n+1;i++)
        {
            temp[i][0] = Math.max(temp[i-1][1] - nums[i-1], temp[i-1][0]);
            temp[i][1] = Math.max(temp[i-1][0] + nums[i-1], temp[i-1][1]);
        }

        return Math.max(temp[n][0], temp[n][1]);

    }

}
