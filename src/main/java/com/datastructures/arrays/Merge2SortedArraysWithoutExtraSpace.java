package com.datastructures.arrays;

public class Merge2SortedArraysWithoutExtraSpace {

    public static void swapIfGreater(int[] arr1, int[] arr2, int ind1, int ind2) {
        if (arr1[ind1] > arr2[ind2]) {
            int temp = arr1[ind1];
            arr1[ind1] = arr2[ind2];
            arr2[ind2] = temp;
        }
    }

    // GAP Theorem
    // arr1 : [1, 3, 5, 7]
    // arr2 : [0, 2, 8, 6, 9]
    // we will take a variable named as gap and assign it ceil value of len/2 if len is 9 then gap will be 5
    // then we will take left and right and if left > right then we will swap it and we will go till right<len
    // again we calculate gap and again do the same process till gap>0

    // Time Complexity: O((n+m)*log(n+m)), where n and m are the sizes of the given arrays.
    // Reason: The gap is ranging from n+m to 1 and every time the gap gets divided by 2.
    // So, the time complexity of the outer loop will be O(log(n+m)). Now, for each value of the gap,
    // the inner loop can at most run for (n+m) times. So, the time complexity of the inner loop will be O(n+m).
    // So, the overall time complexity will be O((n+m)*log(n+m)).
    // Space Complexity: O(1) as we are not using any extra space.

    public void merge(int[] arr1, int n, int[] arr2, int m) {

        // len of the imaginary single array:
        int len = n + m;

        // Initial gap:
        int gap = (len / 2) + (len % 2);

        while (gap > 0) {
            // Place 2 pointers:
            int left = 0;
            int right = left + gap;
            while (right < len) {
                // case 1: left in arr1[]
                //and right in arr2[]:
                if (left < n && right >= n) {
                    swapIfGreater(arr1, arr2, left, right - n);
                }
                // case 2: both pointers in arr2[]:
                else if (left >= n) {
                    swapIfGreater(arr2, arr2, left - n, right - n);
                }
                // case 3: both pointers in arr1[]:
                else {
                    swapIfGreater(arr1, arr1, left, right);
                }
                left++;
                right++;
            }
            // break if iteration gap=1 is completed:
            if (gap == 1) break;

            // Otherwise, calculate new gap:
            gap = (gap / 2) + (gap % 2);
        }
        int idx = n;
        for (int i = 0; i < m; i++) {
            arr1[n] = arr2[i];
            n++;
        }
    }


}
