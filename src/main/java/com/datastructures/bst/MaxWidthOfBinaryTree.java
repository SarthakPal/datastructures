package com.datastructures.bst;

import java.util.LinkedList;
import java.util.Queue;

class Pair
{
    TreeNode node;
    int num;
    public Pair(TreeNode node, int num)
    {
        this.node = node;
        this.num = num;
    }
}
public class MaxWidthOfBinaryTree {

    public int maxWidth(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        int ans = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        while(!queue.isEmpty())
        {
            int min = queue.peek().num;
            int first=0, last = 0;
            int size = queue.size();
            for(int i=0;i<size;i++)
            {
                Pair pair = queue.peek();
                queue.poll();
                int curr = pair.num - min;
                if(i==0) first = curr;
                if(i== size-1) last = curr;
                if(pair.node.left!=null)
                {
                    queue.add(new Pair(pair.node.left, curr*2-1));
                }
                if(pair.node.right!=null)
                {
                    queue.add(new Pair(pair.node.right, curr*2+1));
                }
            }
            ans = Math.max(ans, last-first+1);
        }
        return ans;
    }

}
