package com.datastructures.bst;

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
public class DiameterOfBinaryTree {

    Map<TreeNode, Integer> mp = new HashMap<>();
    Stack<TreeNode> st = new Stack<>();
    public int solve(TreeNode root)
    {
        int diameter = 0;

        if(root!=null)
        {
            st.push(root);
        }

        while(!st.isEmpty())
        {
            TreeNode node = st.peek();
            if(node.left!=null && !mp.containsKey(node.left))
            {
                st.push(node.left);
            }
            else if(node.right!=null && !mp.containsKey(node.right))
            {
                st.push(node.right);
            }
            else {
                st.pop();

                int leftDepth = mp.getOrDefault(node.left, 0);
                int rightDepth = mp.getOrDefault(node.right, 0);

                mp.put(node, 1+Math.max(leftDepth,rightDepth));

                diameter = Math.max(diameter, leftDepth+rightDepth);
            }
        }

        return diameter;

    }

}
