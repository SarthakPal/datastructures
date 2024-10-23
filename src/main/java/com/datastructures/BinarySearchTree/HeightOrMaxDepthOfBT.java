package com.datastructures.BinarySearchTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class HeightOrMaxDepthOfBT {

    // Time Complexity: O(N) where N is the number of nodes in the binary tree.
    // Auxiliary Space: O(N) where N is the number of nodes in the binary tree.
    public int findHeight(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        int res = 0;

        if (root == null) {
            return res;
        }

        while (!q.isEmpty()) {
            int size = q.size();
            res++;
            List<Integer> temp = new ArrayList<>();
            for (int i = 1; i <= size; i++) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
                temp.add(node.val);
            }
        }

        return res;

    }

    //using recurrsion
    public int maxDepth(TreeNode root) {
        if(root == null)
        {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right)+1;
    }

    // Time Complexity: O(n), where n is the number of nodes in the binary tree, as each node is visited once.
    // Auxiliary Space: O(h) where h is height of the binary tree


}
