package com.datastructures.dynamicprogramming.knapsack;

public class MinimumSubsetDifference {

    public static int minimumsubsetDifference(int arr[], int totalSum)
    {
        int n = arr.length;
        boolean dp[][] = new boolean[n+1][totalSum+1];

        dp[0][0] = true;

        for(int i=1;i<n;i++)
        {
            dp[0][i] = false;
        }

        for(int i=1;i<=n;i++)
        {
            for(int j=0;j<=totalSum;j++)
            {
                if(j==0)
                {
                    dp[i][j] = true;
                }

                else if(arr[i-1]<=j)
                {
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                }

                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        int sum1 = Integer.MIN_VALUE;

        for(int j=0;j<=totalSum/2;j++)
        {
            if(dp[n][j]==true)
            {
                sum1 = Math.max(sum1, j);
            }
        }

        return sum1;

    }

    public static void main(String args[])
    {
        int arr[] = {1, 6, 5, 11};
        int totalSum = 0;
        for(int i=0;i<arr.length;i++)
        {
            totalSum+=arr[i];
        }

        //in the given array we have to find 2 subarrays such that the diff between them should be minimum.
        // Let s1 amd s2 be 2 such sums and s2 > s1 and we have to minimize the diff such that s2 - s1 = min. And s1+s2 = totalSum of the array.
        // If we use these 2 equations then totalSum - 2*s1 = min. Now we have to find the value of s1.
        // s1 is the maximum value of subset sum. and it range is 0 to totalSum/2 because s1 < s2.
        // We will prepare our dp array so in that array the last row contains the subset sum possible using all the elements of array.
        // We will take that max value of j where it is true.

        int sum1 = minimumsubsetDifference(arr, totalSum);
        System.out.println(totalSum-2*sum1);

    }

}
