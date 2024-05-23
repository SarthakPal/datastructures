package com.datastructures.BinarySearch;

public class MedianOfTwoSortedArrays {

    // there is an array1 [0, 2, 3, 8] and array2 [1, 4, 5, 7, 9] and we know median will be middle element
    // of the sorted array. so the sorted array will be [0, 1, 2, 3, 4, 5, 7, 8,9] and median is 4. so before
    // 4 there will be 4 elements and after 4 there will be 4 elements as size is 9(4+4+1).
    // so we can take two pointers one at array1[0] and another at array2[0] and will eliminate first 4 smaller elements
    // but the time complexity will be O(n+m) where n and m the respective sizes of arrays.

    // so to reduce time complexity we will apply binary search on the smaller size array. we will do partition at the
    // middle element and check if this partition will work or not.
    // in the [0, 2, 3, 8] mid is at 2. so the partition will be like
    // [0, 2, | 3, 8]
    // [1, 4, 5, |  7, 9]
    // here 2<7 but 5>3 which is wrong so we need to shift in the right direction in array1 to get the greater element
    // after partition index. we will do low = mid + 1 so now the partition will be
    // [0, 2, 3, | 8]
    // [1, 4, | 5, 7, 9]
    // here 3<7 and 4<8  so this is the correct partition and the median will be 4.

    // Time Complexity: O(log(min(n1,n2))), where n1 and n2 are the sizes of two given arrays.
    // Reason: We are applying binary search on the range [0, min(n1, n2)].
    // Space Complexity: O(1) as no extra space is used.


    public double finMedianUtil(int[] nums1, int n, int[] nums2, int m) {
        int low = 0;
        int high = n;

        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (n + m + 1) / 2 - partitionX;

            int maxLeftX = partitionX == 0 ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = partitionX == n ? Integer.MAX_VALUE : nums1[partitionX];

            int maxLeftY = partitionY == 0 ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = partitionY == m ? Integer.MAX_VALUE : nums2[partitionY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((n + m) % 2 == 0) {
                    return ((Math.max(maxLeftX, maxLeftY) + (double) (Math.min(minRightX, minRightY))) / 2);
                } else {
                    return (Math.max(maxLeftX, maxLeftY));
                }
            } else if (maxLeftX > minRightY) {
                high = partitionX - 1;
            } else {
                low = partitionX + 1;
            }
        }
        return 0;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        if (n < m) {
            return finMedianUtil(nums1, n, nums2, m);
        } else {
            return finMedianUtil(nums2, m, nums1, n);
        }
    }


}
