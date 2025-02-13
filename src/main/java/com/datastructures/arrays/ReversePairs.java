package com.datastructures.arrays;

import java.util.ArrayList;
import java.util.List;


// here we cannot use the logic of count inversions suppose there are 2 arrays [6, 12, 14, 15] and [3,4,8]
// so in count inversion we are doing if 6>3 count will be increased by 4 but here we have to check is 6>2*3 ? which is not
// so we will move the pointer to 4 but 12,14 and 15 is greater than 2*3 but this got excluded from the count.

public class ReversePairs {

    public static void merge(int nums[], int low, int mid, int high) {
        List<Integer> list = new ArrayList<>();

        int left = low;
        int right = mid + 1;

        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                list.add(nums[left]);
                left++;
            } else {
                list.add(nums[right]);
                right++;
            }
        }

        while (left <= mid) {
            list.add(nums[left]);
            left++;
        }

        while (right <= high) {
            list.add(nums[right]);
            right++;
        }

        for (int i = low; i <= high; i++) {
            nums[i] = list.get(i - low);
        }
    }

    public static int countPairs(int nums[], int low, int mid, int high) {
        int count = 0;
        int left = low;
        int right = mid + 1;
        while (left <= mid && right <= high) {
            if ((long) nums[left] > 2L * nums[right]) {
                count += (mid - left + 1); // All elements from left to mid form a pair with nums[right]
                right++;
            } else {
                left++;
            }
        }
        return count;
    }

    public static int mergeSort(int nums[], int low, int high) {
        int count = 0;
        if (low >= high) {
            return count;
        }
        int mid = (low + high) / 2;
        count += mergeSort(nums, low, mid);
        count += mergeSort(nums, mid + 1, high);
        count += countPairs(nums, low, mid, high);
        merge(nums, low, mid, high);
        return count;
    }

    public static void main(String[] args) {
        //int[] nums = {2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647};
        int[] nums = {4, 1, 2, 3, 1};
        int n = 5;
        int cnt = mergeSort(nums, 0, n - 1);
        System.out.println("The number of reverse pair is: " + cnt);
    }

}
