package com.datastructures.BinarySearch;

public class KokoEatingBananas {

    public int findMax(int nums[])
    {
        int n = nums.length;
        int max = nums[0];
        for(int i=1;i<n;i++)
        {
            max = Math.max(max, nums[i]);
        }
        return max;
    }

    public boolean isValid(int nums[], int count, int availableHours)
    {
        int totalHours = 0;
        for(int i=0;i<nums.length;i++)
        {
            totalHours += (int) Math.ceil((double) nums[i]/count);
            if(totalHours>availableHours)
            {
                return false;
            }
        }
        return true;
    }

    public int findBananasCount(int nums[], int h)
    {
        int start = 1;
        int end = findMax(nums);
        int res = -1;

        while(start<=end)
        {
            int mid = start + (end - start) / 2;

            if(isValid(nums, mid, h))
            {
                res = mid;
                end = mid -1;
            }
            else
            {
                end = mid + 1;
            }
        }
     return  res;
    }

    public static void main(String args[])
    {
        System.out.println((int)Math.ceil((double)7/6));
    }

}
