package com.datastructures.bst;


public class MorrisInorderTraversal {

    public static void inorder(TreeNode root)
    {
        TreeNode curr = root;

        while(curr!=null)
        {
            if(curr.left==null)
            {
                System.out.println(curr.val);
                curr = curr.right;
            }
            else {
                TreeNode prev = curr.left;
                while(prev.right!=null && prev.right!=curr)
                {
                    prev = prev.right;
                }
                if(prev.right==null)
                {
                    prev.right=curr;
                    curr = curr.left;
                }
                else
                {
                    prev.right=null;
                    System.out.println(curr.val);
                    curr = curr.right;
                }
            }
        }
    }

    public static void main(String args[])
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        inorder(root);
    }

}
