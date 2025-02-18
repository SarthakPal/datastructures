package com.datastructures.BinarySearchTree;


public class MorrisInorderPreOrderTraversal {


//                                1
//                               / \
//                              2   3
//                             /\   /\
//                            4  5
//                               /\
//                                 6

// We have to make thread to the current element from the current element's left part last element.
// In the above case we have to make thread from 6 to 1. and from 4 to 2.
// This is necessary because we have to traverse back as in recurrsion it will done while returning to parent function call.
// And once we have travelled using that thread we have to remove that thread also otherwise we will keep iterating in infinite loop
// We will start with 1 and then check its left which is not null so we will keep going into the right of the left
// and by doing this we will reach to 6 and create a thread from 6 to 1 and go to left i.e. 2 Now there is only left
// which is 4 now 4 will point to 2. Now curr will become 4 its left is null so it will get printed and goes to right
// as we have created a thread from 4 to 2 so 4's right is 2 and now it will go to 2. Again ti will check for left
// which is present but it will not go again into while loop because 4 is already pointing to 2. so we have to
// remove this thread and control will go in else block and remove the thread and print the curr element and go in right
// no 5 will get printed as left is null then 6 will get printed as its left is also null no control will go to 1
// and thread from 6 to 1 will get deleted.


    public static void inorder(TreeNode root)
    {
        TreeNode curr = root;

        while(curr!=null)
        {
            if(curr.left==null)
            {
                System.out.println(curr.val);
                curr = curr.right;
            }
            else {
                TreeNode prev = curr.left;
                while(prev.right!=null && prev.right!=curr)
                {
                    prev = prev.right;
                }
                if(prev.right==null)
                {
                    prev.right=curr;
                    curr = curr.left;
                }
                else
                {
                    prev.right=null;
                    System.out.println(curr.val);
                    curr = curr.right;
                }
            }
        }
    }

    public static void preorder(TreeNode root)
    {
        TreeNode curr = root;

        while(curr!=null)
        {
            if(curr.left==null)
            {
                System.out.println(curr.val);
                curr = curr.right;
            }
            else {
                TreeNode prev = curr.left;
                while(prev.right!=null && prev.right!=curr)
                {
                    prev = prev.right;
                }
                if(prev.right==null)
                {
                    System.out.println(curr.val);
                    prev.right=curr;
                    curr = curr.left;
                }
                else
                {
                    prev.right=null;
                    curr = curr.right;
                }
            }
        }
    }

    public static void main(String args[])
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        inorder(root);
    }

}
