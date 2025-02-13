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

        List<List<Integer>> st = new ArrayList<>();

        for(int i=0;i<n-2;i++)
        {
            // Skip duplicate elements for the first number
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

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
        return st;
    }

    public static void main(String args[])
    {
        int nums[] = {-1,0,1,2,-1,-4};
        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> res = threeSum.threeSumWithoutSet(nums);

        for(int i=0;i<res.size();i++)
        {
            List<Integer> temp = res.get(i);
            for(int j=0;j<temp.size();j++)
            {
                System.out.print(temp.get(j)+" ");
            }
            System.out.println();
        }

    }



}
