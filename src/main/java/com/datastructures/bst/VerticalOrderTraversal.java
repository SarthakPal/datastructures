package com.datastructures.bst;

import java.util.*;

public class VerticalOrderTraversal {

    Map<Integer, ArrayList<Integer>> mp = new TreeMap<>();

    public ArrayList<ArrayList<Integer>> verticalOrderTraversalUtil(TreeNode node) {

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

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for (Map.Entry<Integer, ArrayList<Integer>> entry : mp.entrySet())
        {
            result.add(entry.getValue());
        }

        return result;

    }

    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode node)
    {
        if(node==null)
        {
            return null;
        }
        return verticalOrderTraversalUtil(node);
    }

}
