package com.datastructures.slidingWindow;

public class MaxSumSubArrayOfSizeK {

    public static int maxSum(int nums[], int k)
    {
        int n = nums.length;
        int sum = 0;
        for(int i=0;i<k;i++)
        {
            sum+=nums[i];
        }
        int res = sum;
        for(int i=k;i<n;i++)
        {
            sum+=nums[i] - nums[i-k];
            res = Math.max(sum, res);
        }
        return res;
    }

    public static void main(String args[])
    {
        int arr[] = {1, 4, 2, 10, 2, 3, 1, 0, 20};
        int k = 4;
        System.out.println(maxSum(arr, k));
    }

}
