package com.datastructures.dynamicprogramming.mcm;

import java.util.Arrays;

public class PallindromePartitioning {

    public static int dp[][] = new int[1001][1001];

    public static int solveUsingMemoization(String s, int i, int j)
    {
        int ans = Integer.MAX_VALUE;
        if(i>=j)
        {
            return 0;
        }
        if(isPallindrome(s,i,j))
        {
            return 0;
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        for(int k=i;k<j;k++)
        {
            int left, right;
            if(dp[i][k]!=-1)
            {
                left = dp[i][k];
            }
            else
            {
                left = solveUsingRecurrsion(s, i, k);
            }
            if(dp[k+1][j]!=-1)
            {
                right = dp[k+1][j];
            }
            else
            {
                right = solveUsingRecurrsion(s, k+1, j);
            }
            int temp = 1+ left + right;
            ans = Math.min(temp, ans);
        }
        return dp[i][j] = ans;
    }
    public static int solveUsingRecurrsion(String s, int i, int j)
    {
        int ans = Integer.MAX_VALUE;
        if(i>=j)
        {
            return 0;
        }
        if(isPallindrome(s,i,j))
        {
            return 0;
        }
        for(int k=i;k<j;k++)
        {
            int temp = 1+solveUsingRecurrsion(s, i, k) + solveUsingRecurrsion(s, k+1, j);
            ans = Math.min(temp, ans);
        }
        return ans;
    }

    public static boolean isPallindrome(String s, int i, int j)
    {
        while(i<=j)
        {
            if(s.charAt(i)!=s.charAt(j))
            {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String args[])
    {
        String s = "nitik";
        for(int[] t:dp)
        {
            Arrays.fill(t,-1);
        }
        System.out.println(solveUsingMemoization(s, 0, s.length()-1));
    }

}
