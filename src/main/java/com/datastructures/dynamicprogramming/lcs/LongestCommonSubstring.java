package com.datastructures.dynamicprogramming.lcs;

public class LongestCommonSubstring {

    static int dp[][] = new int[1001][1001];

    public static int longestCommonSubstring(String a, String b, int m , int n)
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
                    dp[i][j] = 0;
                }
            }
        }
        return dp[m][n];
    }
    public static void main(String args[])
    {
        String a = "acb";
        String b = "bac";

        int m = a.length();
        int n = b.length();
        int max = Integer.MIN_VALUE;

        longestCommonSubstring(a, b, m, n);

        for(int i=0;i<=m;i++)
        {
            for(int j=0;j<=n;j++)
            {
                if(dp[i][j]>=max)
                {
                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        System.out.println(max);
    }

}
