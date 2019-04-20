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
public class LongestUnivaluePath {
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 0;
        }

        int result = 0;
        int leftCount = longestUnivaluePath(root.left);
        int rightCount = longestUnivaluePath(root.right);

        if (root.left != null && root.right != null) {
            if (root.val == root.left.val && root.val == root.right.val) {
                result = leftCount + rightCount + 2;
            } else {
                if (root.val == root.left.val) {
                    leftCount++;
                }
                if (root.val == root.right.val) {
                    rightCount++;
                }
                result = Math.max(leftCount, rightCount);
            }
        } else if (root.left != null || root.right != null) {
            if (root.left != null && root.val == root.left.val) {
                leftCount++;
            }
            if (root.right != null && root.val == root.right.val) {
                rightCount++;
            }
            result = Math.max(leftCount, rightCount);
        }

        return result;

        /*
        if (root.left != null && root.right != null) {
            if (root.left.val == root.right.val) {
                if (leftCount == rightCount) {
                    result = leftCount + 2;
                } else {
                    result = Math.max(leftCount, rightCount);
                }
            } else {
                result = Math.max(leftCount, rightCount);
            }
        } else if (root.left == null && root.right != null && root.val == root.right.val) {
            result = Math.max(leftCount, rightCount + 1);
        } else if (root.right == null && root.left != null && root.val == root.left.val) {
            result = Math.max(leftCount + 1, rightCount);
        }
        */


        //return result;
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