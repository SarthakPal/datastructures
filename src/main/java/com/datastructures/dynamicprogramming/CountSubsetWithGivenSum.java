package com.datastructures.dynamicprogramming;

public class CountSubsetWithGivenSum {

    public static int countSubset(int arr[], int sum)
    {
        int n = arr.length;

        int dp[][] = new int[n+1][sum+1];

        dp[0][0] = 1;

        for(int i = 1; i <= n; i++)
            dp[0][i] = 0;

        for(int i=1;i<=n;i++)
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
                else if(arr[i-1]<=j)
                {
                    dp[i][j] = dp[i-1][j-arr[i-1]] + dp[i-1][j];
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
        int arr[] = {1, 3, 5, 6};
        int sum = 6;

        System.out.println(countSubset(arr, sum));

    }

}
