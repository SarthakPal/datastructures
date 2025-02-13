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

    // first we will store positives and negatives in a separate list
    // and which ever list is small first we will store it and then store the remaining elements of the other list
    // to insert the elements we will start loop from 0 to smallest list size - 1
    // and the index will be 2*i and 2*i+1 i.e. we will place elements at (0,1) (2,3) (4,5) like this
    // once the loop ends we will calculate the index to place the rest of the elements and
    // index will be size of the smallest list multiply by 2 because we have inserted both positive and negative elements so count is double
    // now again the loop starts from the smallest size list and goes till largest list size
    // and we will insert the remaining elements.
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
