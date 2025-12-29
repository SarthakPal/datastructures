package com.datastructures.dynamicprogramming;

import java.util.Arrays;

// https://leetcode.com/problems/house-robber-ii/
public class HouseRobber2 {

    public int solve(int[] nums, int i, int n, int[] dp)
    {
        if(i>n) return 0;

        if(dp[i]!=-1) return dp[i];

        int steal = nums[i]+solve(nums, i+2, n, dp);
        int skip = solve(nums, i+1, n, dp);

        return dp[i]=Math.max(steal, skip);
    }

    public int robUsingTopDown(int[] nums) {

        int n = nums.length;

        if(n==1) return nums[0];

        if(n==2) return Math.max(nums[0], nums[1]);

        int[] dp = new int[n+1];

        Arrays.fill(dp, -1);
        int rob_from_zero = solve(nums, 0, n-2, dp);

        Arrays.fill(dp, -1);
        int rob_from_one = solve(nums, 1, n-1, dp);

        return Math.max(rob_from_zero, rob_from_one);

    }

    public int robUsingBottomUp(int[] nums) {

        int n = nums.length;

        if(n==1) return nums[0];

        int[] dp = new int[n+1];

        dp[0] = 0;

        for(int i=1;i<=n-1;i++)
        {
            int steal = nums[i-1] + (i-2>=0 ? dp[i-2] : 0);
            int skip = dp[i-1];
            dp[i] = Math.max(steal, skip);
        }

        int result1 = dp[n-1];

        Arrays.fill(dp, 0);

        dp[0] = 0;
        dp[1] = 0;

        for(int i=2;i<=n;i++)
        {
            int steal = nums[i-1] + (i-2>=0 ? dp[i-2] : 0);
            int skip = dp[i-1];
            dp[i] = Math.max(steal, skip);
        }

        int result2 = dp[n];

        return Math.max(result1, result2);

    }

    public int solveUsingConstantSpace(int nums[], int left, int right)
    {
        int prev_prev = 0;
        int prev = 0;

        for(int i=left;i<=right;i++)
        {
            int steal = nums[i] + prev_prev;
            int skip = prev;
            int temp = Math.max(steal, skip);
            prev_prev = prev;
            prev = temp;
        }

        return prev;
    }

    public int robUsingConstantSpace(int[] nums) {

        int n = nums.length;

        if(n==1) return nums[0];

        if(n==2) return Math.max(nums[0], nums[1]);

        int rob_from_0th = solveUsingConstantSpace(nums, 0, n-2);
        int rob_from_1st = solveUsingConstantSpace(nums, 1, n-1);

        return Math.max(rob_from_0th, rob_from_1st);
    }

}
