package com.datastructures.BinarySearchTree;

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
            int size = queue.size();
            int min = queue.peek().num;
            int first = 0;
            int last = 0;
            for(int i=1;i<=size;i++)
            {
                int curr = queue.peek().num - min;
                TreeNode node = queue.peek().node;
                queue.poll();
                if(i==1) first = curr;
                if(i==size) last = curr;
                if(node.left!=null)
                {
                    queue.offer(new Pair(node.left, curr*2+1));
                }
                if(node.right!=null)
                {
                    queue.offer(new Pair(node.right, curr*2+2));
                }
            }
            ans = Math.max(ans, last-first+1);
        }
        return ans;
    }

}
