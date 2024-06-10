package com.datastructures.arrays;

public class TrappingRainWater {

    //TC : O(n)
    //SC : O(n)
    public int trap(int[] height) {

        int n = height.length;
        int left[] = new int[n];
        int right[] = new int[n];
        int maxleft = height[0];
        left[0] = 0;
        int maxright = height[n - 1];
        right[n - 1] = 0;
        for (int i = 1; i < n; i++) {
            left[i] = maxleft;
            maxleft = Math.max(maxleft, height[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            right[i] = maxright;
            maxright = Math.max(maxright, height[i]);
        }
        int res = 0;
        for (int i = 1; i < n - 1; i++) {
            if (height[i] < left[i] && height[i] < right[i]) {
                res += Math.min(left[i], right[i]) - height[i];
            }
        }
        return res;
    }

    //TC : O(n)
    //SC : O(1)
    public int trapUsingTwoPointer(int[] height) {

        int n = height.length;

        int maxLeft = height[0];
        int maxRight = height[n - 1];

        int left = 1;
        int right = n - 2;

        int res = 0;

        while (left <= right) {
            if (maxLeft < maxRight) {
                if (height[left] < maxLeft) {
                    res += maxLeft - height[left];
                } else {
                    maxLeft = height[left];
                }
                left++;
            } else {
                if (height[right] < maxRight) {
                    res += maxRight - height[right];
                } else {
                    maxRight = height[right];
                }
                right--;
            }
        }
        return res;
    }

}
