package com.datastructures.dynamicprogramming.knapsack;

public class CoinChangeMaxNoOfWays {

    public static int noOfWays(int[] coins, int sum)
    {
        int n = coins.length;
        int dp[][] = new int[n+1][sum+1];

        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=sum;j++)
            {
                if(i==0)
                {
                    dp[i][j] = 0;
                }
                else if(j==0)
                {
                    dp[i][j] = 1;
                }
                else if(coins[i-1]<=j)
                {
                    dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j];
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }

    public static void main(String args[])
    {
        int coins[] = {1, 2, 3};
        int sum = 5;
        System.out.println(noOfWays(coins, sum));
    }


}
