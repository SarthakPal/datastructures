package com.datastructures.BinarySearchTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ZigZagTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Deque<TreeNode> q = new LinkedList<>();

        q.offer(root);
        boolean reverse = false;
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> temp = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                if (!reverse) {
                    TreeNode curr = q.pollFirst();
                    temp.add(curr.val);
                    if (curr.left != null) {
                        q.addLast(curr.left);
                    }
                    if (curr.right != null) {
                        q.addLast(curr.right);
                    }

                } else {
                    TreeNode curr = q.pollLast();
                    temp.add(curr.val);
                    if (curr.right != null) {
                        q.addFirst(curr.right);
                    }
                    if (curr.left != null) {
                        q.addFirst(curr.left);
                    }
                }
            }

            reverse = !reverse;
            res.add(temp);


        }

        return res;

    }


}
