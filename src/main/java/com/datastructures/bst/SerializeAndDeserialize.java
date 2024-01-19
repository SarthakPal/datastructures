package com.datastructures.bst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserialize {

    public TreeNode deserialize(ArrayList<Integer> A) {

        TreeNode root = new TreeNode(A.get(0));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        for(int i=1;i<A.size();i++)
        {
            TreeNode parent = q.poll();
            if(A.get(i)!=-1)
            {
                TreeNode left = new TreeNode(A.get(i));
                parent.left = left;
                q.add(left);
            }
            i++;
            if(i<A.size() && A.get(i)!=-1)
            {
                TreeNode right = new TreeNode(A.get(i));
                parent.right = right;
                q.add(right);
            }
        }

        return root;
    }

    public ArrayList<Integer> seralize(TreeNode node) {

        ArrayList<Integer> result = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(node);

        while(!q.isEmpty())
        {
            node = q.poll();

            if(node==null)
            {
                result.add(-1);
                continue;
            }
            else
            {
                q.add(node.left);
                q.add(node.right);
                result.add(node.val);
            }
        }
        return result;
    }

}
