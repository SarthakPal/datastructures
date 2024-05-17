package com.datastructures.arrays;

public class FirstMissingPositive {

        public int firstMissingPositive(int[] nums) {
            int n = nums.length;

            if(n==1 && nums[0]==1)
            {
                return 2;
            }

            for(int i=0;i<n;i++)
            {
                if(nums[i]<=0)
                {
                    nums[i] = n+2;
                }
            }

            for(int j=0;j<n;j++)
            {
                int val  = Math.abs(nums[j])-1;
                if(val<n)
                {
                    nums[val] = (-1) * Math.abs(nums[val]);
                }
            }

            for(int k=0;k<n;k++)
            {
                if(nums[k]>0)
                {
                    return k+1;
                }
            }

            return n+1;

        }

        public int firstMissingUsingSummation(int[] nums)
        {
            int n = nums.length;
            int sum = n * (n+1) / 2;
            for(int i=0;i<n;i++)
            {
                sum = sum - nums[i];
            }
            return sum;
        }

        public int firstMissingUsingXOR(int[] nums)
        {
            int n = nums.length;
            int xor = 0;
            for(int i=0;i<=n;i++)
            {
                xor = xor^i;
            }
            for(int i=0;i<n;i++)
            {
                xor = xor^nums[i];
            }
            return xor;
        }

}


