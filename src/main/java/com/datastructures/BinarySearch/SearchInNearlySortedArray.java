package com.datastructures.BinarySearch;

public class SearchInNearlySortedArray {

    public static int search(int nums[], int n, int target)
    {
        int start = 0;
        int end = n-1;
        while(start<=end)
        {
            int mid = start + (end - start) / 2;
            if(nums[mid]==target)
            {
                return mid;
            }
            if(mid-1>=start && nums[mid-1]==target)
            {
                return mid-1;
            }
            if(mid+1<=end && nums[mid+1]==target)
            {
                return mid+1;
            }
            if(nums[mid]>target)
            {
                end = mid-2;
            }
            if(nums[mid]<target)
            {
                start = mid+2;
            }
        }
        return -1;
    }

    public static void main(String args[])
    {
        int nums[] = { 3, 2, 10, 4, 40 };
        System.out.println(search(nums, nums.length, 4));
    }

}
