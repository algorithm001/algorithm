package com.geek.week01;

/**
 * @author dehuab
 * https://leetcode-cn.com/problems/longest-univalue-path/ *
 * 687. 最长同值路径
 * Given a binary tree, find the length of the longest path where each node in the path has the same value. This path may or may not pass through the root.
 * <p>
 * Note: The length of path between two nodes is represented by the number of edges between them.
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * <p>
 * 5
 * / \
 * 4   5
 * / \   \
 * 1   1   5
 * 输出:
 * <p>
 * 2
 * 示例 2:
 * <p>
 * 输入:
 * <p>
 * 1
 * / \
 * 4   5
 * / \   \
 * 4   4   5
 * 输出:
 * <p>
 * 2
 * 注意: 给定的二叉树不超过10000个结点。 树的高度不超过1000。
 */
public class LeetCode_687_036_LongestUnivaluePath {
    public int longestUnivaluePath(TreeNode root) {
        int[] count = new int[1];
        getLongestPathCount(root, count);
        return count[0];
    }

    private int getLongestPathCount(TreeNode node, int[] longestPath) {
        if (node == null) {
            return 0;
        }

        int leftCount = getLongestPathCount(node.left, longestPath);
        int rightCount = getLongestPathCount(node.right, longestPath);

        if (node.left != null && node.left.val == node.val) {
            leftCount++;
        } else {
            leftCount = 0;
        }

        if (node.right != null && node.right.val == node.val) {
            rightCount++;
        } else {
            rightCount = 0;
        }

        int currentLongestPath;
        if (node.left != null && node.right != null && node.left.val == node.right.val) {
            /* 如果左右节点的值相同，那么可以相加连接起来。但如果左右相同但和本节点值不同，那么left和right的值都是0 */
            currentLongestPath = leftCount + rightCount;
        } else {
            /* 否则，最大的路径值只能是左右路径的最大值 */
            currentLongestPath = Math.max(leftCount, rightCount);
        }

        if (currentLongestPath > longestPath[0]) {
            /* 最终返回的结果在这里，每次递归都是以当前节点为核心，计算最大路径值，在多次递归当中，仅保留最大的值 */
            longestPath[0] = currentLongestPath;
        }
        /* 递归返回的是本节点与左右两个子节点的同值路径的最大值，注意，如果本节点的值与左右节点的值都不同，那么返回的是0 */
        return Math.max(leftCount, rightCount);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}