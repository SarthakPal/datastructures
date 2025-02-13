package com.datastructures.arrays;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public int[] twoSumBruteForce(int[] nums, int target) {

        int n = nums.length;

        int res[] = new int[2];

        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                if(nums[i]+nums[j]==target)
                {
                    res[0] = i;
                    res[1] = j;
                    break;
                }
            }
        }
        return res;
    }

    /*Time Complexity: O(N)

    Space Complexity: O(N)*/
    public static int[] twoSumUsingHashing(int n, int []arr, int target) {
        int[] ans = new int[2];
        ans[0] = ans[1] = -1;
        HashMap<Integer, Integer> mpp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            int moreNeeded = target - num;
            if (mpp.containsKey(moreNeeded)) {
                ans[0] = mpp.get(moreNeeded);
                ans[1] = i;
                return ans;
            }

            mpp.put(arr[i], i);
        }
        return ans;
    }


    /*Time Complexity: O(N) + O(N*logN), where N = size of the array.
    Reason: The loop will run at most N times. And sorting the array will take N*logN time complexity.

    Space Complexity: O(1) as we are not using any extra space.*/
    public int[] twoSumUsingSorting(int nums[], int target)
    {
        int res[] = new int[2];

        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;

        while(left < right)
        {
            if(nums[left]+nums[right]==target)
            {
                res[0] = left;
                res[1] = right;
                break;
            }
            else if(nums[left]+nums[right]<target)
            {
                left++;
            }
            else
            {
                right--;
            }
        }

        return res;
    }

    public static void main(String args[])
    {
        TwoSum ts = new TwoSum();
        int nums[] = {3, 2, 4};
        ts.twoSumUsingSorting(nums, 6);
    }

}
