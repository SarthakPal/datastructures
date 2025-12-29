package com.datastructures.dynamicprogramming;

import java.util.Arrays;

// https://leetcode.com/problems/build-array-where-you-can-find-the-maximum-exactly-k-comparisons/
public class BuildArrayWithMaximumExactlyKcomparisons {

    int N, M, K;

    int[][][] dp;

    int MOD = 1000000007;

    public int solve(int idx, int searchCost, int maxValue)
    {
        if(idx==N)
        {
            if(searchCost==K)
            {
                return 1;
            }

            return 0;
        }

        if (dp[idx][searchCost][maxValue] != -1) {
            return dp[idx][searchCost][maxValue];
        }

        int result = 0;

        for(int i=1;i<=M;i++)
        {
            if( i>maxValue )
            {
                result = (result + solve(idx+1, searchCost+1, i)) % MOD;
            }
            else
            {
                result = (result + solve(idx+1, searchCost, maxValue)) % MOD;
            }
        }

        return dp[idx][searchCost][maxValue]=result%MOD;

    }

    public int numOfArrays(int n, int m, int k) {

        N = n;
        M = m;
        K = k;

        dp = new int[51][51][101];

        for(int i=0;i<51;i++)
        {
            for(int j=0;j<51;j++)
            {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return solve(0,0,0);

    }

}
