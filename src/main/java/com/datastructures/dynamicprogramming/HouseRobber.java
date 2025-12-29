package com.datastructures.dynamicprogramming;

import java.util.Arrays;

// https://leetcode.com/problems/house-robber/
public class HouseRobber {

    public int solve(int[] nums, int i)
    {
        if(i>=nums.length) return 0;

        int steal = nums[i] + solve(nums, i+2);
        int skip = solve(nums, i+1);

        return Math.max(steal, skip);
    }

    public int rob(int[] nums) {
        return solve(nums, 0);
    }

    public int solveUsingTopDown(int[] nums, int i, int[] dp)
    {
        if(i>=nums.length) return 0;

        if(dp[i]!=-1) return dp[i];

        int steal = nums[i] + solveUsingTopDown(nums, i+2, dp);
        int skip = solveUsingTopDown(nums, i+1, dp);

        return dp[i] = Math.max(steal, skip);
    }

    public int robUsingTopDown(int[] nums) {

        int size = nums.length;

        int[] dp = new int[size];
        Arrays.fill(dp, -1);

        return solveUsingTopDown(nums, 0, dp);

    }

    public int robUsingBottomUp(int[] nums) {

        int n = nums.length;

        if(n==1) return n;

        int[] dp = new int[n+1];

        dp[0] = 0;
        dp[1] = nums[0];

        for(int i=2;i<n+1;i++)
        {
            int steal = nums[i-1] + dp[i-2];
            int skip = dp[i-1];
            dp[i] = Math.max(steal, skip);
        }

        return dp[n];

    }

    public int robUsingConstantSpace(int[] nums) {

        int n = nums.length;

        if(n==1) return nums[0];

        int prev_prev = 0;
        int prev = nums[0];

        for(int i=2;i<=n;i++)
        {
            int steal = nums[i-1] + prev_prev;
            int skip = prev;
            int temp = Math.max(steal, skip);
            prev_prev = prev;
            prev = temp;
        }

        return prev;
    }

}
