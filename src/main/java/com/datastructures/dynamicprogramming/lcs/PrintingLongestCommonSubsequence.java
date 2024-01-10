package com.datastructures.dynamicprogramming.lcs;

public class PrintingLongestCommonSubsequence {

    static int dp[][] = new int[1001][1001];

    public static int longestCommonSubsequence(String a, String b, int m , int n)
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

    public static String getSubsequence(String a, String b, int m, int n)
    {
        StringBuilder s = new StringBuilder();
        int i = m;
        int j = n;
        while(i>0 && j>0)
        {
            if(a.charAt(i-1)==b.charAt(j-1))
            {
                s.append(a.charAt(i-1));
                i--;
                j--;
            }
            else {
                if(dp[i-1][j]>dp[i][j-1])
                {
                    i--;
                }
                else {
                    j--;
                }
            }
        }
        return s.reverse().toString();
    }

    public static void main(String args[])
    {
        String a = "abcuyd";
        String b = "abcdef";
        int m = a.length();
        int n = b.length();
        longestCommonSubsequence(a, b, m, n);
        String result = getSubsequence(a,b,m,n);
        System.out.println(result);
    }



}
