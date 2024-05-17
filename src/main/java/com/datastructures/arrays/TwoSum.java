package com.datastructures.arrays;

import java.util.Arrays;

public class TwoSum {

    public int[] twoSumBruteForce(int[] nums, int target) {

        int n = nums.length;

        int res[] = new int[2];

        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                if(nums[i]+nums[j]==target)
                {
                    res[0] = i;
                    res[1] = j;
                    break;
                }
            }
        }
        return res;
    }

    public int[] twoSumUsingSorting(int nums[], int target)
    {
        int res[] = new int[2];

        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;

        while(left < right)
        {
            if(nums[left]+nums[right]==target)
            {
                res[0] = left;
                res[1] = right;
                break;
            }
            else if(nums[left]+nums[right]<target)
            {
                left++;
            }
            else
            {
                right--;
            }
        }

        return res;
    }

    public static void main(String args[])
    {
        TwoSum ts = new TwoSum();
        int nums[] = {3, 2, 4};
        ts.twoSumUsingSorting(nums, 6);
    }

}
