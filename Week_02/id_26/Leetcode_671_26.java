package com.fanlu.leetcode.binarytree;
// Source : https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/
// Id     : 671
// Author : Fanlu Hai
// Date   : 2018-04-23
// Other  : Long result =Long.valueOf(Integer.MAX_VALUE)+1; Long.valueOf(Integer.MAX_VALUE+1) will result in Integer.MIN
// Tips   :

import java.util.PriorityQueue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

// to do
public class SecondMinimumNodeInABinaryTree {

    //Long result =Long.valueOf(Integer.MAX_VALUE)+1;
    Long result = Long.MAX_VALUE;

    //100.00% 93.19%
    public int findSecondMinimumValue(TreeNode root) {
        if (null == root || null == root.left)
            return -1;

        int min = root.val;
        dfs(root, min);
        if (result == min)
            return -1;
        if (result == Long.MAX_VALUE)
            return -1;

        return result.intValue();
    }

    public void dfs(TreeNode node, int min) {
        if (null == node)
            return;
        if (node.val != min && node.val < result) {
            result = Long.valueOf(node.val);
        }
        dfs(node.left, min);
        dfs(node.right, min);
    }


    PriorityQueue<Integer> queue = new PriorityQueue<>();

    // 5% 93%
    public int findSecondMinimumValueThinkTooLess(TreeNode root) {
        preorderTraverse(root);

        if (queue.isEmpty() || queue.size() == 1)
            return -1;
        int min = queue.poll();
        System.out.println(min);
        while (!queue.isEmpty()) {
            int second = queue.poll();
            System.out.println(second);
            if (second == min) {
                continue;
            }
            return second;
        }
        return -1;
    }

    public void preorderTraverse(TreeNode node) {
        if (null == node)
            return;
        queue.add(node.val);
        preorderTraverse(node.left);
        preorderTraverse(node.right);

    }
}
