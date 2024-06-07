package com.datastructures.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {

    // AABABBA we will start from left=0 and right=0 and keep incrementing right and everytime we will store the
    // frequency of the current character suppose we are at idx = 1 then maxFrequency will be 2 and our length is
    // also 2 which is 0 and less than k but at idx = 2 len(i.e. right-left+1)-maxFrequency will become 1 which is less
    // than k but at idx 5 len-maxFrequency will become greater than k and we need to move left and keep calculating the
    // maxLength.

    public static int findLength(String str, int k)
    {
        Map<Character, Integer> mp = new HashMap<>();
        int n = str.length();
        int left = 0;
        int maxFrequency = 0;
        int maxLength = 0;
        for(int right = 0;right<n;right++)
        {
            Character c = str.charAt(right);
            mp.put(c, mp.getOrDefault(c, 0)+1);
            maxFrequency = Math.max(maxFrequency, mp.get(c));
            while((right-left+1) - maxFrequency > k)
            {
                Character temp = str.charAt(left);
                mp.put(temp, mp.get(temp)-1);
                left++;
            }
            maxLength = Math.max(maxLength, right-left+1);
        }
        return maxLength;
    }

    public static void main(String args[])
    {
        String str = "AABABBA";
        int k = 1;
        System.out.println(findLength(str, k));
    }

}
