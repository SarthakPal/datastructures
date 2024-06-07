package com.datastructures.slidingWindow;

public class CountNiceSubarrays {

    //same explanation as binarySubarrays with sum
    public int findCount(int nums[], int k) {
        int n = nums.length;
        int left = 0;
        int oddCount = 0;
        int max = 0;
        int res = 0;

        for (int right = 0; right < n; right++) {
            if (nums[right] % 2 == 1) {
                oddCount++;
            }
            while (oddCount > k) {
                if (nums[left] % 2 == 1) {
                    oddCount--;
                }
                left++;
            }
            res += (right - left + 1);
        }
        return res;
    }

    public int numberOfSubarrays(int[] nums, int k) {
        return findCount(nums, k) - findCount(nums, k - 1);
    }

}
