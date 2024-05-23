package com.datastructures.BinarySearch;

public class SearchIn2DMatrix {
    class Solution {
        public boolean searchMatrix(int[][] mat, int target) {
            int rows = mat.length;
            int cols = mat[0].length;

            int i=0;
            int j=cols - 1;

            while(i<rows && j>=0)
            {
                if(mat[i][j] == target)
                {
                    return true;
                }
                else if(mat[i][j]<target)
                {
                    i++;
                }
                else
                {
                    j--;
                }
            }

            return false;
        }

    }
}
