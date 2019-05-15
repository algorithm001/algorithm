package com.geek.week02;

import com.geek.model.TreeNode;

public class LeetCode_671_036 {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }

        int[] result = new int[2];
        result[0] = root.val;
        result[1] = root.val;
        helper(root, result);

        if (result[0] == result[1]) {
            return -1;
        } else {
            return result[1];
        }
    }

    private void helper(TreeNode node, int[] result) {
        if (node == null) {
            return;
        }

        if (result[0] == result[1]) {
            result[1] = node.val;
        } else if (node.val < result[1] && node.val != result[0]) {
            result[1] = node.val;
        }

        helper(node.left, result);
        helper(node.right, result);
    }

    /*
    if (root.left != null && root.left.val > root.val) {
            return root.val;
        }
        if (root.right != null && root.right.val > root.val) {
            return root.val;
        }
     */
}
