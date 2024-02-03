package com.datastructures.arrays;

public class MaxDis {

        public static int solve(int[] A, int B) {

            int n = A.length;
            int count=0;
            for(int i=0;i<n;i++)
            {
                if(A[i]<=B)
                {
                    count++;
                }
            }
            System.out.println("count:"+count);
            int grt = 0;
            for(int j=0;j<count;j++)
            {
                if(A[j]>B)
                {
                    grt++;
                }
            }
            System.out.println("grt:"+grt);
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
                System.out.println("res:"+res);
            }
            return res;
        }

        public static void main(String args[])
        {
            int a[] = {10, 9, 3, 1, 2};
            int b = 3;
            System.out.println(solve(a,b));
        }

}



