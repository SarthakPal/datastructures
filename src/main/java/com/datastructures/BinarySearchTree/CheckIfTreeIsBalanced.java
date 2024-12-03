package com.datastructures.BinarySearchTree;

public class CheckIfTreeIsBalanced {

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        return Math.max(left, right) + 1;
    }

    // Time Complexity : O(n^2)
    public boolean isBalanced(TreeNode root) {

        if (root == null) {
            return true;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }

        boolean left = isBalanced(root.left);
        boolean right = isBalanced(root.right);

        if (!left || !right) {
            return false;
        }

        return true;

    }

    public int findHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lh = findHeight(root.left);
        int rh = findHeight(root.right);

        if (lh == -1 || rh == -1) {
            return -1;
        }

        if (Math.abs(lh - rh) > 1) {
            return -1;
        }

        return Math.max(lh, rh) + 1;

    }

    //Time Complexity : O(n)
    public boolean isBalancedTree(TreeNode root) {

        if (findHeight(root) == -1) {
            return false;
        }

        return true;

    }


}
