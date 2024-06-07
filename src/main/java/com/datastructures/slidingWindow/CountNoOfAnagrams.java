package com.datastructures.slidingWindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountNoOfAnagrams {

    public static boolean isAnagram(String a, String b) {
        Map<Character, Integer> mp = new HashMap<>();

        for (int i = 0; i < a.length(); i++) {
            Character c = a.charAt(i);
            mp.put(c, mp.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < b.length(); i++) {
            Character c = b.charAt(i);
            if (!mp.containsKey(c) || mp.get(c) == 0) {
                return false;
            }
        }
        return true;
    }

    public static int countOfAnagrams(String text, String word) {
        int textLength = text.length();
        int wordLength = word.length();
        int count = 0;
        for (int i = 0; i <= textLength - wordLength; i++) {
            if (isAnagram(word, text.substring(i, i + wordLength))) {
                count++;
            }
        }
        return count;
    }

    public static int countAnagrams(String s, String p) {
        // change CHARACTERS to support range of supported
        // characters
        int CHARACTERS = 256;
        int sn = s.length();
        int pn = p.length();
        int count = 0;
        if (sn < 0 || pn < 0 || sn < pn)
            return 0;

        char[] pArr = new char[CHARACTERS];
        char[] sArr = new char[CHARACTERS];
        int i = 0;
        // till window size
        for (; i < pn; i++) {
            sArr[CHARACTERS - s.charAt(i)]++;
            pArr[CHARACTERS - p.charAt(i)]++;
        }
        if (Arrays.equals(pArr, sArr))
            count += 1;
        // next window
        for (; i < sn; i++) {
            sArr[CHARACTERS - s.charAt(i)]++;
            sArr[CHARACTERS - s.charAt(i - pn)]--;

            if (Arrays.equals(pArr, sArr))
                count += 1;
        }
        return count;

    }


    public static void main(String[] args) {
        String text = "forxxorfxdofr";
        String word = "for";

        System.out.println(countOfAnagrams(text, word));
    }


}
