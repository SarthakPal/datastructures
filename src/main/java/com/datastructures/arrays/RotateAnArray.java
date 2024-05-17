package com.datastructures.arrays;

public class RotateAnArray {

        public void rotate(int arr[], int start, int end)
        {
            while(start<=end)
            {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }

        public void rotate(int[] arr, int k) {

            int size = arr.length;
            k=k%size;

            if(size<k) return;

            rotate(arr,0,size-1);
            rotate(arr,0,k-1);
            rotate(arr,k,size-1);

        }

}
