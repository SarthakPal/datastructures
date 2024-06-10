package com.datastructures.arrays;

import java.util.*;


public class LongestConsecutiveSequence {

    int longestConsecutive(int[] nums) {

        int longestLength = 0;
        Map<Integer, Boolean> numberTravelledMap = new HashMap<>();
        for (int num : nums) {
            numberTravelledMap.put(num, Boolean.FALSE);
        }

        for (int num : nums) {
            int currentLength = 1;

            // Check in forward direction
            int nextNum = num + 1;
            while (numberTravelledMap.containsKey(nextNum) &&
                    numberTravelledMap.get(nextNum) == false) {

                currentLength++;
                numberTravelledMap.put(nextNum, Boolean.TRUE);

                // Move to the next number
                nextNum++;
            }

            // Check in reverse direction
            int prevNum = num - 1;
            while (numberTravelledMap.containsKey(prevNum) &&
                    numberTravelledMap.get(prevNum) == false) {

                currentLength++;
                numberTravelledMap.put(prevNum, Boolean.TRUE);

                // Move to the previous number
                prevNum--;
            }

            longestLength = Math.max(longestLength, currentLength);
        }

        return longestLength;
    }

    // Time Complexity: O(NlogN) + O(N), N = size of the given array.
    // Reason: O(NlogN) for sorting the array. To find the longest sequence, we are using a loop that results in O(N).
    // Space Complexity: O(1), as we are not using any extra space to solve this problem.
    public int findLongestConsecutive(int nums[])
    {
        int n = nums.length;
        Arrays.sort(nums);
        int last = Integer.MAX_VALUE;
        int longest = 1;
        int count = 1;
        for(int i=0;i<n;i++)
        {
            if(nums[i]-1==last)
            {
                count++;
                last = nums[i];
            }
            else {
                count = 1;
                last = nums[i];
            }
            longest = Math.max(longest, count);
        }
        return longest;
    }

    public int longesstConsecutive(int nums[])
    {
        int n = nums.length;

        int longest = 1;

        Set<Integer> set = new HashSet<>();

        for(int i=0;i<n;i++)
        {
            set.add(nums[i]);
        }

        for(Integer i:set)
        {
            if(!set.contains(i-1))
            {
                int count = 1;
                int temp = i+1;
                while(set.contains(temp))
                {
                    count++;
                    temp++;
                }
                longest = Math.max(longest,count);
            }
        }

        return longest;
    }

}
