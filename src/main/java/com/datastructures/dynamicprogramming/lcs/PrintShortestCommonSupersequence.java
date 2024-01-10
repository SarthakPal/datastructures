package com.datastructures.dynamicprogramming.lcs;

public class PrintShortestCommonSupersequence {

    static int dp[][] = new int[1001][1001];

    public static void longestCommonSubsequence(String a, String b, int m, int n)
    {
        for(int i=0;i<=m;i++)
        {
            for(int j=0;j<=n;j++)
            {
                if(i==0)
                {
                    dp[i][j] = 0;
                }
                else if(j==0)
                {
                    dp[i][j] = 0;
                }
                else if(a.charAt(i-1)==b.charAt(j-1))
                {
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
    }

    public static String getSupersequence(String a, String b, int m , int n)
    {
        int i = m;
        int j= n;

        StringBuilder s = new StringBuilder();

        while(i>0 && j>0)
        {
            if(a.charAt(i-1)==b.charAt(j-1))
            {
                s.append(a.charAt(i-1));
                i--;
                j--;
            }
            else if(dp[i-1][j]>dp[i][j-1])
            {
                s.append(a.charAt(i-1));
                i--;
            }
            else {
                s.append(b.charAt(j-1));
                j--;
            }
        }

        while(i>0)
        {
            s.append(a.charAt(i-1));
            i--;
        }

        while(j>0)
        {
            s.append(b.charAt(j-1));
            j--;
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
        String result = getSupersequence(a,b,m,n);
        System.out.println(result);
    }

}
