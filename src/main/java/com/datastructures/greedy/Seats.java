package com.datastructures.greedy;

import java.util.ArrayList;


public class Seats {
        public static int seats(String str) {
            int mod = 10000003;
            int len = str.length();
            ArrayList<Integer> list = new ArrayList<>();
            for(int i=0;i<len;i++)
            {
                if(str.charAt(i)=='x')
                {
                    list.add(i);
                }
            }
            int size = list.size();
            if(size==1)
            {
                return 0;
            }
            int mid = 0;
            if(size%2!=0)
            {
                mid = size/2;
            }
            else
            {
                mid = size/2 - 1;
            }
            int left = mid-1;
            int right = mid+1;
            int res = 0;
            int k=1;
            while(left>=0)
            {
                res = (res + ((list.get(mid) - (list.get(left)+k)) % mod))%mod;
                left--;
                k++;
            }
            k=1;
            while(right<list.size())
            {
                res= (res + ((list.get(right) - (list.get(mid)+k)) % mod))%mod;
                right++;
                k++;
            }
            return res%mod;
        }


    public static void main(String args[])
    {
        String A = "....x..xx...x..";
        System.out.println(seats(A));
    }


}
