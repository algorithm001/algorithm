package com.potato.leetcode.tree;


import com.potato.leetcode.model.TreeNode;

public class LeetCode_104_036 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
