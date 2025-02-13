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

    /*Two important properties of XOR are the following:

    XOR of two same numbers is always 0 i.e. a ^ a = 0. ←Property 1.
    XOR of a number with 0 will result in the number itself i.e. 0 ^ a = a.  ←Property 2

    Now, let’s XOR all the numbers between 1 to N.
    xor1 = 1^2^.......^N

    Let’s XOR all the numbers in the given array.
            xor2 = 1^2^......^N (contains all the numbers except the missing one).

    Now, if we again perform XOR between xor1 and xor2, we will get:
    xor1 ^ xor2 = (1^1)^(2^2)^........^(missing Number)^.....^(N^N)

    Here all the numbers except the missing number will form a pair and each pair will result in 0 according to the XOR property. The result will be = 0 ^ (missing number) = missing number (according to property 2).*/

    /*Assume the given array is: {1, 2, 4, 5} and N = 5.
    XOR of (1 to 5) i.e. xor1 = (1^2^3^4^5)
    XOR of array elements i.e. xor2 = (1^2^4^5)
    XOR of xor1 and xor2 = (1^2^3^4^5) ^ (1^2^4^5)
            = (1^1)^(2^2)^(3)^(4^4)^(5^5)
            = 0^0^3^0^0 = 0^3 = 3.
    The missing number is 3.*/

        public int firstMissingUsingXOR(int[] nums, int n)
        {
            int xor1 = 0, xor2 = 0;
            for(int i=1;i<=n;i++)
            {
                xor1 = xor1^i;
            }
            for(int i=0;i<nums.length;i++)
            {
                xor2 = xor2^nums[i];
            }
            return xor1^xor2;
        }

        public static void main(String args[])
        {
            int arr[] = {1, 2, 4};

            int n = 4;

            FirstMissingPositive firstMissingPositive = new FirstMissingPositive();

            System.out.println(firstMissingPositive.firstMissingUsingXOR(arr, n));

        }

}


