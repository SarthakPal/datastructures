package com.datastructures.sorting;

public class BubbleSort {

    public static void sort(int nums[])
    {
        int n = nums.length;
        for(int i=0;i<n-1;i++)
        {
            for(int j=0;j<n-i-1;j++)
            {
                if(nums[j]>nums[j+1])
                {
                    int temp = nums[j+1];
                    nums[j+1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    public static void main(String args[])
    {
        int nums[] = {3, 6, 2, 8};
        sort(nums);
        for(int i=0;i<nums.length;i++)
        {
            System.out.println(nums[i]);
        }
    }

}
