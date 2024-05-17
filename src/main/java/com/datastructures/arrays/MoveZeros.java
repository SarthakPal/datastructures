package com.datastructures.arrays;

public class MoveZeros {
        public void moveZeroes(int[] nums) {
            int index = 0;
            int n = nums.length;
            int count = 0;
            for(int i=0;i<n;i++)
            {
                if(nums[i]==0)
                {
                    count++;
                }
                else
                {
                    nums[index++] = nums[i];
                }
            }
            for(int i=0;i<count;i++)
            {
                nums[index++] = 0;
            }
        }
}
