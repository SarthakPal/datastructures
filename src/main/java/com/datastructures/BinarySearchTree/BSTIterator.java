package com.datastructures.BinarySearchTree;

import java.util.Stack;

public class BSTIterator {

    Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode node)
    {
        pushAll(node);
    }

    public void pushAll(TreeNode node)
    {
        while(node!=null)
        {
            stack.push(node);
            node = node.left;
        }
    }

    public int next()
    {
        TreeNode node = stack.pop();
        pushAll(node);
        return node.val;
    }

    public boolean hasNext()
    {
        return !stack.isEmpty();
    }

}
