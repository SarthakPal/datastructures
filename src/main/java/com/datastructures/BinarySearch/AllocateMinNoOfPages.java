package com.datastructures.BinarySearch;

public class AllocateMinNoOfPages {

    public boolean isValid(int nums[], int max, int k)
    {
        int students = 1;
        int sum = 0;
        for(int i=0;i<nums.length;i++)
        {
            sum = sum + nums[i];
            if(sum>max)
            {
                students++;
                sum = nums[i];
            }
            if(students>k)
            {
                return false;
            }
        }
        return true;
    }

    public int totalSum(int nums[])
    {
        int res = 0;
        for(int i=0;i<nums.length;i++)
        {
            res+=nums[i];
        }
        return res;
    }

    public int findMin(int nums[], int k)
    {
        int n =nums.length;
        if(n<k) // if number of students is more than number of books  then return -1;
        {
            return -1;
        }
        int start = nums[nums.length-1];
        int end = totalSum(nums);

        int res = -1;

        /*Case 1: When no valid answer exists.
        If the number of students is greater than the number of books (i.e, M > N),
        In this case at least 1 student will be left to which no book has been assigned. So we retuen -1.

        Case 2: When a valid answer exists.
        The maximum possible answer could be when there is only one student. So, all the book will be assigned
        to him and the result would be the sum of pages of all the books.

        The minimum possible answer could be when number of student is equal to the number of book (i.e, M == N) ,
        In this case all the students will get at most one book. So, the result would be the maximum number of pages
        among them (i.e, maximum(pages[])).

        Hence, we can apply binary search in this given range and each time we can consider the mid value as the
        maximum limit of pages one can get. And check for the limit if answer is valid then update the limit accordingly.*/

        while(start<=end)
        {
            int mid = start + (end - start)/2;
            if(isValid(nums, mid, k))
            {
                res = mid;
                end = mid -1;
            }
            else {
                start = mid +1;
            }

        }

        return res;

    }
}
