package com.datastructures.arrays;

public class FindDuplicateAndMissingNumber {

    public static void findDuplicateAndMissing(int nums[])
    {
        int n = nums.length;
        for(int i=0;i<n;i++)
        {
            int idx = Math.abs(nums[i]) - 1;
            if(nums[idx]>0)
            {
                nums[idx] = (-1)*(nums[idx]);
            }
            else {
                System.out.println("Repeated No : "+ (idx+1));
            }
        }

        for(int i=0;i<n;i++)
        {
            if(nums[i]>0)
            {
                System.out.println("Repeated No : "+ (i+1));
            }
        }

    }

    public static void main(String args[])
    {
        int nums[] = {1, 2, 3, 4, 4};
        findDuplicateAndMissing(nums);
    }

}
