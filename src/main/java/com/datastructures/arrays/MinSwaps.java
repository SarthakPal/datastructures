package com.datastructures.arrays;

public class MinSwaps {

        public int solve(int[] A, int B) {

            int n = A.length;
            int count=0;
            for(int i=0;i<n;i++)
            {
                if(A[i]<=B)
                {
                    count++;
                }
            }
            int grt = 0;
            for(int j=0;j<count;j++)
            {
                if(A[j]>B)
                {
                    grt++;
                }
            }

            int res = grt;

            int k=0;
            int l=count;

            while(l<n)
            {
                if(A[k]>B) grt--;
                if(A[l]>B) grt++;
                k++;
                l++;
                res = Math.min(res, grt);
            }
            return res;
        }
}



