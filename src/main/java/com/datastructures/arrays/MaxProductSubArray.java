package com.datastructures.arrays;

public class MaxProductSubArray {

        public int maxProduct(int[] nums) {
            int n = nums.length;
            int left = 1;
            int right = 1;
            int ans = Integer.MIN_VALUE;
            for(int i=0;i<n;i++)
            {
                left = left*nums[i];
                right = right*nums[n-1-i];
                ans = Math.max(ans, Math.max(left, right));
                left = left == 0 ? 1 : left;
                right = right == 0 ? 1 : right;
            }
            return ans;
        }

}
