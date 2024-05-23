package com.datastructures.BinarySearch;

public class FloorCeilOfElement {

    public static int findFloor(int nums[], int target)
    {
        int start = 0;
        int end = nums.length - 1;
        int res = -1;
        while(start<=end)
        {
            int mid = start + (end-start) / 2;
            if(nums[mid]==target)
            {
                return nums[mid];
            }
            else if(nums[mid]<target)
            {
                res = mid;
                start = mid + 1;
            }
            else
            {
                end = mid - 1;
            }
        }
        return nums[res];
    }

    public static int findCeil(int nums[], int target)
    {
        int start = 0;
        int end = nums.length - 1;
        int res = -1;
        while(start<=end)
        {
            int mid = start + (end-start) / 2;
            if(nums[mid]==target)
            {
                return nums[mid];
            }
            else if(nums[mid]>target)
            {
                res = mid;
                end = mid - 1;
            }
            else
            {
                start = mid + 1;
            }
        }
        return nums[res];
    }

    public static void main(String args[])
    {
        int nums[] = {1, 2, 3, 4, 8, 10};
        System.out.println(findFloor(nums, 5));
        System.out.println(findCeil(nums, 5));
    }

}
