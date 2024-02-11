package com.datastructures.dynamicprogramming.knapsack;

public class SubsetSum {

    public static boolean subsetSumBottomUp(int[] set, int sum, int n)
    {
        boolean dp[][] = new boolean[n+1][sum+1];

        dp[0][0] = true;

        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=sum;j++)
            {
                if(i==0)
                {
                    dp[i][j] = false;
                }
                else if(j==0)
                {
                    dp[i][j] = true;
                }

                else if(set[i-1]<=j)
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

    public static void main(String args[])
    {
        int set[] = { 1, 5, 3 , 4 };
        int sum = 9;
        int n = set.length;
        System.out.println(subsetSumBottomUp(set, sum, n));
    }

}
