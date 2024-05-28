package com.datastructures.matrices;

public class RotateMatrixBy90 {

    public void rotate(int mat[][])
    {
        int rows = mat.length;
        int cols = mat[0].length;

        for(int i=0;i<rows;i++)
        {
            for(int j=i;j<cols;j++)
            {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        for(int i=0;i<rows;i++)
        {
            int left = 0;
            int right = cols-1;
            while(left<=right)
            {
                int temp = mat[i][left];
                mat[i][left] = mat[i][right];
                mat[i][right] = temp;
                left++;
                right--;
            }
        }
    }

}
