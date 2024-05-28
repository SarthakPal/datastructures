package com.datastructures.arrays;

import java.util.ArrayList;
import java.util.List;

public class CountInversions {

    public static int merge(int arr[], int low, int mid, int high)
    {
        int count = 0;
        List<Integer> list = new ArrayList<>();
        int left = low;
        int right = mid + 1;
        while(left<=mid && right<=high)
        {
            if(arr[left]<=arr[right])
            {
                list.add(arr[left]);
                left++;
            }
            else {
                list.add(arr[right]);
                count+=(mid-left+1);
                right++;
            }
        }
        while(left<=mid)
        {
            list.add(arr[left]);
            left++;
        }
        while(right<=high)
        {
            list.add(arr[right]);
            right++;
        }
        for(int i=low;i<=high;i++)
        {
            arr[i] = list.get(i-low);
        }
        return count;
    }

    public static int numberOfInversions(int nums[], int low, int high)
    {
        int count=0;
        if(low>=high)
        {
            return count;
        }
        int mid = (low+high)/2;
        count+=numberOfInversions(nums, low, mid);
        count+=numberOfInversions(nums, mid+1, high);
        count+=merge(nums, low, mid, high);
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};
        int n = 5;
        int cnt = numberOfInversions(nums, 0, n-1);
        System.out.println("The number of inversions are: " + cnt);
    }

}
