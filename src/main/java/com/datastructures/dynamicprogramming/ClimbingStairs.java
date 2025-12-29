package com.datastructures.dynamicprogramming;

import java.util.Arrays;

// https://leetcode.com/problems/climbing-stairs/
public class ClimbingStairs {

    public int climbStairs(int n) {

        if(n<0) return 0;

        if(n==0) return 1; // we have got one way

        int one_step = climbStairs(n-1);
        int two_step = climbStairs(n-2);

        return one_step + two_step;
    }

    public int solve(int n, int[] dp)
    {
        if(n<0) return 0;

        if(dp[n]!=-1) return dp[n];

        if(n==0) return 1; // we have got one way

        int one_step = solve(n-1, dp);
        int two_step = solve(n-2, dp);

        return dp[n] = one_step + two_step;
    }

    public int climbStairsUsingMemoization(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return solve(n, dp);
    }

    public int climbStairsUsingBottomUp(int n) {

        if(n==1 || n==2) return n;

        int[] dp = new int[n+1];
        Arrays.fill(dp, n-1);

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for(int i=3;i<n+1;i++)
        {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];

    }

}
