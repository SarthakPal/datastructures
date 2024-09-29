package com.datastructures.dynamicprogramming.knapsack;

public class ZeroOneKanpsack {

    public static int knapSackUsingBottomUp(int W, int[] weight, int[] profit, int n, int[][] dp)
    {
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=W;j++)
            {
                if(i==0 || j==0)
                {
                    dp[i][j] = 0;
                }

                else if(weight[i-1]<=j)
                {
                    dp[i][j] = Math.max((profit[i-1]+dp[i-1][j-weight[i-1]]), dp[i-1][j]);
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][W];
    }

    public static int knapSackUsingMemoization(int W, int[] weight, int[] profit, int n, int[][] dp)
    {
        if(n==0 || W==0)
        {
            return 0;
        }

        if(dp[n][W]!=-1)
        {
            return dp[n][W];
        }

        if(weight[n-1]<=W)
        {
            return dp[n][W] = Math.max(profit[n-1]+knapSackUsingMemoization(W-weight[n-1], weight, profit, n-1, dp),
                    knapSackUsingMemoization(W, weight, profit, n-1, dp));
        }
        else {
            return dp[n][W] = knapSackUsingMemoization(W, weight, profit, n-1, dp);
        }
    }

    public static int knapSackUsingRecurrsion(int W, int[] weight, int[] profit, int n)
    {
        if(n==0 || W==0)
        {
            return 0;
        }
        if(weight[n-1]<=W)
        {
            return Math.max(profit[n-1]+knapSackUsingRecurrsion(W-weight[n-1], weight, profit, n-1),
                    knapSackUsingRecurrsion(W, weight, profit, n-1));
        }
        else {
            return knapSackUsingRecurrsion(W, weight, profit, n-1);
        }
    }

    public static void main(String[] args)
    {
        int[] profit = new int[] { 11, 12, 13, 14};
        int[] weight = new int[] { 1, 2, 3, 4};
        int W = 6;
        int n = profit.length;
        int[][] dp = new int[n+1][W+1];
        for(int i=0;i<n+1;i++)
        {
            for(int j=0;j<W+1;j++)
            {
                dp[i][j] = -1;
            }
        }
        System.out.println(knapSackUsingBottomUp(W, weight, profit, n, dp));
    }

}
