package com.datastructures.BinarySearchTree;

public class NormalBSTToBalancedBST {

    TreeNode buildTree(int inorder[], int start, int end)
    {
        if(start>end)
        {
            return null;
        }
        int mid = (start+end)/2;
        TreeNode root = new TreeNode(inorder[mid]);

        root.left = buildTree(inorder, start, mid-1);
        root.right = buildTree(inorder, mid+1, end);

        return root;
    }

}
