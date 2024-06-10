package com.datastructures.arrays;

import java.util.ArrayList;
import java.util.List;

public class PositiveNegativeAlternative {

    // equal number positive-negatives are present
    // TC : O(n+n/2)
    // SC : O(n/2+n/2) = O(n)
     public int[] rearrangeOne(int nums[])
     {
         int n = nums.length;

         List<Integer> positive = new ArrayList<>();
         List<Integer> negative = new ArrayList<>();

         for(int i=0;i<n;i++)
         {
             if(nums[i]>0)
             {
                 positive.add(nums[i]);
             }
             else
             {
                 negative.add(nums[i]);
             }
         }

         for(int i=0;i<n/2;i++)
         {
            nums[2*i] = positive.get(i);
             nums[2*i+1] = negative.get(i);
         }

         return nums;
     }

    // positive-negatives are equal
    // TC : O(n)
    // SC : O(n/2+n/2) = O(n)
     public int[] rearrangeTwo(int nums[])
     {
         int n = nums.length;

         int posIdx = 0;
         int negIdx = 1;

         int res[] = new int[n];

         for(int i=0;i<n;i++)
         {
             if(nums[i]>0)
             {
                 res[posIdx] = nums[i];
                 posIdx+=2;
             }
             else {
                 res[negIdx] = nums[i];
                 negIdx+=2;
             }
         }

         return res;
     }

     // what if positive-negatives are not equal
    // TC : O(n)
    // SC : O(n/2+n/2) = O(n)
    public int[] rearrangeThree(int nums[])
    {
        int n = nums.length;

        int res[] = new int[n];

        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();

        for(int i=0;i<n;i++)
        {
            if(nums[i]>0)
            {
                positive.add(nums[i]);
            }
            else
            {
                negative.add(nums[i]);
            }
        }

        if(positive.size() < negative.size())
        {
            for(int i=0;i<positive.size();i++)
            {
                res[2*i] = positive.get(i);
                res[2*i+1] = negative.get(i);
            }
            int idx = positive.size()*2;
            for(int i=positive.size();i<negative.size();i++)
            {
                res[idx++] = negative.get(i);
            }
        }

        else {
            for(int i=0;i<negative.size();i++)
            {
                res[2*i] = positive.get(i);
                res[2*i+1] = negative.get(i);
            }
            int idx = negative.size()*2;
            for(int i=negative.size();i<positive.size();i++)
            {
                res[idx++] = positive.get(i);
            }
        }

        return res;

    }

}
