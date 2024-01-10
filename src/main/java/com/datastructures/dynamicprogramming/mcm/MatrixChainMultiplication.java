package com.datastructures.dynamicprogramming.mcm;

import java.util.Arrays;

public class MatrixChainMultiplication {

    public static int dp[][] = new int[1001][1001];

    public static int solveUsingMemoization(int arr[], int i, int j)
    {
        int ans = Integer.MAX_VALUE;
        if(i>=j)
        {
            return 0;
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        for(int k=i;k<j;k++)
        {
            int temp = solveUsingMemoization(arr, i, k) + solveUsingMemoization(arr, k+1, j)
                    + (arr[i-1]*arr[k]*arr[j]);
            ans = Math.min(temp, ans);
        }
        return dp[i][j] = ans;
    }
    public static int solveUsingRecurrsion(int arr[], int i, int j)
    {
        int ans = Integer.MAX_VALUE;
        if(i>=j)
        {
            return 0;
        }
        for(int k=i;k<j;k++)
        {
            int temp = solveUsingRecurrsion(arr, i, k) + solveUsingRecurrsion(arr, k+1, j)
                                    + (arr[i-1]*arr[k]*arr[j]);
            ans = Math.min(temp, ans);
        }
        return ans;
    }

    public static void main(String args[])
    {
        int arr[] = {40, 20, 30, 10, 30};
        for(int[] t:dp)
        {
            Arrays.fill(t,-1);
        }
        System.out.println(solveUsingMemoization(arr, 1, arr.length-1));
    }

}
