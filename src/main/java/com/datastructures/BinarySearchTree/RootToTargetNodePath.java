package com.datastructures.BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class RootToTargetNodePath {

    public boolean solveUtil(TreeNode root, int target, List<Integer> res)
    {
        if(root==null)
        {
            return false;
        }
        res.add(root.val);
        if(root.val==target)
        {
            return true;
        }
        if(solveUtil(root.left, target, res) || solveUtil(root.right, target, res))
        {
            return true;
        }

        res.remove(res.size()-1);
        return false;
    }

    public List<Integer> solve(TreeNode root, int target)
    {
        List<Integer> res = new ArrayList<>();
        if(root==null)
        {
            return res;
        }
        solveUtil(root, target, res);
        return res;
    }

}
