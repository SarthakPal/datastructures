package com.datastructures.dynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

// https://leetcode.com/problems/maximum-balanced-subsequence-sum/
public class MaximumBalancedSubsequenceSum {

    // this recursion solution will give TLE.
    public long solve(int i, int prev, int[] nums)
    {
        if(i>=nums.length) return 0;

        long take = Integer.MIN_VALUE;

        if(prev==-1 || nums[i]-i>=nums[prev]-prev)
        {
            take = nums[i]+solve(i+1, i, nums);
        }

        long not_take = solve(i+1, prev, nums);

        return Math.max(take, not_take);
    }

    Map<String, Long> map = new HashMap<>();

    // recursion solution will not work, so we will memoize it.
    // for memoization we are not going to use dp[][] because nums.length <= 10^5,
    // and we cannot take this much bigger array. so we are going to use Map;
    // But this will also give TLE.
    public long solveUsingTopDown(int i, int prev, int[] nums)
    {
        if(i>=nums.length) return 0;

        String key = i+"-"+prev;

        if(map.containsKey(key)) return map.get(key);

        long taken = Integer.MIN_VALUE;

        if(prev==-1 || nums[i]-i>=nums[prev]-prev)
        {
            taken = nums[i] + solve(i+1, i, nums);
        }

        long not_taken = solve(i+1, prev, nums);

        long result = Math.max(taken, not_taken);
        map.put(key, result);
        return result;

    }

    //Bottomup Approach, but few TCs will still fail
    public long solveUsingBottomUp(int[] nums)
    {
        int n = nums.length;

        long maxElement = Arrays.stream(nums).max().getAsInt();

        if(maxElement<=0) return maxElement;

        int[] dp = new int[n];
        System.arraycopy(nums, 0, dp, 0, n);

        long maxValue = Integer.MIN_VALUE;

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(nums[i]-i > nums[j]-j)
                {
                    dp[i] = Math.max(dp[i], nums[i]+dp[j]);
                    maxValue = Math.max(maxValue, dp[i]);
                }
            }
        }

        return Math.max(maxElement, maxValue);

    }

    public long maxBalancedSubsequenceSum(int[] nums) {

        long maxValue = Integer.MIN_VALUE;

        boolean allNegative = true;

        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>0)
            {
                allNegative = false;
                break;
            }
            maxValue = Math.max(maxValue, nums[i]);
        }

        if(allNegative)
        {
            return maxValue;
        }

        return solve(0, -1, nums);

    }

    public long maxBalancedSubsequenceSumOptimal(int[] nums) {

        int n = nums.length;

        int[] arr = new int[n];

        for(int i=0;i<n;i++)
        {
            arr[i] = nums[i] - i;
        }

        long ans = Integer.MIN_VALUE;

        TreeMap<Integer, Long> map = new TreeMap<>();

        for(int i=0;i<n;i++)
        {
            if(nums[i]<=0)
            {
                ans = Math.max(ans, nums[i]);
            }
            else
            {
                long temp = nums[i];

                // first find any such key which is less than current key if exists then add it to current key value;
                if(map.floorKey(arr[i])!=null)
                {
                    temp+=map.get(map.floorKey(arr[i]));
                }

                //find any such keys which is greater than current key and its value is less than temp
                while(map.ceilingKey(arr[i])!=null && map.get(map.ceilingKey(arr[i]))<temp)
                {
                    map.remove(map.ceilingKey(arr[i]));
                }

                // if there is a key less than current key or current key already exists
                // and its value is less than temp then we should update it.
                if(map.floorKey(arr[i])==null || map.get(map.floorKey(arr[i]))<temp){
                    map.put(arr[i], temp);
                }
                ans = Math.max(ans, temp);
            }
        }

        return ans;
    }

}
