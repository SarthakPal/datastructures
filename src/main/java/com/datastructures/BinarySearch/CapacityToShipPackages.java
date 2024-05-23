package com.datastructures.BinarySearch;

public class CapacityToShipPackages {


    public int findMax(int nums[]) {
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        return max;
    }

    public int findSum(int nums[]) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }

    public boolean isValid(int nums[], int cap, int days) {
        int sum = 0;
        int total_days = 1;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > cap) {
                total_days++;
                sum = nums[i];
            }
        }
        return total_days <= days;
    }

    public int shipWithinDays(int[] nums, int days) {

        int start = findMax(nums);
        int end = findSum(nums);
        int res = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isValid(nums, mid, days)) {
                res = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return res;
    }


}
