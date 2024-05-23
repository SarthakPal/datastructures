package com.datastructures.BinarySearch;

// leetcode 2064
public class MinMaxProductsToDistribute {

    public int findMax(int[] quantities) {
        int n = quantities.length;
        int res = quantities[0];
        for (int i = 1; i < n; i++) {
            res = Math.max(res, quantities[i]);
        }
        return res;
    }

    public boolean isValid(int k, int count, int[] quantities) {
        int n = quantities.length;
        int totalShops = 0;
        for (int i = 0; i < n; i++) {
            totalShops += (int) Math.ceil((double) quantities[i] / count);
            if (totalShops > k) {
                return false;
            }
        }
        return true;
    }

    public int minimizedMaximum(int n, int[] quantities) {

        int start = 1;
        int end = findMax(quantities);

        int res = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isValid(n, mid, quantities)) {
                res = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return res;
    }

}
