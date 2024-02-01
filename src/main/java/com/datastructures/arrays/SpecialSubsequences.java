package com.datastructures.arrays;

public class SpecialSubsequences {

        public int solve(String str) {
            int mod=1000000007;
            int count=0;
            int ans=0;
            for(int i=str.length()-1;i>=0;i--)
            {
                if(str.charAt(i)=='G')
                {
                    count++;
                }
                else if(str.charAt(i)=='A')
                {
                    ans=ans+count;
                }
            }
            return ans%mod;
        }
}


