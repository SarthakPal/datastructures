package com.datastructures.arrays;

public class MaximumSubArrayKadane {

        public int maxSubArray(int[] nums) {

            int sum = 0;
            int max_sum = Integer.MIN_VALUE;

            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                if (sum > max_sum) {
                    max_sum = sum;
                }
                if (sum < 0) {
                    sum = 0;
                }
            }
            return max_sum;
        }

    public int maxSubArrayPrintElements(int[] nums) {

        int sum = 0;
        int max_sum = Integer.MIN_VALUE;

        int ans_start = -1;
        int ans_end = -1;
        int start = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > max_sum) {
                max_sum = sum;
                ans_start = start;
                ans_end = i;
            }
            if (sum < 0) {
                sum = 0;
                start = i+1;
            }
        }

        if(sum!=0)
        {
            for(int x=ans_start;x<=ans_end;x++)
            {
                System.out.print(nums[x]+" ");
            }
        }

        return max_sum;
    }

    public static void main(String args[])
    {
        int nums[] = {5, -15, 25, 35};
        MaximumSubArrayKadane maximumSubArrayKadane = new MaximumSubArrayKadane();
        maximumSubArrayKadane.maxSubArrayPrintElements(nums);

    }


}
