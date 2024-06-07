package com.datastructures.slidingWindow;

import java.util.HashMap;
import java.util.Map;

// longest consecutive sequence with atmost 2 distinct numbers
public class FruitsInBasket {
    public int totalFruit(int[] fruits) {

        int n = fruits.length;
        int left = 0;
        int right = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        int max = 0;

        for (right = 0; right < n; right++) {
            mp.put(fruits[right], mp.getOrDefault(fruits[right], 0) + 1);

            while (mp.size() > 2) {
                if (mp.get(fruits[left]) == 1) {
                    mp.remove(fruits[left]);
                } else {
                    mp.put(fruits[left], mp.get(fruits[left]) - 1);
                }
                left++;
            }

            max = Math.max(max, right - left + 1);

        }
        return max;
    }

}
