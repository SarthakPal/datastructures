package com.datastructures.Strings;

public class PermutationWithSpaces {

    public static void printStrings(String s, String output, int n, int index)
    {
        if(index == n)
        {
            System.out.println(output);
            return;
        }

        printStrings(s, output+s.charAt(index), n, index+1);
        printStrings(s, output+' '+s.charAt(index), n, index+1);

    }

    public static void main(String args[])
    {
        printStrings("bc", "a", 2, 0);
    }

}
