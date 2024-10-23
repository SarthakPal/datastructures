package com.datastructures.BinarySearchTree;

import java.util.HashMap;
import java.util.Map;

public class ConstructTreeFromInorderAndPreorder {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */

        public TreeNode buildTreeUtil(int[] preorder, int prestart, int preend,
                                      int[] inorder, int instart, int inend, Map<Integer, Integer> mp)
        {

            if(prestart>preend || instart>inend)
            {
                return null;
            }

            TreeNode root = new TreeNode(preorder[prestart]);

            int inroot = mp.get(preorder[prestart]);
            int numsleft = inroot-instart;

            root.left = buildTreeUtil(preorder, prestart+1, prestart+numsleft, inorder, instart, inroot-1, mp);
            root.right = buildTreeUtil(preorder, prestart+numsleft+1, preend, inorder, inroot+1, inend, mp);

            return root;

        }

        public TreeNode buildTree(int[] preorder, int[] inorder) {

            Map<Integer, Integer> mp = new HashMap<>();

            for(int i=0;i<inorder.length;i++)
            {
                mp.put(inorder[i], i);
            }

            TreeNode root = buildTreeUtil(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, mp);

            return root;

        }


}
