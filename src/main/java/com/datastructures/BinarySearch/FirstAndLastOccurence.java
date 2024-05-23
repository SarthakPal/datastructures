package com.datastructures.BinarySearch;

public class FirstAndLastOccurence {

    public static int findFirstOccurence(int nums[], int target)
    {
        int start = 0;
        int end = nums.length - 1;
        int res = -1;
        while(start<end)
        {
            int mid = start + (end-start) / 2;
            if(nums[mid]==target)
            {
                res = mid;
                end = mid-1;
            }
            else if(nums[mid]>target)
            {
                end = mid-1;
            }
            else {
                start = mid + 1;
            }
        }
        return res;
    }

    public static int findLastOccurence(int nums[], int target)
    {
        int start = 0;
        int end = nums.length - 1;
        int res = -1;
        while(start<end)
        {
            int mid = start + (end-start) / 2;
            if(nums[mid]==target)
            {
                res = mid;
                start = mid+1;
            }
            else if(nums[mid]>target)
            {
                end = mid-1;
            }
            else {
                start = mid + 1;
            }
        }
        return res;
    }

    public static void main(String args[])
    {
        int nums[] = {1,2, 3, 10, 10, 10, 6};
        System.out.println(findFirstOccurence(nums, 10));
        System.out.println(findLastOccurence(nums, 10));
    }

}
