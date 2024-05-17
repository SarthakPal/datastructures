package com.datastructures.arrays;

public class MaximumConsecutiveOnes {

    //Given a binary array nums, return the maximum number of consecutive 1's in the array.

        public int findMaxConsecutiveOnes(int[] nums) {
            int res = Integer.MIN_VALUE;
            int count = 0;
            for(int i=0;i<nums.length;i++)
            {
                if(nums[i]==1)
                {
                    count++;
                }
                else
                {
                    res = Math.max(res, count);
                    count=0;
                }
            }
            res = Math.max(res, count);
            return res;
        }

   // Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

        public int longestOnes(int[] nums, int k) {

            int n = nums.length;
            int start = 0;
            int end = 0;
            int zerocount=0;
            int res = Integer.MIN_VALUE;

            for(end=0;end<n;end++)
            {
                if(nums[end]==0)
                {
                    zerocount++;
                }

                while(zerocount>k)
                {
                    if(nums[start]==0)
                    {
                        zerocount--;
                    }
                    start++;
                }

                res = Math.max(res, end-start+1);

            }

            return res;
    }

}
