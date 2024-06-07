package com.datastructures.arrays;

import java.util.HashMap;
import java.util.Map;

public class CountSubArraysWithSumK {


    public int subarraySum(int[] nums, int k) {

        Map<Integer, Integer> mp = new HashMap<>();

        int currSum = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            currSum = currSum + nums[i];
            if (currSum == k) {
                count++;
            }
            int rem = currSum - k;
            if (mp.containsKey(rem)) {
                count += mp.get(rem);
            }
            //  If anyone is confused why the count was increased by myMap[ curr - k ] instead of just count+=1 .
            //  It was because prefix sum can be same because of some negative values in the array.
            //  so out next occurring k will also pair  with those negative values also .
            //  consider this case A : [3 4  7    2   -3   1   4   2   1 ]
            //                     preSum : [3 7 14 16 13 14 18 20 21]
            //  you can see 14 occurred twice  because of the subsequence [2 -3 1] their sum is 0.
            //  so When you are at the final index with value 1 . you have curr - k = 21 - 7 = 14 .
            //  you check for 14 it has occurred twice . so you need to consider subsequences [2 -3 1 4 2 1] and [4 2 1] .
            mp.put(currSum, mp.getOrDefault(currSum, 0) + 1);
        }

        return count;

    }

}
