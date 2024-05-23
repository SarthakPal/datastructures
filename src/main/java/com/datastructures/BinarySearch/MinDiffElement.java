package com.datastructures.BinarySearch;

public class MinDiffElement {

    public int findMin(int nums[], int target)
    {
        int start = 0;
        int end = nums.length - 1;
        while(start<=end)
        {
            int mid = start + (end - start) / 2;

            if(nums[mid]==target)
            {
                return 0;
            }
            else if(nums[mid]>target)
            {
                end = mid - 1;
            }
            else
            {
                start = mid + 1;
            }
        }

        // at the end of the while loop we will get start and end and start > end ad our target will be between
        // end and start for example if arr[1, 3, 8, 10, 15] and target is 12 so end will be at 10 and start will
        // be at 10.
        return Math.min(Math.abs(nums[start]- target), Math.abs(nums[end] - target));
    }

}
