package com.datastructures.BinarySearchTree;

import java.util.*;

public class TopOrderTraversal {

    Map<Integer, ArrayList<Integer>> mp = new TreeMap<>();

    public ArrayList<Integer> verticalOrderTraversalUtil(TreeNode node) {

        if(node==null)
        {
            return null;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(node);
        Queue<Integer> dist = new LinkedList<>();
        dist.add(0);
        int curr_dist = 0;

        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i=0;i<size;i++)
            {
                node = q.peek();
                curr_dist = dist.peek();
                if(!mp.containsKey(curr_dist))
                {
                    mp.put(curr_dist, new ArrayList<Integer>());
                }
                mp.get(curr_dist).add(node.val);
                if(node.left!=null)
                {
                    q.add(node.left);
                    dist.add(curr_dist-1);
                }
                if(node.right!=null)
                {
                    q.add(node.right);
                    dist.add(curr_dist+1);
                }
                q.remove();
                dist.remove();
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        for (Map.Entry<Integer, ArrayList<Integer>> entry : mp.entrySet())
        {
            result.add(entry.getValue().get(0));
        }

        return result;

    }

    public ArrayList<Integer> verticalOrderTraversal(TreeNode node)
    {
        if(node==null)
        {
            return null;
        }
        return verticalOrderTraversalUtil(node);
    }

    public static void main(String args[])
    {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        TopOrderTraversal topOrderTraversal = new TopOrderTraversal();
        List<Integer> res = topOrderTraversal.verticalOrderTraversal(root);

        for(Integer i : res)
        {
            System.out.print(i+" ");
        }
    }

}
