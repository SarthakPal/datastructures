package com.datastructures.BinarySearchTree;

import java.util.Stack;

 class BSTIteratorr{
    Stack<TreeNode> stack = new Stack<>();
    boolean reverse = false;

    public BSTIteratorr(TreeNode node, boolean isReverse) {
        reverse = isReverse;
        pushAll(node);
    }

    public void pushAll(TreeNode node) {
        while (node != null) {
            stack.push(node);
            if (!reverse) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
    }

    public int next() {
        TreeNode node = stack.pop();
        if (!reverse) {
            pushAll(node.right);
        } else {
            pushAll(node.left);
        }
        return node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

}

public class TwoSumBST {

    public boolean findTarget(TreeNode root, int k) {

        if(root==null)
        {
            return false;
        }

        BSTIteratorr left = new BSTIteratorr(root, false);
        BSTIteratorr right = new BSTIteratorr(root, true);

        int l = left.next();
        int r = right.next();

        while(l<r)
        {
            if(l+r==k)
            {
                return true;
            }
            else if(l+r<k)
            {
                l = left.next();
            }
            else {
                r = right.next();
            }
        }

        return false;

    }

}
