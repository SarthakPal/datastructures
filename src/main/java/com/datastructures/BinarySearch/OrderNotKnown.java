package com.datastructures.BinarySearch;

public class OrderNotKnown {

    public static int binarySearch(int nums[], int target)
    {
        int start = 0;
        int end = nums.length - 1;

        boolean isAsc = true;

        if(nums[end]<nums[start])
        {
            isAsc = false;
        }

        while(start < end)
        {
            int mid = start + (end-start) / 2;
            if(nums[mid]==target)
            {
                return mid;
            }
            if(isAsc==false)
            {
                if(nums[mid]<target)
                {
                    end = mid-1;
                }
                else {
                    start = mid+1;
                }
            }
            else
            {
                if(nums[mid]>target)
                {
                    end = mid-1;
                }
                else {
                    start = mid+1;
                }
            }

        }
        return -1;
    }

    public static void main(String args[])
    {
        int nums[] = {5, 4, 3, 2, 1};
        System.out.println(binarySearch(nums, 2));
    }

}
