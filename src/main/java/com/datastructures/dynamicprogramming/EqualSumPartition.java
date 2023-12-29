package com.datastructures.dynamicprogramming;

public class EqualSumPartition {

    public static boolean subsetSumBottomUp(int[] set, int sum, int n)
    {
        boolean dp[][] = new boolean[n+1][sum+1];

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

    public static boolean equalSum(int arr[], int n)
    {
        int sum = 0;
        for(int i=0;i<n;i++)
        {
            sum = sum+arr[i];
        }

        if(sum%2!=0)
        {
            return false;
        }
        else
        {
            return subsetSumBottomUp(arr, sum/2, n);
        }

    }

    public static void main(String args[])
    {
        int arr[] = {1, 5, 3, 4 };
        int n = arr.length;
        System.out.println(equalSum(arr, n));
    }

}
