package com.datastructures.recurrsion;

import java.util.*;
public class GenerateParanthesis {

    public void generateParenthesisUtil(int open, int closed, String str, List<String> res) {
        if (open == 0 && closed == 0) {
            res.add(str);
            return;
        }
        if (open != 0) {
            String temp = str;
            temp = temp + "(";
            generateParenthesisUtil(open - 1, closed, temp, res);
        }
        if (closed > open) {
            String temp = str;
            temp = temp + ")";
            generateParenthesisUtil(open, closed - 1, temp, res);
        }
    }

    public List<String> generateParenthesis(int n) {
        int open = n;
        int closed = n;
        List<String> res = new ArrayList<>();
        String str = "";
        generateParenthesisUtil(open, closed, str, res);
        return res;
    }

}
