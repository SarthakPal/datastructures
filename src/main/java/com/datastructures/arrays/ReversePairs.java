package com.datastructures.arrays;

import java.util.ArrayList;
import java.util.List;

public class ReversePairs {

    public static void merge(int nums[], int low, int mid, int high)
    {
        List<Integer> list = new ArrayList<>();

        int left = low;
        int right = mid+1;

        while(left<=mid && right<=high)
        {
            if(nums[left]<=nums[right])
            {
                list.add(nums[left]);
                left++;
            }
            else
            {
                list.add(nums[right]);
                right++;
            }
        }

        while(left<=mid)
        {
            list.add(nums[left]);
            left++;
        }

        while(right<=high)
        {
            list.add(nums[right]);
            right++;
        }

        for(int i=low;i<=high;i++)
        {
            nums[i] = list.get(i-low);
        }
    }

    public static int countPairs(int nums[], int low, int mid, int high)
    {
        int count = 0;
        int right = mid+1;
        for(int i=low;i<=mid;i++)
        {
            while(right<=high && (long) nums[i] > 2L * nums[right])
            {
                right++;
            }
            count+=(right - (mid+1));
        }
        return count;
    }

    public static int mergeSort(int nums[], int low, int high)
    {
        int count=0;
        if(low>=high)
        {
            return count;
        }
        int mid = (low+high)/2;
        count+=mergeSort(nums, low, mid);
        count+=mergeSort(nums, mid+1, high);
        count+=countPairs(nums, low, mid, high);
        merge(nums, low, mid, high);
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647};
        int n = 5;
        int cnt = mergeSort(nums, 0, n-1);
        System.out.println("The number of reverse pair is: " + cnt);
    }

}
