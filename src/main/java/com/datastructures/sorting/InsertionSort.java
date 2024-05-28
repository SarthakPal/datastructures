package com.datastructures.sorting;

public class InsertionSort {

    // we wil take an element and if it is smaller than its previous element so we will swap it. and we will check
    // for the all lesser index elements than the current index elements.

    public static void sort(int nums[])
    {
        int n = nums.length;
        for(int i=0;i<n;i++)
        {
            int key = nums[i];
            int j=i-1;
            while(j>=0 && nums[j]>key)
            {
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = key;
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
