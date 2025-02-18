package com.datastructures.BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class BoundryTraversalOfBT {

//                                        1
//                                       / \
//                                      2   3
//                                     / \ / \
//                                    4   5   6

// Boundry Traversal : 1, 2, 4, 5, 6, 3
    public boolean isLeaf(TreeNode node)
    {
        return node.left!=null && node.right!=null;
    }

    public void addLeft(TreeNode node, List<Integer> res)
    {
        TreeNode curr = node.left;

        while(curr!=null)
        {
            if(!isLeaf(curr)) res.add(curr.val);
            if(curr.left!=null)
            {
                curr = curr.left;
            }
            else
            {
                curr = curr.right;
            }
        }

    }

    public void addRight(TreeNode node, List<Integer> res)
    {
        TreeNode curr = node.right;

        List<Integer> temp = new ArrayList<>();

        while(curr!=null)
        {
            if(!isLeaf(curr)) temp.add(curr.val);
            if(curr.right!=null)
            {
                curr = curr.right;
            }
            else
            {
                curr = curr.left;
            }
        }

        for(int i = temp.size()-1;i>=0;i--)
        {
            res.add(temp.get(i));
        }

    }

    public void addLeafs(TreeNode node, List<Integer> res)
    {
        if(isLeaf(node))
        {
            res.add(node.val);
            return;
        }
        if(node.left!=null)
        {
            addLeafs(node.left, res);
        }
        if(node.right!=null)
        {
            addLeafs(node.right, res);
        }
    }

    public List<Integer> printBoundry(TreeNode root)
    {
        List<Integer> res = new ArrayList<>();
        if(!isLeaf(root)) res.add(root.val);
        addLeft(root, res);
        addLeafs(root, res);
        addRight(root, res);
        return res;
    }

}
