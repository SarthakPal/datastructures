package com.datastructures.sorting;

public class SelectionSort {

    public static void sort(int nums[])
    {
        int n = nums.length;
        for(int i=0;i<n-1;i++)
        {
            int min_idx = i;
            for(int j=i+1;j<n;j++)
            {
                if(nums[j]<nums[min_idx])
                {
                    min_idx = j;
                }
            }
            int temp = nums[min_idx];
            nums[min_idx] = nums[i];
            nums[i]=temp;
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
