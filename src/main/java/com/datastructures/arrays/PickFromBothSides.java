package com.datastructures.arrays;

public class PickFromBothSides {
        public int solve(int[] arr, int B) {

            int n = arr.length;

            int pf[]=new int[n];
            pf[0]=arr[0];
            for(int i=1;i<n;i++)
            {
                pf[i] = pf[i-1]+arr[i];
            }

            if(n==B)
            {
                return pf[n-1];
            }

            int sf[]=new int[n];
            sf[n-1]=arr[n-1];
            for(int i=n-2;i>=0;i--)
            {
                sf[i] = sf[i+1]+arr[i];
            }
            int maxSum=Integer.MIN_VALUE;
            int sum=0;
            for(int k=1;k<=B;k++)
            {
                if(k!=B)
                {
                    sum = pf[k-1]+sf[n-(B-k)];
                    maxSum = Math.max(maxSum,sum);
                }
                else
                {
                    //System.out.println("maxSum:"+maxSum);
                    //System.out.println("pf[k]:"+pf[k-1]);
                    //System.out.println("sf[k]:"+sf[n-k]);
                    sum = Math.max(pf[k-1], sf[n-k]);
                    maxSum = Math.max(maxSum,sum);
                }
            }
            //System.out.println("maxSum:"+maxSum);
            return maxSum;

        }
    }



