package com.datastructures.slidingWindow;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingChars {

    // abcdaef till we didn't found the repeating character we will keep traversing and calculating the length
    // and keep inserting it in the hashmap character and its index but if we found the repeating index we are
    // calculating the l also because if the string is "abba" so when we find 2nd b, l should become prev index of b + 1
    // because prev value of l is zero. But when we find the 2nd a l should not become prev index of a + 1 because
    // again the l will go into the left direction which is wrong.

    public int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> mp = new HashMap<>();
        int len = 0;
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            if (mp.containsKey(s.charAt(r))) {
                l = Math.max(mp.get(s.charAt(r)) + 1, l);
            }
            mp.put(s.charAt(r), r);

            len = Math.max(r - l + 1, len);
        }
        return len;
    }

}
