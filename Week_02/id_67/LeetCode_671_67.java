/*
 * @lc app=leetcode.cn id=671 lang=java
 *
 * [671] 二叉树中第二小的节点
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        return traversal(root, root.val);
    }

    public int traversal(TreeNode root, int value) {
        if (root == null) {
            return -1;
        }

        if (root.val > value) {
            return root.val;
        }

        int l = traversal(root.left, value);
        int r = traversal(root.right, value);

        if (l >= 0 && r >= 0) {
            return Math.min(l, r);
        }

        return Math.max(l, r);
    }
}
