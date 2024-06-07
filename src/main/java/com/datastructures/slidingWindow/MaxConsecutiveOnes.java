package com.datastructures.slidingWindow;

public class MaxConsecutiveOnes {

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
