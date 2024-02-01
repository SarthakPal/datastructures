package com.datastructures.arrays;

public class MaximumPositivity {

        public int[] solve(int[] A) {

            int i=0;
            int j=0;
            int end=-1;
            int start=0;
            int n = A.length;
            while(i<n && j<n)
            {
                if (A[j] < 0) {
                    j++;
                    i=j;
                    continue;
                }
                if(A[j]>=0)
                {
                    j++;
                }
                if(j-i>end-start+1)
                {
                    start=i;
                    end=j-1;
                }
            }
            int res[] = {};
            if(start!=-1 && end!=-1)
            {
                res = new int[end-start+1];
                int index=0;
                for(int k=start;k<=end;k++)
                {
                    res[index] = A[k];
                    index++;
                }
            }
            return res;


        }
    }



