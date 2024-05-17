package com.datastructures.arrays;

import java.util.Arrays;

public class NextPermutation {

    public static void reverse(int nums[], int start, int end)
    {
        while(start<end)
        {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    // first we will start iterating over the array and try to find out the peak index where the
    // array element is greater than the prev index array element.
    // if the array is in desc order like 5,4,3,2 we just only need to reverse it and here the peak index
    // will remain 1.
    // now if the array is 1, 2, 5, 1 we will find the peak index and first swap it with prev index element
    // and reverse the remaining elements after it because the rem elements will be in desc order
    // but if the array is 1, 2, 5, 4, 3 we will find the peak index and then we cannot just swap
    // the peak index and prev index element because in that case result is 1, 5, 2, 3, 4 which is incorrect
    // the correct output is 1, 3, 2, 5, 4 so after finding the peak index we need to find if there is any other element
    // after peak index element  which is between peak index element and prev element of peak index, and here
    // that element is 3 so we will find 3 and swap it with 2 and then reverse 5, 4, 2.


    public static void nextPermutation(int nums[])
    {
        int peak_index = -1;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]>nums[i-1])
            {
                peak_index = i;
            }
        }
        if(peak_index==-1)
        {
            reverse(nums, 0, nums.length-1);
            return;
        }
        int index = peak_index;
        for(int k=peak_index+1;k<nums.length;k++)
        {
            if(nums[k]>nums[peak_index-1] && nums[k]<nums[index])
            {
                index = k;
            }
        }
        int temp = nums[peak_index-1];
        nums[peak_index-1] = nums[index];
        nums[index] = temp;
        reverse(nums, peak_index, nums.length-1);
    }

    public static void main(String args[])
    {
        int arr[] = {1, 5, 8, 4, 7, 6, 5, 3, 1};
        nextPermutation(arr);
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }

}
