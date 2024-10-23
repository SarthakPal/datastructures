package com.datastructures.BinarySearchTree;

public class MaxPathSum {

    public int solve(TreeNode root, int[] res)
    {
        if(root==null)
        {
            return 0;
        }

        int left = solve(root.left, res);
        int right = solve(root.right, res);

        // there can be 3 cases
        // 1. max(left, right) of current node+current node value
        // 2. if both the left and right sum is negative then current node value is the max sum
        // in both the first and second case it is the temporary answer as it can be added to the
        // above nodes to become the max sum
        // 3. current node is the root node of the max path sum and its left and right also the part of max path sum
        // and it is the final answer only, no above nodes will add up in the final max path sum.

        int temp = Math.max( (Math.max(left, right)+root.val), root.val);
        int ans = Math.max(temp, left+right+root.val);

        res[0] = Math.max(res[0], ans);

        return temp;

    }

    public int maxPathSum(TreeNode root) {

        if(root.left==null && root.right==null) return root.val;

        int[] res = new int[1];
        res[0] = Integer.MIN_VALUE;

        solve(root, res);

        if(res[0]==Integer.MIN_VALUE)
        {
            return root.val;
        }

        return res[0];

    }


}
