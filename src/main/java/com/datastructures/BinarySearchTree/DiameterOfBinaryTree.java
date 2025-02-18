package com.datastructures.BinarySearchTree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*class TreeNode
{
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(TreeNode left, TreeNode right, int val)
    {
        this.left = left;
        this.right = right;
        this.val = val;
    }

}*/

// Height of BT is max no of levels including root node.
// Diameter of BT is the maximum number of edges between any two nodes in the tree.
// Note that this path may or may not pass through the root. max of sum of ( leftHeight+rightHeight ) from all the nodes
public class DiameterOfBinaryTree {

    public int height(TreeNode root, int[] diameter)
    {

        if(root==null)
        {
            return 0;
        }

        int left = height(root.left, diameter);
        int right = height(root.right, diameter);

        diameter[0] = Math.max(diameter[0], left+right);

        return Math.max(left,right)+1;

    }

    public int diameterOfBinaryTree(TreeNode root) {

        if(root==null)
        {
            return 0;
        }

        int[] diameter = new int[1];
        diameter[0] = -1;

        height(root, diameter);

        return diameter[0];

    }


}
