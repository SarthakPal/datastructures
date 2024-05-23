package com.datastructures.BinarySearch;

public class NoOfTimesSortedArrayIsRotated {

    public static int findNoOfTimes(int nums[])
    {
           int n = nums.length;
           int start = 0;
           int end = nums.length - 1;

            if(nums[start]<=nums[end])
            {
                return 0;
            }

           while(start<=end)
           {
               int mid = start + (end - start) / 2;
               int next_idx = ( mid + 1 ) % n; // we are doing % n because if our mid is last index than mid+1
                                               // can go out of bound so we are doing %n
               int prev_idx = ( mid - 1 + n) % n; // we are doing (+ n-1 )  because if our mid is 0th index than mid-1
                                                 // can become -1

               if(nums[mid]<=nums[prev_idx] && nums[mid]<=nums[next_idx])
               {
                    return nums[mid];
               }
               else if(nums[mid]>=nums[start])
               {
                    start = mid+1;
               }
               else if(nums[mid]<=nums[end])
               {
                   end = mid-1;
               }
           }
           return -1;
    }

    public static void main(String args[])
    {
        int arr[] = {66, 67, 7, 10, 14, 19, 27, 33, 36, 40, 44, 54, 60};
        System.out.println(findNoOfTimes(arr));
    }

}
