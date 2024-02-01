package com.datastructures.arrays;

//Given an array, arr[] of size N, the task is to find the count of array indices
// such that removing an element from these indices makes the sum of even-indexed
// and odd-indexed array elements equal.

public class SpecialIndex{
        public int solve(int[] arr) {

            int n= arr.length;

            int peven[] = new int[n];
            int podd[] = new int[n];
            peven[0]=arr[0];
            podd[0]=0;
            for(int i=1;i<n;i++)
            {
                if(i%2==0)
                {
                    peven[i]=peven[i-1]+arr[i];
                    podd[i]=podd[i-1];
                }
                else
                {
                    podd[i]=podd[i-1]+arr[i];
                    peven[i]=peven[i-1];
                }
            }
            int seven, sodd;
            int count=0;
            for(int i=0;i<n;i++)
            {
                if(i==0)
                {
                    seven=podd[n-1]-podd[i];
                    sodd=peven[n-1]-peven[i];
                }
                else{
                    seven = peven[i-1]+podd[n-1]-podd[i];
                    sodd = podd[i-1]+peven[n-1]-peven[i];
                }
                if(seven==sodd)
                {
                    count++;
                }
            }
            return count;

    }


}
