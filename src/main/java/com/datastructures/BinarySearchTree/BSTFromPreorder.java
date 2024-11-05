package com.datastructures.BinarySearchTree;

public class BSTFromPreorder {

//                                8
//                               / \
//                             5    10
//                            / \     \
//                           1   7     12

    public TreeNode bstFromPreorderUtil(int[] preorder, int bound, int[] i) {
        if (i[0] == preorder.length || preorder[i[0]] > bound) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[i[0]]);

        i[0]++;

        root.left = bstFromPreorderUtil(preorder, root.val, i);
        root.right = bstFromPreorderUtil(preorder, bound, i);

        return root;

    }

    public TreeNode bstFromPreorder(int[] preorder) {

        return bstFromPreorderUtil(preorder, Integer.MAX_VALUE, new int[]{0});

    }


}
