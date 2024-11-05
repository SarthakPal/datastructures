package com.datastructures.BinarySearchTree;

public class FlattenBinaryTree {

    public void inorder(TreeNode root) {
        TreeNode curr = root;

        while (curr != null) {
            if (curr.left == null) {
                curr = curr.right;
            } else {
                TreeNode prev = curr.left;
                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }
                prev.right = curr.right;
                curr.right = curr.left;
            }
        }
    }


    TreeNode prev = null;

    public void flatten(TreeNode root) {

        if (root == null) return;

        flatten(root.right);
        flatten(root.left);

        root.right = prev;
        root.left = null;
        prev = root;

    }

}
