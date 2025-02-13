package com.datastructures.BinarySearchTree;

class TreeNode
{
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val)
    {
        this.val = val;
    }

    public TreeNode(TreeNode left, TreeNode right, int val)
    {
        this.left = left;
        this.right = right;
        this.val = val;
    }

}
class NodeInfo
{
    public int minNode;
    public int maxNode;
    public int maxSize;

    public NodeInfo(int minNode, int maxNode, int maxSize)
    {
        this.minNode = minNode;
        this.maxNode = maxNode;
        this.maxSize = maxSize;
    }

}
public class LargestBST {

    public NodeInfo solveUtil(TreeNode root)
    {
        if(root==null)
        {
            return new NodeInfo(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        NodeInfo left = solveUtil(root.left);
        NodeInfo right = solveUtil(root.right);

        if(left.maxNode < root.val && root.val < right.minNode)
        {
            return new NodeInfo(Math.min(left.minNode, root.val), Math.max(right.maxNode, root.val),
                    1+left.maxSize+right.maxSize);
        }

        else {
            return new NodeInfo(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSize,    right.maxSize));
        }

    }

    public int solve(TreeNode root)
    {
        return solveUtil(root).maxSize;
    }

    public static void main(String args[])
    {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        LargestBST l = new LargestBST();
        System.out.println(l.solve(root));
    }

}
