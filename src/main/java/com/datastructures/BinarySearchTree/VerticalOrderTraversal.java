package com.datastructures.BinarySearchTree;

import java.util.*;

public class VerticalOrderTraversal {

    Map<Integer, ArrayList<Integer>> mp = new TreeMap<>();

    public List<List<Integer>> verticalOrderTraversalUtil(TreeNode node) {

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

        List<List<Integer>> result = new ArrayList<>();

        for (Map.Entry<Integer, ArrayList<Integer>> entry : mp.entrySet())
        {
            result.add(entry.getValue());
        }

        return result;

    }

    public List<List<Integer>> verticalOrderTraversal(TreeNode node)
    {
        if(node==null)
        {
            return null;
        }
        return verticalOrderTraversalUtil(node);
    }

    public static TreeNode insertLevelOrder(int[] arr, int i) {
        TreeNode root = null;
        if (i < arr.length) {
            root = new TreeNode(arr[i]);
            root.left = insertLevelOrder(arr, 2 * i + 1);
            root.right = insertLevelOrder(arr, 2 * i + 2);
        }
        return root;
    }

    public static void main(String[] args) {
        // Example input: [1,2,3,4,6,5,7]
        int[] arr = {1, 2, 3, 4, 5, 6, 7};

        // Create the binary tree from the array
        TreeNode root = insertLevelOrder(arr, 0);

        // Create the solution instance and call verticalTraversal
        VerticalOrderTraversal solution = new VerticalOrderTraversal();
        List<List<Integer>> result = solution.verticalOrderTraversal(root);

        // Print the result
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }

}
