package com.datastructures.BinarySearch;

public class PeakElement {

    public static int findPeakElement(int nums[])
    {
        int start = 0;
        int end = nums.length - 1;

        while(start<=end)
        {
            int mid = start + (end - start) / 2;
            if(nums[mid-1]<nums[mid] && nums[mid+1]<nums[mid])
            {
                return nums[mid];
            }
            else if(nums[mid-1]<nums[mid])
            {
                start = mid + 1;
            }
            else if(nums[mid+1]<nums[mid])
            {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String args[])
    {
        int nums[] = {5, 10, 20, 15};
        System.out.println(findPeakElement(nums));
    }

}
