package com.datastructures.sorting;

public class MergeSort {
    public static void merge(int[] arr, int[] leftArr, int[] rightArr, int left, int right)
    {
        int i=0;
        int j=0;
        int k=0;
        while(i<left && j<right)
        {
            if(leftArr[i]<rightArr[j])
            {
                arr[k++] = leftArr[i];
                i++;
            }
            else
            {
                arr[k++] = rightArr[j];
                j++;
            }
        }
        while(i<left)
        {
            arr[k++] = leftArr[i];
            i++;
        }
        while(j<right)
        {
            arr[k++] = rightArr[j];
            j++;
        }
    }

    public static void mergesort(int nums[], int size)
    {
        if(size<2)
        {
            return;
        }
        int mid = size / 2;
        int[] left = new int[mid];
        int[] right = new int[size - mid];
        for(int i=0;i<mid;i++)
        {
            left[i] = nums[i];
        }
        for(int i=mid;i<size;i++)
        {
            right[i-mid] = nums[i];
        }
        mergesort(left, mid);
        mergesort(right, size-mid);

        merge(nums, left, right, mid, size-mid);
    }

}
