package com.datastructures.BinarySearchTree;

public class MaxPathSumLeaftoLeaf {

    public int solve(TreeNode root, int[] res)
    {
        if(root==null)
        {
            return 0;
        }

        int left = solve(root.left, res);
        int right = solve(root.right, res);

        int temp = Math.max(left, right)+root.val;
        if(root.left==null && root.right==null)
        {
            temp = Math.max(temp, root.val);
        }
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
