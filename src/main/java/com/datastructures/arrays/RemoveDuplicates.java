package com.datastructures.arrays;

public class RemoveDuplicates {
        public int removeDuplicates(int[] nums) {

            int n = nums.length;

            int i , j = 0;

            for(i=0;i<n-1;i++)
            {
                if(nums[i] != nums[i+1])
                {
                    nums[j++] = nums[i];
                }
            }
            nums[j++] = nums[i];
            return j;

        }

}
