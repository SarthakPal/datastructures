package com.datastructures.arrays;

import java.util.*;
public class ThreeSum {

    //TC : O(nlogn) + O(n^2)
    //SC : O(n)
    public List<List<Integer>> threeSumUsingSet(int[] nums) {

        Arrays.sort(nums);

        int n = nums.length;

        Set<List<Integer>> st = new HashSet<>();

        for(int i=0;i<n-2;i++)
        {
            int left = i+1;
            int right = n-1;
            while(left<right)
            {
                int sum = nums[i]+nums[left]+nums[right];
                if(sum==0)
                {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    st.add(temp);
                    left++;
                    right--;
                }
                else if(sum<0)
                {
                    left++;
                }
                else
                {
                    right--;
                }
            }
        }
        return new ArrayList<>(st);
    }

    //TC : O(nlogn) + O(n^2)
    //SC : O(1)
    public List<List<Integer>> threeSumWithoutSet(int[] nums) {

        Arrays.sort(nums);

        int n = nums.length;

        Set<List<Integer>> st = new HashSet<>();

        for(int i=0;i<n-2;i++)
        {
            int left = i+1;
            int right = n-1;
            while(left<right)
            {
                int sum = nums[i]+nums[left]+nums[right];
                if(sum==0)
                {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    st.add(temp);
                    left++;
                    right--;
                    while(left<right && nums[left]==nums[left-1])
                    {
                        left++;
                    }
                    while(left<right && nums[right]==nums[right+1])
                    {
                        right--;
                    }
                }
                else if(sum<0)
                {
                    left++;
                }
                else
                {
                    right--;
                }
            }
        }
        return new ArrayList<>(st);
    }



}
