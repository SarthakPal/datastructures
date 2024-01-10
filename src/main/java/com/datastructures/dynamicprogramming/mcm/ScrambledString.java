package com.datastructures.dynamicprogramming.mcm;

import java.util.HashMap;
import java.util.Map;

public class ScrambledString {

    public static Map<String , Boolean> mp = new HashMap<>();

    public static boolean solveUsingMemoization(String a, String b)
    {
        if(a.equals(b))
        {
            return true;
        }

        if(a.length()<=1)
        {
            return false;
        }
        boolean flag = false;
        String temp = a+'_'+b;
        if(mp.containsKey(temp))
        {
            return mp.get(temp);
        }
        for(int k=1;k<=a.length()-1;k++)
        {
            if(solveUsingRecurrsion(a.substring(0,k), b.substring(a.length()-k)) &&
                    solveUsingRecurrsion(a.substring(k), b.substring(0,a.length()-k)))
            {
                flag = true;
                break;
            }
            else if(solveUsingRecurrsion(a.substring(0,k), b.substring(0,k)) &&
                    solveUsingRecurrsion(a.substring(k), b.substring(k)))
            {
                flag = true;
                break;
            }
        }
        mp.put(temp, flag);
        return flag;
    }

    public static boolean solveUsingRecurrsion(String a, String b)
    {
        if(a.equals(b))
        {
            return true;
        }

        if(a.length()<=1)
        {
            return false;
        }
        boolean flag = false;
        for(int k=1;k<=a.length()-1;k++)
        {
            if(solveUsingRecurrsion(a.substring(0,k), b.substring(a.length()-k)) &&
                    solveUsingRecurrsion(a.substring(k), b.substring(0,a.length()-k)))
            {
                flag = true;
                break;
            }
            else if(solveUsingRecurrsion(a.substring(0,k), b.substring(0,k)) &&
                    solveUsingRecurrsion(a.substring(k), b.substring(k)))
            {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public static void main(String args[])
    {
        String a = "great";
        String b = "rgate";
        System.out.println(solveUsingMemoization(a,b));
    }

}
