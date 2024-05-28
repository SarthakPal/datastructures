package com.datastructures.sorting;
public class QuickSort {

    public static void swap(int nums[], int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j]=temp;
    }

    // we will take a pivot element and assign it a value of nums[low] then take i,j with value of low and high
    // respectively and start traversing till we find index where nums[i] > pivot and nums[j] < pivot if i<j then
    // we will swap it and if j>i then our loop end and we will swap nums[j] with nums[low] and jth index will be at
    // its correct position and it will become partition point so now the ements left to it need to be sorted and elements
    // right to it need to sorted.

    public static int findPartition(int nums[], int low, int high)
    {
        int pivot = nums[low];
        int i=low;
        int j=high;
        while(i<j)
        {
            do
            {
                i++;
            }while(nums[i]<=pivot);
            do
            {
                j--;
            }while(nums[j]>pivot);

            if(i<j)
            {
                swap(nums, i, j);
            }
        }
        swap(nums, low, j);
        return j;
    }

    public static void quickSort(int nums[], int low, int high)
    {
        if(low<high)
        {
            int partition = findPartition(nums, low, high);
            quickSort(nums, 0, partition-1);
            quickSort(nums, partition+1, high);
        }
    }

    public static void main(String args[])
    {
        int nums[] = {3, 6, 2, 8};
        quickSort(nums, 0, nums.length-1);
        for(int i=0;i<nums.length;i++)
        {
            System.out.println(nums[i]);
        }
    }

}
