package com.datastructures.Strings;
public class StringToInteger {

    public int myAtoi(String str) {

        str = str.trim();

        if (str.length() == 0) return 0;

        int i = 0;
        int sign = 1;

        if (str.charAt(i) == '-' || str.charAt(i) == '+') {
            if (str.charAt(i) == '-') sign = -1;
            i++;
        }

        long res = 0;

        for (int x = i; x < str.length(); x++) {
            if (str.charAt(x) - '0' >= 0 && str.charAt(x) - '0' <= 9) {
                res = res * 10 + (str.charAt(x) - '0');
                if (sign == -1) {
                    long check = -res;
                    if (check < Integer.MIN_VALUE) {
                        return Integer.MIN_VALUE;
                    }
                } else {
                    long check = res;
                    if (check > Integer.MAX_VALUE) {
                        return Integer.MAX_VALUE;
                    }
                }
            } else {
                break;
            }
        }
        return (int) res * sign;
    }

}
