package com.datastructures.matrices;

public class SpiralOrderMatrix {
        public int[][] generateMatrix(int A) {

            int rows = A;
            int cols = A;

            int res[][] = new int[rows][cols];

            int count = 1;

            int top = 0;
            int down = rows-1;
            int left = 0;
            int right = cols-1;

            int dir = 0;

            while(top<=down && left<=right)
            {
                if(dir==0)
                {
                    for(int i=left;i<=right;i++)
                    {
                        res[top][i] = count;
                        count++;
                    }
                    top++;
                }
                else if(dir==1)
                {
                    for(int j=top;j<=down;j++)
                    {
                        res[j][right] = count;
                        count++;
                    }
                    right--;
                }
                else if(dir==2)
                {
                    for(int k=right;k>=left;k--)
                    {
                        res[down][k] = count;
                        count++;
                    }
                    down--;
                }
                else if(dir==3)
                {
                    for(int l=down;l>=top;l--)
                    {
                        res[l][left] = count;
                        count++;
                    }
                    left++;
                }
                dir = (dir+1)%4;
            }

            return res;
        }
}



