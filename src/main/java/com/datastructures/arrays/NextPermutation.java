package com.datastructures.arrays;

public class NextPermutation {

    public static void reverse(int arr[], int start, int end)
    {
        while(start<=end)
        {
            int temp = arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }

    public static void swap(int arr[], int start, int end)
    {
            int temp = arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
    }

    public static void nextPermutation(int arr[])
    {
        int n = arr.length;
        int idx = -1;
        for(int i=n-1;i>0;i--)
        {
            if(arr[i]>arr[i-1])
            {
                idx = i;
                break;
            }
        }

        if(idx==-1)
        {
            reverse(arr, 0, n-1);
        }

        else {
            int prev = idx;
            for(int i = idx+1;i<n;i++)
            {
                if(arr[i]>arr[idx-1] && arr[i]<arr[prev])
                {
                    prev = i;
                }
            }
            swap(arr,idx-1, prev);
            reverse(arr, idx, n-1);
        }

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
