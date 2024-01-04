package com.datastructures.dynamicprogramming;

import java.util.Arrays;

public class LongestCommonSubsequence {

    static int dp[][] = new int[1001][1001];

    public static int longestCommonSubsequenceUsingTopDown(String a, String b, int m , int n)
    {
        for(int i=0;i<=m;i++)
        {
            for(int j=0;j<=n;j++)
            {
                if(i==0)
                {
                    dp[i][j]=0;
                }
                else if(j==0)
                {
                    dp[i][j]=0;
                }
                else if(a.charAt(i-1)==b.charAt(j-1))
                {
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else
                {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[m][n];
    }

    public static int longestCommonSubsequenceUsingMemoization(String a, String b, int m , int n)
    {
        if(m==0 || n==0)
        {
            return 0;
        }

        if(dp[m][n]!=-1)
        {
            return dp[m][n];
        }

        if(a.charAt(m-1) == b.charAt(n-1))
        {
            return dp[m][n] = 1+longestCommonSubsequenceUsingRecurrsion(a,b,m-1,n-1);
        }
        else {
            return dp[m][n] = Math.max(longestCommonSubsequenceUsingRecurrsion(a,b,m,n-1),
                    longestCommonSubsequenceUsingRecurrsion(a,b,m-1,n));
        }

    }

    public static int longestCommonSubsequenceUsingRecurrsion(String a, String b, int m , int n)
    {
        if(m==0 || n==0)
        {
            return 0;
        }

        if(a.charAt(m-1) == b.charAt(n-1))
        {
            return 1+longestCommonSubsequenceUsingRecurrsion(a,b,m-1,n-1);
        }
        else {
            return Math.max(longestCommonSubsequenceUsingRecurrsion(a,b,m,n-1),
                    longestCommonSubsequenceUsingRecurrsion(a,b,m-1,n));
        }

    }

    public static void main(String args[])
    {
        String a = "abcd";
        String b = "abcdef";
        System.out.println(longestCommonSubsequenceUsingTopDown(a, b, a.length(), b.length()));
    }

}
