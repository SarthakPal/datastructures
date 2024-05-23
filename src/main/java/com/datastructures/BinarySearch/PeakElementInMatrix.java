package com.datastructures.BinarySearch;

public class PeakElementInMatrix {

    public int findMaxInCol(int mat[][], int col) {
        int row = 0;
        int rows = mat.length;
        int max = mat[0][col];
        for (int i = 1; i < rows; i++) {
            if (mat[i][col] > max) {
                max = mat[i][col];
                row = i;
            }
        }
        return row;
    }

    // we will take low as 0 and high as cols-1 and then apply binary search then mid  will be our col and
    // in that col we will find the max element and its row no then for tat row we will check if it is greater
    // than its left and right if it si then it is the result otheriwse will go on left or right side depend on
    // which side element is greater.
    public int[] findPeakGrid(int[][] mat) {

        int rows = mat.length;
        int cols = mat[0].length;

        int low = 0;
        int high = cols - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int row = findMaxInCol(mat, mid);

            int left = mid - 1 >= 0 ? mat[row][mid - 1] : -1;
            int right = mid + 1 < cols ? mat[row][mid + 1] : -1;

            if (mat[row][mid] > left && mat[row][mid] > right) {
                return new int[]{row, mid};
            } else if (mat[row][mid] < left) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return new int[]{-1, -1};

    }

}
