package com.datastructures.arrays;

import java.util.ArrayList;
import java.util.List;

public class CountInversions {

/*                                           [5, 3, 2, 4,1]
                                                   /  \
                                                  /    \
                                          [5, 3, 2]      [4, 1]
                                            /   \           / \
                                           /     \         /   \
                                        [5,3]   [2]       [4]   [1]
                                         / \
                                        /   \
                                     [5]    [3]

if we keep diving the array so the final sub arrays will look like this. Now we will start merging and while merge
we need to check
if left is greater than the right part then we will increase our count with the total number of elements present in
left part from the current index.

so here 5>3 so we will increase our counter with +1 and while going upwards we will sort the subarrays and merge them too.
so the new sub array will become [3,5]

                                            [5, 3, 2, 4,1]
                                                   /  \
                                                  /    \
                                          [5, 3, 2]      [4, 1]
                                            /   \           / \
                                           /     \         /   \
                                   {3,5} [5,3]   [2]       [4]   [1]
                                         / \
                                        /   \
                                     [5]    [3]


now the right part is [2] this is the single element so no change noe the left array is [3,5] and [2].
here the 3>2 so we will increase the count with +2 because 5 is also greater than 2 and now we will do right++
now the size is reached iun right part we will stop and merge so the new subarray will become {2,3,5}

similarly in the right part 4>1 so we will increase the count with +1 and while going forward it will become [1,4]


                                                [5, 3, 2, 4,1]
                                                   /       \
                                                  /         \
                                    {2,3,5} [5, 3, 2]        [4, 1] {1, 4}
                                            /   \             / \
                                           /     \           /   \
                                   {3,5} [5,3]   [2] {2}   [4]   [1]
                                         / \
                                        /   \
                                     [5]    [3]


Now the new left sub array is [2,3,5] and [1,4] so left is at 2 and right is at 1 so 2>1 we will increase counter with
+3 as (2,3,5) everyone is greater than 1. now the right will shift to 4 now 2<4 so left move to 3 and 3<4 left move to 5
now 5>4 so increase counter with +1 and while merging the new array will become [1,2,3,4,5]

                                                 [5, 3, 2, 4,1] {1,2,3,4,5}
                                                   /       \
                                                  /         \
                                    {2,3,5} [5, 3, 2]        [4, 1] {1, 4}
                                            /   \             / \
                                           /     \           /   \
                                   {3,5} [5,3]   [2] {2}   [4]   [1]
                                         / \
                                        /   \
                                     [5]    [3]


 */

    /*Time Complexity: O(N*logN), where N = size of the given array.
            Reason: We are not changing the merge sort algorithm except by adding a variable to it. So, the time complexity is as same as the merge sort.

    Space Complexity: O(N), as in the merge sort We use a temporary array to store elements in sorted order.*/
    public static int merge(int arr[], int low, int mid, int high)
    {
        int count = 0;
        List<Integer> list = new ArrayList<>();
        int left = low;
        int right = mid + 1;
        while(left<=mid && right<=high)
        {
            if(arr[left]<=arr[right])
            {
                list.add(arr[left]);
                left++;
            }
            else {
                list.add(arr[right]);
                count+=(mid-left+1);
                right++;
            }
        }
        while(left<=mid)
        {
            list.add(arr[left]);
            left++;
        }
        while(right<=high)
        {
            list.add(arr[right]);
            right++;
        }
        for(int i=low;i<=high;i++)
        {
            arr[i] = list.get(i-low);
        }
        return count;
    }

    public static int numberOfInversions(int nums[], int low, int high)
    {
        int count=0;
        if(low>=high)
        {
            return count;
        }
        int mid = (low+high)/2;
        count+=numberOfInversions(nums, low, mid);
        count+=numberOfInversions(nums, mid+1, high);
        count+=merge(nums, low, mid, high);
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};
        int n = 5;
        int cnt = numberOfInversions(nums, 0, n-1);
        System.out.println("The number of inversions are: " + cnt);
    }

}
