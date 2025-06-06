package com.datastructures.arrays;

import java.util.*;

// Problem Statement: Given an array, print all the elements which are leaders.
// A Leader is an element that is greater than all of the elements on its right side in the array.

public class LeadersInArray {

    /*Time Complexity: O(N) { Since the array is traversed single time back to front,
    it will consume O(N) of time where N = size of the array }.

    Space Complexity: O(N) { There is no extra space being used in this approach. But, a O(N) of space for ans
    array will be used in the worst case }.*/
    public static ArrayList<Integer>
    printLeadersBruteForce(int[] arr, int n) {

        ArrayList<Integer> ans = new ArrayList<>();

        // Last element of an array is always a leader,
        // push into ans array.
        int max = arr[n - 1];

        ans.add(arr[n - 1]);

        // Start checking from the end whether a number is greater
        // than max no. from right, hence leader.
        for (int i = n - 2; i >= 0; i--)
            if (arr[i] > max) {
                ans.add(arr[i]);
                max = arr[i];
            }

        return ans;

    }

    public static void main(String args[]) {
        // Array Initialization.
        int n = 6;
        int arr[] = {10, 22, 12, 3, 0, 6};


        ArrayList<Integer> ans = printLeadersBruteForce(arr, n);

        Collections.sort(ans, Collections.reverseOrder());

        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }

    }


}
