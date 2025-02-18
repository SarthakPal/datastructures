package com.datastructures.BinarySearchTree;

public class FlattenBinaryTree {

    public void inorder(TreeNode root) {
        TreeNode curr = root;

        while (curr != null) {
            if (curr.left != null) {
                TreeNode prev = curr.left;
                while (prev.right != null) {
                    prev = prev.right;
                }
                prev.right = curr.right;
                curr.right = curr.left;
            }
            curr = curr.right;
        }
    }


//                                            1
//                                          /   \
//                                         2     5
//                                        /  \    \
//                                       3    4    6
//                                                  \
//                                                   7


// first we will call flatten with node 1 it will call 5 then 6 and 7, for 7 both right and left is null then
// for 7 right will point to prev which is null and then left will point to null and prev will become 7 then
// it will return to 6 so for 6 both left and right is done so 6 right will point to prev (7) and left will be null
// now it will return to 5 its both left and right is done so 5 right will point to 6 and left will be null and
// then prev will become 5 now control will go to 1's left which is 2 and this will call 2's right 4 for 4 both
// left and right are null so 4 right will point to prev (5) and left will become null and prev will become 4
// now 2 will call its left(3) same for 3 now 3's right will point to prev (4) and prev will become 3
// now control will return to 2 as its both left and right are done so 2's right will point to prev (3) and
// prev will become 2 and 1's right will become 2.

// Time Complexity: O(N) where N is the number of nodes in the Binary Tree. Each node of the binary node is visited
// exactly once. At each node, constant-time operations are performed. Hence the time complexity is O(N).

//Space Complexity : O(log2N)where N is the number of nodes in the Binary Tree. There are no additional data structures
// or space used but the auxiliary stack space is used during recursion. Since the recursion depth can be at most equal
// to the height to the Binary Tree, the space complexity is O(H) where H is the height of the Binary Tree.
// In the ideal case, H = log2N and in the worst case H = N (skewed tree).

    TreeNode prev = null;

    public void flatten(TreeNode root) {

        if (root == null) return;

        flatten(root.right);
        flatten(root.left);

        root.right = prev;
        root.left = null;
        prev = root;

    }

}
