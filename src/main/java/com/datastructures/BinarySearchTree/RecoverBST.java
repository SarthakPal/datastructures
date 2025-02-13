package com.datastructures.BinarySearchTree;

public class RecoverBST {

//                                            8
//                                          /   \
//                                         25    15
//                                        /  \   / \
//                                       3   7   10 20
//                                                    \
//                                                     5
//
// for the above tree inorder is : 3, 25, 7, 8, 10, 15, 20, 5


//                                            7
//                                          /   \
//                                         5    15
//                                        /  \   / \
//                                       3   8  10 20
//                                                    \
//                                                     25
//
// for the above tree inorder is : 3, 5, 8, 7, 10, 15, 20, 25


// in this recoverBST question 2 nodes will be swapped we have to find those 2 nodes like in first example
// one 5 and 25 are swapped so we will traverse in inorder manner and for every node we will check if the current node
// value is less than prev node if it is then we have found the first wrong pattern and we will mark the prev node as first and
// current node as middle and we will continue traversing.

// now there can be 2 cases it will be possible that we will again found the wrong pattern like
// in first example 25>7 and 20 > 5 so will again mark the current value as last
// and it may possible that we only the wrong pattern only once like in second example 8>7 so in this case
// there will be no last value and this is the case when nodes are adjacent.

// so if first and last both are non null we will swap value of both otherwise we will swap the value of first and middle.

    private TreeNode first = null;
    private TreeNode middle = null;
    private TreeNode last = null;
    private TreeNode prev = null;

    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);

        if (prev != null && (root.val < prev.val)) {
            if (first == null) {
                first = prev;
                middle = root;
            } else {
                last = root;
            }
        }

        prev = root;

        inorder(root.right);

    }

    public void recoverTree(TreeNode root) {

        if (root == null) {
            return;
        }

        inorder(root);

        if (first != null && last != null) {
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        } else if (first != null && middle != null) {
            int temp = first.val;
            first.val = middle.val;
            middle.val = temp;
        }

    }

}
