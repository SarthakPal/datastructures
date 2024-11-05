package com.datastructures.BinarySearchTree;

public class CheckValidBST {


    public boolean isValidBSTUtil(TreeNode root, Long min, Long max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        return isValidBSTUtil(root.left, min, Long.valueOf(root.val))
                && isValidBSTUtil(root.right, Long.valueOf(root.val), max);
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBSTUtil(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }


}
