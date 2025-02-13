package com.datastructures.arrays;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithSumK {

    // Given an array containing N integers and an integer K.,
    // Your task is to find the length of the longest Sub-Array with the sum of the elements
    // equal to the given value K.
    // array contains positive, negative and zeros.
    public static int lenOfLongestSubarray (int A[], int N, int K) {

        int prefsum = 0;
        int len = 0;

        Map<Integer, Integer> mp = new HashMap<>();

        for(int i=0;i<N;i++)
        {
            prefsum = prefsum + A[i];

            if(prefsum==K)
            {
                len = Math.max(len, i+1);
            }

            int rem = prefsum - K;

            if(mp.containsKey(rem))
            {
                len = Math.max(len, i - mp.get(rem));
            }
            if(!mp.containsKey(prefsum))
            {
                mp.put(prefsum, i);
            }
        }

        return len;

    }

    // if all array elements are positive
    public static int longestSubarray(int[] arr, int k) {

        int i=0;
        int j=0;

        int sum = 0;

        int res = Integer.MIN_VALUE;

        while(j<arr.length)
        {
            sum=sum+arr[j];
            if(sum<k)
            {
                j++;
            }
            else if(sum==k)
            {
                res = Math.max(res, j-i+1);
                j++;
            }
            else if(sum>k)
            {
                // till sum<=k we will keep decreasing sum
                while(sum>k)
                {
                    sum = sum-arr[i];
                    i++;

                    // need to check if sum equals to k
                    if(sum==k)
                    {
                        res = Math.max(res, j-i+1);
                    }
                }
                j++;
            }
        }

        return res;

    }

    public static void main(String args[])
    {
        //int nums[] = {15,-2,2,-8,1,7,10,23};
        int nums[] = {4, 1, 1, 1, 2, 3, 5};
        //System.out.println(LongestSubarrayWithSumK.lenOfLongestSubarray(nums, 8, 0));
        System.out.println(LongestSubarrayWithSumK.longestSubarray(nums, 5));
    }

}
