package com.datastructures.dynamicprogramming.mcm;

import java.util.HashMap;
import java.util.Map;

public class EvaluateExpression {

    public static Map<String, Integer> mp = new HashMap<>();

    public static int solveUsingMemoization(String s, int i, int j, boolean isTrue)
    {
        if(i>j)
        {
            return 0;
        }
        if(i==j)
        {
            if(s.charAt(i)=='T') {
                if (isTrue == true) {
                    return 1;
                } else {
                    return 0;
                }
            }
            else {
                if (isTrue == false) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }

        String temp = String.valueOf(i)+'_'+String.valueOf(j)+'_'+String.valueOf(isTrue);

        if(mp.containsKey(temp))
        {
            return mp.get(temp);
        }

        int ans = 0;

        for(int k=i+1;k<j;k+=2)
        {
            int lf = solveUsingMemoization(s, i, k-1, false);
            int lt = solveUsingMemoization(s, i, k-1, true);
            int rf = solveUsingMemoization(s, k+1, j, false);
            int rt = solveUsingMemoization(s, k+1, j, true);

            if(s.charAt(k)=='&')
            {
                if(isTrue == true)
                {
                    ans+=lt*rt;
                }
                else {
                    ans+=(lf*rf) + (lt*rf) + (lf*rt);
                }
            }

            else if(s.charAt(k)=='|')
            {
                if(isTrue==true)
                {
                    ans+=(lf*rt) + (rf*lt) + (lt*rt);
                }
                else {
                    ans+=lf*rf;
                }
            }

            else if (s.charAt(k) == '^') {
                if(isTrue==true)
                {
                    ans+=(lf*rt) + (lt*rf);
                }
                else {
                    ans+=(lt*rt) + (lf*rf);
                }
            }
        }
        mp.put(temp, ans);
        return ans;
    }

    public static int solveUsingRecurrsion(String s, int i, int j, boolean isTrue)
    {
        int ans = 0;

        if(i>j)
        {
            return 0;
        }

        if (i == j) {
            return (isTrue == (s.charAt(i) == 'T')) ? 1 : 0;
        }

        for(int k=i+1;k<j;k+=2)
        {
            int lt = solveUsingRecurrsion(s, i, k-1, true);
            int lf = solveUsingRecurrsion(s, i, k-1, false);
            int rt = solveUsingRecurrsion(s, k+1, j, true);
            int rf = solveUsingRecurrsion(s, k+1, j, false);

            if(s.charAt(k)=='&')
            {
                if(isTrue == true)
                {
                    ans+=lt*rt;
                }
                else {
                    ans+=(lf*rf) + (lt*rf) + (lf*rt);
                }
            }

            else if(s.charAt(k)=='|')
            {
                if(isTrue==true)
                {
                    ans+=(lf*rt) + (rf*lt) + (lt*rt);
                }
                else {
                    ans+=lf*rf;
                }
            }

         else if (s.charAt(k) == '^') {
                if(isTrue==true)
                {
                    ans+=(lf*rt) + (lt*rf);
                }
                else {
                    ans+=(lt*rt) + (lf*rf);
                }
            }
        }

        return ans;
    }

    public static void main(String args[])
    {
        String s = "T|T&F^T";
        System.out.println(solveUsingRecurrsion(s, 0, s.length()-1, true));
    }

}

