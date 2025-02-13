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

            // if we have to rotate left side then make k = size - k;

            int size = arr.length;
            k=k%size; // if k is greater than k, we have to do modulo.

            if(size<k) return;

            rotate(arr,0,size-1);
            rotate(arr,0,k-1);
            rotate(arr,k,size-1);

        }

        public static void main(String args[])
        {
            int arr[] = {1, 2, 3, 4, 5};
            RotateAnArray rotateAnArray = new RotateAnArray();
            rotateAnArray.rotate(arr, 1);
            for(int i=0;i<arr.length;i++)
            {
                System.out.println(arr[i]+" ");
            }

        }

}
