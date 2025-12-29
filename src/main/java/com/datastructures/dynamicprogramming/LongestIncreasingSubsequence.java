package com.datastructures.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/longest-increasing-subsequence/
public class LongestIncreasingSubsequence {

    int n;
    int dp[][];

    public int solve(int nums[], int i, int prev)
    {
        if(i>=n) return 0;

        if(prev!=-1 && dp[i][prev]!=-1) return dp[i][prev];

        int take=-1, skip=-1;

        if(prev==-1 || nums[i]>nums[prev])
        {
            take = 1+solve(nums, i+1, i);
        }

        skip = solve(nums, i+1, prev);

        if(prev!=-1) dp[i][prev] = Math.max(take, skip);

        return Math.max(take, skip);

    }

    public int lengthOfLIS(int[] nums) {

        n = nums.length;

        dp = new int[n+1][n+1];

        for(int i=0;i<n;i++)
        {
            Arrays.fill(dp[i], -1);
        }

        return solve(nums, 0,-1);
    }

    public int lengthOfLISUsingBottomUp(int[] nums) {

        int n = nums.length;

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int maxLength = 1;

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(nums[i]>nums[j])
                {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    maxLength = Math.max(maxLength, dp[i]);
                }
            }
        }

        return maxLength;
    }

    public int binarySearch(List<Integer> sorted, Integer target)
    {
        int left = 0;
        int right = sorted.size();

        int result = sorted.size();

        while(left<right)
        {
            int mid = left + (right - left) / 2;

            if (sorted.get(mid) < target) {
                left = mid + 1;
            } else {
                result = mid;
                right = mid;
            }

        }

        return result;
    }

    public int lengthOfLISUsingPatienceSorting(int[] nums) {

        int n = nums.length;
        List<Integer> sorted = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            /*
                Why lower bound?
                We want an increasing subsequence, and hence
                we want to eliminate the duplicates as well.
                lower_bound returns the index of "next greater or equal to."
            */
            int index = binarySearch(sorted, nums[i]);

            if (index == sorted.size())
                sorted.add(nums[i]); // greatest: so insert it
            else
                sorted.set(index, nums[i]); // replace
        }

        return sorted.size();

    }

}
