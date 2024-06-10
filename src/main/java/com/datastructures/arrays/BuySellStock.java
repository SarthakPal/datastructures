package com.datastructures.arrays;

public class BuySellStock {

    public int maxProfit(int[] prices) {

        int n = prices.length;
        if (n <= 1) {
            return 0;
        }
        int maxRight = prices[n - 1];
        int profit = 0;
        for (int i = n - 2; i >= 0; i--) {
            int temp = maxRight - prices[i];
            profit = Math.max(profit, temp);
            maxRight = Math.max(maxRight, prices[i]);
        }
        return profit;
    }

}
