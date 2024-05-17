package com.datastructures.arrays;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FindUnion {
    List<Integer> list = new LinkedList<>();
    public List<Integer> findUnion(int nums1[], int nums2[])
    {

        int n1 = nums1.length;
        int n2 = nums2.length;

        int i=0 ,j=0;

        while(i<n1 && j<n2)
        {
            if(nums1[i] < nums2[j])
            {
                if(list.isEmpty() || !list.contains(nums1[i]))
                {
                    list.add(nums1[i]);
                }
                i++;
            }
            else
            {
                if(list.isEmpty() || !list.contains(nums2[j]))
                {
                    list.add(nums2[j]);
                }
                j++;
            }
        }

        while(i<n1)
        {
            if(list.isEmpty() || !list.contains(nums1[i]))
            {
                list.add(nums1[i]);
            }
            i++;
        }

        while(j<n2)
        {
            if(list.isEmpty() || !list.contains(nums2[j]))
            {
                list.add(nums2[j]);
            }
            j++;
        }

        return list;

    }

    public static void main(String args[])
    {
        int nums1[] = {1, 2, 3, 4, 5};
        int nums2[] = {1, 2, 3, 6, 7};

        FindUnion fu = new FindUnion();
        System.out.println(fu.findUnion(nums1, nums2));

    }

}
