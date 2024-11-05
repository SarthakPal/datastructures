package com.datastructures.BinarySearchTree;

public class InorderSuccessor {

    public TreeNode successor = null;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode target)
    {
        if(root==null)
        {
            return null;
        }

        while(root!=null)
        {
            if(target.val >= root.val)
            {
                root = root.right;
            }
            else {
                successor = root;
                root = root.left;
            }
        }

        return successor;
    }

}
