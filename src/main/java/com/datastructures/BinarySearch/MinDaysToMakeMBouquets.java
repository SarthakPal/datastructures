package com.datastructures.BinarySearch;

public class MinDaysToMakeMBouquets {
    public static int findMin(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res = Math.min(res, nums[i]);
        }
        return res;
    }

    public static int findMax(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res = Math.max(res, nums[i]);
        }
        return res;
    }

    public static boolean isValid(int[] bloomDay, int days, int m, int k) {
        int count = 0;
        int total = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= days) {
                count++;
            } else {
                total += (count / k);
                count = 0;
            }
        }
        total += (count / k);
        return total >= m;
    }

    public static int minDays(int[] bloomDay, int m, int k) {

        int n = bloomDay.length;

        if (m * k > n) {
            return -1;
        }

        int start = findMin(bloomDay);
        int end = findMax(bloomDay);

        int res = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isValid(bloomDay, mid, m, k)) {
                res = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return res;
    }

    public static void main(String args[])
    {
        int nums[] = {1,10,3,10,2};
        int m = 3;
        int k = 1;
        System.out.println(minDays(nums, m, k));
    }


}
