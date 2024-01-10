package com.datastructures.dynamicprogramming.lcs;
public class LongestRepeatingSubsequence {
    static int dp[][] = new int[1001][1001];
    public static int longestRepeatingSubsequenceUsingTopDown(String a, String b, int m , int n)
    {

        StringBuilder s = new StringBuilder();

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
                else if(a.charAt(i-1)==b.charAt(j-1) && i!=j)
                {
                    s.append(a.charAt(i-1));
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
    public static void main(String args[])
    {
        String a = "agbcba";
        StringBuffer b = new StringBuffer(a);
        System.out.println(longestRepeatingSubsequenceUsingTopDown(a, b.reverse().toString(), a.length(), b.length()));
    }

}
