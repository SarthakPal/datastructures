package com.datastructures.recurrsion;

public class PowerFunction {
        public static double power(double x, int y)
        {
            double temp;
            if (y == 0)
                return 1;
            temp = power(x, y / 2);
            if (y % 2 == 0)
                return temp * temp;
            else
                return x * temp * temp;
        }

        public static double myPow(double x, int y) {
            if(y<0)
            {
                double res = power(x, y);
                return 1/res;
            }
            else
            {
                return power(x, y);
            }
        }

        public static void main(String args[])
        {
            System.out.println(myPow(2.0000, -2));
        }

}
