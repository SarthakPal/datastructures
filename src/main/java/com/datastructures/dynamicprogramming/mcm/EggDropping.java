package com.datastructures.dynamicprogramming.mcm;

import java.util.Arrays;

public class EggDropping {

    static int[][] dp = new int[1001][1001];

    public static int solve(int e, int f)
    {
        if(e==1)
        {
            return f;
        }

        if(f==0 || f==1)
        {
            return f;
        }
        int ans = Integer.MAX_VALUE;
        for(int k=1;k<f;k++)
        {
            int attempts = 1 + Math.max(solve(e-1, k-1), solve(e,f-k));
            ans = Math.min(attempts, ans);
        }
        return ans;
    }

    public static int solveUsingMemoization(int e, int f)
    {
        if(e==1)
        {
            return f;
        }

        if(f==0 || f==1)
        {
            return f;
        }

        if(dp[e][f]!=-1)
        {
            return dp[e][f];
        }

        int ans = Integer.MAX_VALUE;
        for(int k=1;k<f;k++)
        {
            int low = 0, high = 0;

            if(dp[e-1][k-1]!=-1)
            {
                low = dp[e-1][k-1];
            }
            else if(dp[e-1][k-1]==-1)
            {
                low = solveUsingMemoization(e-1, k-1);
                dp[e-1][k-1] = low;
            }

            if(dp[e][f-k]!=-1)
            {
                high = dp[e][f-k];
            }
            else if(dp[e][f-k]==-1)
            {
                high = solveUsingMemoization(e, f-k);
                dp[e][f-k] = high;
            }

            int attempts = 1 + Math.max(low, high);
            ans = Math.min(attempts, ans);
        }
        return dp[e][f] = ans;
    }

    public static void main(String args[])
    {
        for(int[] t:dp)
        {
            Arrays.fill(t, -1);
        }
        System.out.println(solveUsingMemoization(2, 6));
    }

}
