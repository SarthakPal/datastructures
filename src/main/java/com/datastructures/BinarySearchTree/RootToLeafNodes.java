package com.datastructures.BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class RootToLeafNodes {

    public void traverse(TreeNode root, List<String> res, String s) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            res.add(s + root.val);
            return;
        }

        traverse(root.left, res, s + root.val + "->");
        traverse(root.right, res, s + root.val + "->");

    }

    public List<String> binaryTreePaths(TreeNode root) {

        List<String> res = new ArrayList<>();
        traverse(root, res, "");
        return res;

    }


}
