package com.datastructures.arrays;

/*Given an array nums, return true if the array was originally sorted in non-decreasing order, then rotated some
 number of positions (including zero). Otherwise, return false.

        There may be duplicates in the original array.

        Note: An array A rotated by x positions results in an array B of the same length such that
        A[i] == B[(i+x) % A.length], where % is the modulo operation.

        Example 1:

        Input: nums = [3,4,5,1,2]
        Output: true
        Explanation: [1,2,3,4,5] is the original sorted array.
        You can rotate the array by x = 3 positions to begin on the the element of value 3: [3,4,5,1,2].
        Example 2:

        Input: nums = [2,1,3,4]
        Output: false
        Explanation: There is no sorted array once rotated that can make nums.
        Example 3:

        Input: nums = [1,2,3]
        Output: true
        Explanation: [1,2,3] is the original sorted array.
        You can rotate the array by x = 0 positions (i.e. no rotation) to make nums.*/

public class CheckArrayIsSorted {

    public boolean check(int[] nums) {
        int count = 0;
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] > nums[i]) {
                count++;
            }
        }
        if (nums[n - 1] > nums[0]) {
            count++;
        }
        return count <= 1;
    }

    /*We compare consecutive pairs:

        2>1? → yes, so count = 1
        1>3? → no
        3>4? → no
    So far, count = 1
    If we did not check the boundary between nums[n-1] and nums[0]:

    We would stop here and see only one “drop” (where 2 > 1).
    We might incorrectly conclude count ≤ 1
    count≤1 ⇒ return true.

    With the boundary check:

    Compare nums[3] (which is 4) and nums[0] (which is 2).
            4>2? → yes, that is another descending “wrap-around” drop.
    So count becomes 2, and thus count > 1 ⇒ return false.*/

}
