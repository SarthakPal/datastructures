package com.datastructures.dynamicprogramming;

import java.util.Arrays;

// https://leetcode.com/problems/longest-string-chain/
public class LongestStringChain {

    int n;
    int[][] dp;

    public int solve(String[] words, int currIdx, int prevIdx)
    {
        if(currIdx>=n) return 0;

        if(prevIdx!=-1 && dp[currIdx][prevIdx]!=-1) return dp[currIdx][prevIdx];

        int take = -1;

        if(prevIdx==-1 || isPredecessor(words[currIdx], words[prevIdx]))
        {
            take = 1+solve(words, currIdx+1, currIdx);
        }

        int skip = solve(words, currIdx+1, prevIdx);

        if(prevIdx!=-1) dp[currIdx][prevIdx] = Math.max(take, skip);

        return Math.max(take, skip);
    }

    public int longestStrChain(String[] words) {

        n = words.length;

        Arrays.sort(words, (a,b)->Integer.compare(a.length(), b.length()));

        dp = new int[n+1][n+1];

        for(int i=0;i<n;i++)
        {
            Arrays.fill(dp[i], -1);
        }

        return solve(words, 0, -1);
    }

    public boolean isPredecessor(String currWord, String prevWord)
    {
        int prevWordLength = prevWord.length();
        int currWordLength = currWord.length();

        if(prevWordLength>=currWordLength || currWordLength-prevWordLength!=1)
        {
            return false;
        }

        int i=0, j=0;

        while(i<prevWordLength && j<currWordLength)
        {
            if(prevWord.charAt(i)==currWord.charAt(j))
            {
                i++;
            }
            j++;
        }

        return i==prevWordLength;

    }

    public int longestStrChainUsingBottomUp(String[] words) {

        int n = words.length;

        Arrays.sort(words, (a,b)->Integer.compare(a.length(), b.length()));

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int maxLength = 1;

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(isPredecessor(words[i], words[j]))
                {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    maxLength = Math.max(dp[i], maxLength);
                }
            }
        }

        return maxLength;

    }

}
