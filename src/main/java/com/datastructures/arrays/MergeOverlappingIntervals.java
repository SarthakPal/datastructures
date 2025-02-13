package com.datastructures.arrays;

import java.util.*;

public class MergeOverlappingIntervals {

//    Time Complexity: O(N*logN) + O(N), where N = the size of the given array.
//    Reason: Sorting the given array takes  O(N*logN) time complexity. Now, after that, we are just using a single loop that runs for N times. So, the time complexity will be O(N).
//
//    Space Complexity: O(N), as we are using an answer list to store the merged intervals. Except for the answer array, we are not using any extra space.

    public static List<List<Integer>> mergeOverlappingIntervals(int[][] arr) {
        int n = arr.length; // size of the array
        //sort the given intervals based upon the first element of every interval.
        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            // if the current interval does not
            // lie in the last interval: if the current interval is [8,10] and the last interval present in resultant
            // list [1,3] then these are 2 separate intervals
            // and we have to add curent interval as it is.
            if (ans.isEmpty() || arr[i][0] > ans.get(ans.size() - 1).get(1)) {
                ans.add(Arrays.asList(arr[i][0], arr[i][1]));
            }
            // if the current interval
            // lies in the last interval: if the current interval is [2,6] and the last interval present in resultant
            // list is [1,3] then we can perform merging we have to compare the last element of both the intervals
            // i.e. 3 and 6 which ever is greater we have to set it at the 1st index i.e. the last element of the interval.
            else {
                ans.get(ans.size() - 1).set(1,
                        Math.max(ans.get(ans.size() - 1).get(1), arr[i][1]));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 3}, {8, 10}, {2, 6}, {15, 18}};
        List<List<Integer>> ans = mergeOverlappingIntervals(arr);
        System.out.print("The merged intervals are: \n");
        for (List<Integer> it : ans) {
            System.out.print("[" + it.get(0) + ", " + it.get(1) + "] ");
        }
        System.out.println();
    }
}


