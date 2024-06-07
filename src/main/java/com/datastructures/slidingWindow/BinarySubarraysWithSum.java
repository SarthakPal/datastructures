package com.datastructures.slidingWindow;

public class BinarySubarraysWithSum {

    // [1, 0, 0, 1, 1, 0] if we go with the approach of left and right pointer we will get only 3 arrays
    // [1, 0, 0, 1] [0, 0, 1, 1] [0, 0, 1, 1, 0] which is not correct because there are other subarrays as well like
    // [0, 1, 1, 0] [1, 1]
    // but we are not getting that because we are not moving left.
    // so solution is we wil find count for <=goal and then we will find for <=goal-1 and find the difference.

    public int findCount(int nums[], int k)
    {
        int n = nums.length;
        int left = 0;
        int sum = 0;
        int count = 0;
        for(int right=0;right<n;right++)
        {
            sum = sum+nums[right];
            while(sum>k)
            {
                sum = sum - nums[left];
                left++;
            }
            // we are not adding 1 becuase we need all the subarrays with sum<=k
            count+=(right-left+1);
        }
        return count;
    }

    public int numSubarraysWithSum(int[] nums, int goal) {

        return findCount(nums, goal) - findCount(nums, goal-1);

    }

}
