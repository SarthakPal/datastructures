package com.datastructures.greedy;

import java.util.Arrays;

public class DistributeCandies {

    public static int solve(int[] arr)
    {
        int n = arr.length;
        int left[] = new int[n];
        int right[] = new int[n];
        Arrays.fill(left, 1);
        for(int i=1;i<n;i++)
        {
            if(arr[i]>arr[i-1])
            {
                left[i] = left[i]+1;
            }
        }

        for(int i=n-2;i>=0;i--)
        {
            if(arr[i]>arr[i+1])
            {
                left[i] = Math.max(left[i], left[i]+1);
            }
        }
        int totalSum = 0;
        for(int i=0;i<n;i++)
        {
            totalSum+=left[i];
        }
        return totalSum;
    }

    public static void main(String args[])
    {
        int arr[] = {1,0,2};
        System.out.println(solve(arr));
    }

}
