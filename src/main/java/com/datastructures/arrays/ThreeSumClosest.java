package com.datastructures.arrays;

import java.util.Arrays;

public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int n = nums.length;
        int min_diff = Integer.MAX_VALUE;
        int res = 0;

        for(int i=0;i<n-2;i++)
        {
            int left = i+1;
            int right = n-1;

            while(left<right)
            {
                int sum = nums[i] + nums[left] + nums[right];

                if(sum==target)
                {
                    return sum;
                }
                else if(sum<target)
                {
                    left++;
                }
                else
                {
                    right--;
                }

                int temp_diff = Math.abs(sum - target);

                if(temp_diff < min_diff)
                {
                    min_diff = temp_diff;
                    res = sum;
                }
            }

        }
        return res;
    }

}
