package com.datastructures.BinarySearchTree;

public class KthLargestSmallest {

    int count =0;
    public int kthSmallest(TreeNode root, int k) {
        int[] ans= new int[1];
        inOrder(root, k, ans );
        return ans[0];
    }

    public void inOrder(TreeNode root, int k, int[] ans){
        if(root==null){
            return;
        }
        inOrder(root.left,k, ans);
        count++;
        if(k==count){
            ans[0]=root.val;
            return;
        }
        inOrder(root.right,k, ans);
    }

}
