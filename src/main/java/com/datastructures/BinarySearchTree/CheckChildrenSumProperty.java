package com.datastructures.BinarySearchTree;

public class CheckChildrenSumProperty {

    // returns 1 if children sum property holds
    // for the given node and both of its children
    static int isSumProperty(TreeNode root) {

        // If root is NULL or it's a leaf node
        // then return true
        if (root == null || (root.left == null && root.right == null))
            return 1;

        int sum = 0;

        // If left child is not present then 0
        // is used as data of left child
        if (root.left != null)
            sum += root.left.val;

        // If right child is not present then 0
        // is used as data of right child
        if (root.right != null)
            sum += root.right.val;

        // if the node and both of its children
        // satisfy the property return 1 else 0
        return ((root.val == sum)
                && (isSumProperty(root.left) == 1)
                && (isSumProperty(root.right) == 1))
                ?
                1 : 0;
    }


}

