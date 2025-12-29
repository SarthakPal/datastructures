package com.datastructures.dynamicprogramming;

import java.util.Arrays;

public class Fibonacci {

    public int solve(int[] dp, int n)
    {
        if(n<=1) return n;
        if(dp[n]!=-1) return dp[n];
        return dp[n] = solve(dp, n-1) + solve(dp, n-2);
    }

    public int fibUsingTopDown(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return solve(dp, n);
    }

    public int fibUsingBottomUp(int n) {

        if(n<=1) return n;

        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2;i<n+1;i++)
        {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

}
