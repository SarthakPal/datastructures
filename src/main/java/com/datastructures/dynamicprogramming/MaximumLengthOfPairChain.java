package com.datastructures.dynamicprogramming;

import java.util.Arrays;

// https://leetcode.com/problems/maximum-length-of-pair-chain/
public class MaximumLengthOfPairChain {

    int n;
    int dp[][];

    public int solve(int currIdx, int[][] pairs, int prevIdx)
    {
        if(currIdx>=n) return 0;

        if(prevIdx!=-1 && dp[currIdx][prevIdx]!=-1) return dp[currIdx][prevIdx];

        int take = -1;

        if(prevIdx==-1 || pairs[currIdx][0]>pairs[prevIdx][1])
        {
            take = 1+solve(currIdx+1, pairs, currIdx);
        }

        int skip = solve(currIdx+1, pairs, prevIdx);

        if(prevIdx!=-1) dp[currIdx][prevIdx] = Math.max(take, skip);

        return Math.max(take, skip);

    }

    public int findLongestChain(int[][] pairs) {

        n = pairs.length;

        dp = new int[n+1][n+1];

        for(int i=0;i<=n;i++)
        {
            Arrays.fill(dp[i], -1);
        }

        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));

        return solve(0, pairs, -1);
    }

    public int findLongestChainUsingBottomUp(int[][] pairs) {

        int n = pairs.length;

        Arrays.sort(pairs, (a,b)->Integer.compare(a[0], b[0]));

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int maxLength = 1;

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(pairs[i][0] > pairs[j][1])
                {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    maxLength = Math.max(maxLength, dp[i]);
                }
            }
        }

        return maxLength;

    }

}
