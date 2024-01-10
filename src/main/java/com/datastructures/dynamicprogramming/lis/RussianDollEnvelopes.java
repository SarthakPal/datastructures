package com.datastructures.dynamicprogramming.lis;

import java.util.Arrays;
import java.util.Comparator;

public class RussianDollEnvelopes {

    public static int solve(int[][] envelopes)
    {
        Arrays.sort(envelopes, Comparator
                .comparingInt((int[] arr) -> arr[0]) // Sort based on weight
                .thenComparingInt(arr -> arr[1]));  // If weights are equal, sort based on height

        int n = envelopes.length;

        int result[] = new int[n];

        int ans = Integer.MIN_VALUE;

        int curr_idx = 0;

        for(int i=1;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1] && result[j] + 1 > result[i])
                {
                    result[i] = result[j] + 1;
                }
            }
            ans = Math.max(ans, result[i]+1);
        }
        return ans;
    }

    public static void main(String args[])
    {
//        int[][] envelopes = {{3,12},{19,8},{14,17},{15,18},{18,15},{10,7},{20,20},{14,1},{19,15},{5,6}};
        int[][] envelopes = {{6,18},{2,14},{5,6},{4,15},{8,11},{3,11},{11,10},{5,11}};
        //int[][] envelopes = {{8,9}, {8, 18}};
        System.out.println(solve(envelopes));
    }

}
