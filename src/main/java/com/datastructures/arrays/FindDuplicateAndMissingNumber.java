package com.datastructures.arrays;

public class FindDuplicateAndMissingNumber {

    /*Example 1:
    Input Format :  array[] = {3,1,2,5,3}
    Result : {3,4)

    Explanation : A = 3 , B = 4
    Since 3 is appearing twice and 4 is missing*/

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
                System.out.println("Missing No : "+ (i+1));
            }
        }

    }

    public static void main(String args[])
    {
        int nums[] = {1, 2, 3, 4, 4};
        findDuplicateAndMissing(nums);
    }

}
