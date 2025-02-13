package com.datastructures.arrays;

import java.util.Arrays;

public class Merge2SortedArraysWithoutExtraSpace {

    /*Time Complexity: O(n+m) + O(n+m), where n and m are the sizes of the given arrays.
    Reason: O(n+m) is for copying the elements from arr1[] and arr2[] to arr3[]. And another O(n+m) is for filling back the two given arrays from arr3[].

    Space Complexity: O(n+m) as we use an extra array of size n+m.*/
    public static void mergeUsingBruteForce(long[] arr1, long[] arr2, int n, int m) {

        long[] arr3 = new long[n+m];

        int i=0;
        int j=0;

        int index = 0;

        while(i<n && j<m)
        {
            if(arr1[i]<=arr2[j])
            {
                arr3[index] = arr1[i];
                index++;
                i++;
            }
            else if (arr1[i]>arr2[j])
            {
                arr3[index] = arr2[j];
                index++;
                j++;
            }
        }

        while(i<n)
        {
            arr3[index] = arr1[i];
            index++;
            i++;
        }

        while(j<m)
        {
            arr3[index] = arr2[j];
            index++;
            j++;
        }

        for(int k=0;k<n+m;k++)
        {
            if(k<n)
            {
               arr1[k] = arr3[k];
            }else{
                arr2[k-n] = arr3[k];
            }
        }

    }

    // We will start from the end of the first array and start of the second array. If the left index element is
    // greater than the right index of second array we will swap them and if it is not we will break the loop because
    // if the current left index element is not greater then the elements before this current left index element
    // will also not be greater because array is sorted and all the elements are smaller than the current index element.

    // for example arr1 : [1, 3, 5, 7] and arr2 : [0, 2, 8, 6, 9] so left is at 7 and right is at 0 7>0
    // we need to swap then left is at 5 and right is at 2 5>2 we need to swap but 3<8 so we will break
    // and after that arr will become [1, 3, 2, 0] and arr2 will become [7, 5, 8, 6, 9] and now we just need to sort them.
    // so it will become [0, 1, 2, 3] and [5, 6, 7, 8, 9]

    /*Time Complexity: O(min(n, m)) + O(n*logn) + O(m*logm), where n and m are the sizes of the given arrays.
    Reason: O(min(n, m)) is for swapping the array elements. And O(n*logn) and O(m*logm) are for sorting the two arrays.

    Space Complexity: O(1) as we are not using any extra space.*/

    public void merge(int[] arr1, int n, int[] arr2, int m)
    {
        int left = n-1;
        int right = 0;

        while(left>=0 && right<m)
        {
            if(arr1[left] > arr2[right])
            {
                int temp = arr1[left];
                arr1[left] = arr2[right];
                arr2[right] = temp;
                left--;
                right++;
            }
            else {
                break;
            }
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);

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

    public void mergeUsingGapTheorem(int[] arr1, int n, int[] arr2, int m) {

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

    public static void swapIfGreater(int[] arr1, int[] arr2, int ind1, int ind2) {
        if (arr1[ind1] > arr2[ind2]) {
            int temp = arr1[ind1];
            arr1[ind1] = arr2[ind2];
            arr2[ind2] = temp;
        }
    }


}
