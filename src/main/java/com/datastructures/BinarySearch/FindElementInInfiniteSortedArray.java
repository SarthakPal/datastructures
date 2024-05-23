package com.datastructures.BinarySearch;

public class FindElementInInfiniteSortedArray {

    public int binarySearch(int nums[], int start, int end, int target)
    {
        while(start<=end)
        {
            int mid = start + (end - start) / 2;
            if(nums[mid]==target)
            {
                return mid;
            }
            else if(nums[mid] < target)
            {
                start = mid+1;
            }
            else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public int findElement(int nums[], int target)
    {
        int start = 0;
        int end = 1;

        while(nums[end]<target)
        {
            start = end;
            end = end*2;
        }

        return binarySearch(nums,  start,  end, target);

    }

}
