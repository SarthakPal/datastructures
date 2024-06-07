package com.datastructures.slidingWindow;

import java.util.LinkedList;

public class FirstNegativeInWindow {

    public static void printFirstNegativeInteger(int nums[], int k)
    {

        int n = nums.length;
        LinkedList<Integer> queue = new LinkedList<>();

        for(int i=0;i<k;i++)
        {
            if(nums[i]<0)
            {
                queue.add(i);
            }
        }

        System.out.println(nums[queue.peek()]);

        for(int i=k;i<n;i++)
        {
            if(nums[i]<0)
            {
                queue.add(i);
            }

            while(!queue.isEmpty() && queue.peek()<(i-k+1))
            {
                queue.remove();
            }

            if(queue.isEmpty())
            {
                System.out.println(0);
            }
            else
            {
                System.out.println(nums[queue.peek()]);
            }
        }

    }

    public static void main(String[] args)
    {
        int arr[] = {12, -1, -7, 8, -15, 30, 16, 28};
        int n = arr.length;
        int k = 3;
        printFirstNegativeInteger(arr, k);
    }

}
