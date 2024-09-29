package com.datastructures.dynamicprogramming.knapsack;

public class SubsetSum {

    public static boolean subsetSumBottomUp(int[] set, int sum, int n)
    {
        boolean dp[][] = new boolean[n+1][sum+1];

        dp[0][0] = true;

        for (int i = 0; i <= n; i++)
            dp[i][0] = true;

        for(int j=1;j<=sum;j++)
        {
            dp[0][j] = false;
        }

        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=sum;j++)
            {
                if(set[i-1]<=j)
                {
                    dp[i][j] =  dp[i-1][j-set[i-1]] || dp[i-1][j];
                }
                else {
                    dp[i][j] =  dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }

    public static boolean subsetSumRecurssion(int[] set, int sum, int n)
    {
        if(sum==0)
        {
            return true;
        }
        if(n==0)
        {
            return false;
        }
        if(set[n-1]<=sum)
        {
            return subsetSumRecurssion(set, sum-set[n-1], n-1) || subsetSumRecurssion(set, sum, n-1);
        }
        else
        {
            return subsetSumRecurssion(set, sum, n-1);
        }
    }

    public static boolean subsetSumRecurssionMemoization(int [] set, int sum, int n)
    {
        Boolean[][] dp = new Boolean[n+1][sum+1];

        if(sum==0)
        {
            return true;
        }

        if(n==0)
        {
            return false;
        }

        if(dp[n][sum]!=null)
        {
            return dp[n][sum];
        }

        if(set[n-1]<=sum)
        {
            dp[n][sum] = subsetSumRecurssionMemoization(set, sum-set[n-1], n-1) || subsetSumRecurssionMemoization(set, sum, n-1);
        }

        else
        {
            dp[n][sum] = subsetSumRecurssionMemoization(set, sum, n-1);
        }

        return dp[n][sum];

    }


    public static void main(String args[])
    {
        int set[] = { 1, 5, 3 , 4 };
        int sum = 9;
        int n = set.length;
        System.out.println(subsetSumBottomUp(set, sum, n));

    }

}
