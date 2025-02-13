package com.datastructures.matrices;

// Problem Statement: Given a matrix if an element in the matrix is 0 then you will have to set its entire column
// and row to 0 and then return the matrix.
public class SetMatrixZeroes {

    // we will traverse from (0,0) to (n,m) and if we find zero then we will make the first cell of that
    // row or column as zero and then again we will traverse over the array from (1,1) to (n,m) and we will
    // check if the first cell of that row or column is zero then we will make that cell as zero.
    // Reason for traversing from (1,1) is if there is zero present in either first row or first col
    // then it will make (0,0) as zero and if we start traversing from (0,0) it will make complete first row and
    // first col as zero and to resolve this we wil take two boolean variables which will be true if anu cell
    // of first row or first col is zero.

    public static void setZeroes(int[][] matrix)
    {
        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean firstRow = false;
        boolean firstCol = false;

        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                if(matrix[i][j]==0)
                {
                    if(i==0) firstRow = true;
                    if(j==0) firstCol = true;
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i=1;i<rows;i++)
        {
            for(int j=1;j<cols;j++)
            {
                if(matrix[i][0]==0 || matrix[0][j]==0)
                {
                    matrix[i][j] = 0;
                }
            }
        }

        if(firstRow==true)
        {
            for(int i=0;i<cols;i++)
            {
                matrix[0][i] = 0;
            }
        }

        if(firstCol==true)
        {
            for(int i=0;i<rows;i++)
            {
                matrix[i][0] = 0;
            }
        }

    }

    public static void main(String args[])
    {
        int matrix[][] = {{1,2,3,4},
                          {5,6,7,8},
                          {20,10,0,12},
                          {13, 14, 15, 16}};

        setZeroes(matrix);


    }

}
