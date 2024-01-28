package com.datastructures.Strings;

import java.util.ArrayList;
import java.util.List;

public class GenerateBalancedParanthesis {

    static List<String> result = new ArrayList<>();

    public static void solve(String output, int open, int close)
    {
        if(open==0 && close==0)
        {
            result.add(output.toString());
            return;
        }
        if(open!=0)
        {
            solve(output+'{', open-1, close);
        }
        if(close>open)
        {
            solve(output+'}', open, close-1);
        }
        return;
    }

    public static void main(String args[])
    {
        int open = 2;
        int close = 2;
        solve("" , open, close);
        for(String s:result)
        {
            System.out.println(s);
        }
    }
}
