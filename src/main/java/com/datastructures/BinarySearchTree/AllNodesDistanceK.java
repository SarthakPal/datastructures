package com.datastructures.BinarySearchTree;

import java.util.*;

public class AllNodesDistanceK {

    Map<TreeNode, TreeNode> mp = new HashMap<>();
    Map<TreeNode, Boolean> visited = new HashMap<>();

    public void preorder(TreeNode root, TreeNode parent)
    {
        if(root==null) return;
        mp.put(root, parent);
        preorder(root.left, root);
        preorder(root.right, root);
    }

    public boolean isVisited(TreeNode val)
    {
        return visited.get(val)!=null ? true : false;
    }

//                                            3
//                                          /   \
//                                         5     1
//                                        / \   / \
//                                       6   2 0   8
//                                          / \
//                                         7   4


    // we can traverse to 7 and 4 using BFS but not to 1 as we don't have backward edge from 5 to 3
    // so to solve this we will store the parent of each node in the map
    // and do the BFS or level order traversal and for each node check its parent, left and right
    // all the 3 should not be null and should not be visited and keep decreasing the k
    // so once k becomes zero we will have all the nodes at dist k from the target.
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        preorder(root, null);

        Queue<TreeNode> q = new LinkedList<>();

        q.add(target);

        while(!q.isEmpty() && k>0)
        {
            int size = q.size();
            for(int i=0;i<size;i++)
            {
                TreeNode temp = q.poll();
                visited.put(temp, true);
                if(mp.get(temp)!=null && !isVisited(mp.get(temp))) q.add(mp.get(temp));
                if(temp.left!=null && !isVisited(temp.left)) q.add(temp.left);
                if(temp.right!=null && !isVisited(temp.right)) q.add(temp.right);
            }
            k--;
        }

        List<Integer> result = new ArrayList<>();

        while(!q.isEmpty())
        {
            result.add(q.poll().val);
        }

        return result;

    }

}
