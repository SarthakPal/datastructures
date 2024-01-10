package com.datastructures.dynamicprogramming.lis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncrerasingSubsequence {

    public static List<Integer> printLIS(int arr[])
    {

        int n = arr.length;

        int lis[] = new int[n];
        int trk[] = new int[n];

        Arrays.fill(trk, -1);

        int ans = Integer.MIN_VALUE;
        int lis_end_idx = -1;

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(arr[i]>arr[j])
                {
                    lis[i] = lis[j]+1;
                    trk[i] = j;
                }
            }
            ans = Math.max(ans, lis[i]+1);
            lis_end_idx = i;
        }

        List<Integer> result = new ArrayList<>();

        while(trk[lis_end_idx]!=-1)
        {
            result.add(0, arr[lis_end_idx]);
            lis_end_idx = trk[lis_end_idx];
        }

        result.add(0,arr[lis_end_idx]);
        return result;
    }

    public static int solve(int arr[])
    {

        int n = arr.length;

        int lis[] = new int[n];
        int trk[] = new int[n];

        int ans = Integer.MIN_VALUE;

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(arr[i]>arr[j] && lis[j]+1 > lis[i])
                {
                    lis[i] = lis[j]+1;
                    trk[i] = j;
                }
            }
            ans = Math.max(ans, lis[i]+1);
        }
        /*System.out.println("ans:"+ans);
        for(int k=0;k<n;k++)
        {
            System.out.print(lis[k]+" ");
        }*/
        return ans;
    }

    public static void main(String args[])
    {
        int arr[] = {3, 4, 5, 1};
        System.out.println("\n"+solve(arr));
    }

}
