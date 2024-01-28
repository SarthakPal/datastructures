package com.datastructures.stack;

import java.util.Stack;

public class DeleteMiddleElementOfStack {

    public static Stack<Integer> deleteMiddleElementUtil(Stack<Integer> stack, int k)
    {
        if(stack.size()==0)
        {
            return stack;
        }

        if(stack.size()==k)
        {
            stack.pop();
            return stack;
        }

        int top = stack.peek();
        stack.pop();
        Stack<Integer> result = deleteMiddleElementUtil(stack, k);
        result.push(top);
        return result;
    }

    public static Stack<Integer> deleteMiddleElement(Stack<Integer> stack)
    {
        int size = stack.size();
        int k = size/2 + 1;
        return deleteMiddleElementUtil(stack, k);
    }

    public static void main(String args[])
    {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        Stack<Integer> result = deleteMiddleElement(stack);
        while(!result.empty())
        {
            System.out.println(result.peek());
            result.pop();
        }
    }
}
