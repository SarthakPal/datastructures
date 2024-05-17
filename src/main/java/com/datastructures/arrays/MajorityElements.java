package com.datastructures.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MajorityElements {

    // > n/2
    public int majorityElement(int[] nums) {

        int count = 0;
        int curr_max = 0;

        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                curr_max = nums[i];
                count++;
            } else if (nums[i] == curr_max) {
                count++;
            } else {
                count--;
            }
        }
        return curr_max;
    }

    // > n/3

    public List<Integer> majorityElementMoreThan3(int[] nums) {

        int count1 = 0;
        int count2 = 0;

        int element1 = -1;
        int element2 = -1;

        for (int i = 0; i < nums.length; i++) {
            if (count1 == 0 && nums[i] != element2) {
                element1 = nums[i];
                count1++;
            } else if (count2 == 0 && nums[i] != element1) {
                element2 = nums[i];
                count2++;
            } else if (element1 == nums[i]) {
                count1++;
            } else if (element2 == nums[i]) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        List<Integer> list = new ArrayList<>();

        count1 = 0;
        count2 = 0;

        int times = nums.length / 3 + 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == element1) {
                count1++;
            } else if (nums[i] == element2) {
                count2++;
            }
        }

        if (count1 >= times) {
            list.add(element1);
        }
        if (count2 >= times) {
            list.add(element2);
        }

        Collections.sort(list);
        return list;
    }

}
