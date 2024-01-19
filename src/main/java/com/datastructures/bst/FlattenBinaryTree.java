package com.datastructures.bst;

public class FlattenBinaryTree {

    public void inorder(TreeNode root)
    {
        TreeNode curr = root;

        while(curr!=null)
        {
            if(curr.left==null)
            {
                curr = curr.right;
            }
            else {
                TreeNode prev = curr.left;
                while(prev.right!=null && prev.right!=curr)
                {
                    prev = prev.right;
                }
                prev.right = curr.right;
                curr.right = curr.left;
            }
        }
    }

}
