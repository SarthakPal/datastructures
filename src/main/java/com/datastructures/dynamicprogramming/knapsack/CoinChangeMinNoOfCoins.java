package com.datastructures.dynamicprogramming.knapsack;

public class CoinChangeMinNoOfCoins {

    public static int noOfWays(int[] coins, int sum)
    {
        int n = coins.length;
        int dp[][] = new int[n+1][sum+1];

        for(int j=0;j<=sum;j++)
        {
            dp[0][j] = Integer.MAX_VALUE - 1;
        }

        for(int i=1;i<=n;i++)
        {
            dp[i][0] = 0;
        }

        /*for(int j=1;j<=sum;j++)
        {
            if(j%coins[1]==0)
            {
                dp[1][j] = j/coins[1];
            }
            else
            {
                dp[1][j] = Integer.MAX_VALUE-1;
            }
        }*/

        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=sum;j++)
            {
                if(coins[i-1]<=j)
                {
                    dp[i][j] = Math.min(1+dp[i][j-coins[i-1]] , dp[i-1][j]);
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
