package com.datastructures.recurrsion;

public class SubsetSum {

    private static boolean result;

    public static void isSubsetPresentUtil(int idx, int target, int nums[]) {
        if (target == 0) {
            result = true;
            return;
        }

        if (target < 0 || idx >= nums.length) {
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            isSubsetPresentUtil(i + 1, target - nums[i], nums);
            if (result) return; // Early exit if result is already true
        }

    }

    public static boolean isSubsetPresent(int n, int target, int nums[]) {
        // Write your code here
        result = false;
        isSubsetPresentUtil(0, target, nums);
        return result;

    }

    public static void main(String args[]) {
        int n = 94;
        int target = 84;
        int nums[] = {22, 17, 19, 46, 48, 27, 22, 39, 20, 13, 18, 50, 36, 45, 4, 12, 23, 34, 24, 15, 42, 12,
                4, 19, 48, 45, 13, 8, 38, 10, 24, 42, 30, 29, 17, 36, 41, 43, 39, 7, 41, 43, 15, 49, 47, 6, 41,
                30, 21, 1, 7, 2, 44, 49, 30, 24, 35, 5, 7, 41, 17, 27, 32, 9, 45, 40, 27, 24, 38, 39, 19, 33, 30,
                42, 34, 16, 40, 9, 5, 31, 28, 7, 24, 37, 22, 46, 25, 23, 21, 30, 28, 24, 48, 13};
        System.out.println(isSubsetPresent(5, 14, nums));
    }


}
