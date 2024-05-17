package com.datastructures.arrays;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithSumK {

    //Given an array containing N integers and an integer K.,
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

    public static void main(String args[])
    {
        int nums[] = {15,-2,2,-8,1,7,10,23};
        System.out.println(LongestSubarrayWithSumK.lenOfLongestSubarray(nums, 8, 0));
    }

}
