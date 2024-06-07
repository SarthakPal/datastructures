package com.datastructures.slidingWindow;

public class SlidingWindowMaximum {


    public int[] maxSlidingWindow(int[] nums, int k) {
        int res[] = new int[nums.length - k + 1];
        int index = 0;

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < k; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }

        res[index++] = max;

        for (int j = k; j < nums.length; j++) {
            if (nums[j] > max) {
                max = nums[j];
            }
            res[index++] = max;
        }

        return res;

    }


}
