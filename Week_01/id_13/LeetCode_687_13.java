package leetCode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

public class LeetCode_687_13 {
    private int pathInt;

    public int longestUnivaluePath(TreeNode root) {
        pathInt = 0;
        _pathLength(root);
        return pathInt;
    }

    public int _pathLength(TreeNode node) {
        if (node == null) return 0;
        int left = _pathLength(node.left);
        int right = _pathLength(node.right);
        int pathLeft = 0, pathRight = 0;
        if (node.left != null && node.left.val == node.val) {
            pathLeft += left + 1;
        }
        if (node.right != null && node.right.val == node.val) {
            pathRight += right + 1;
        }
        pathInt = Math.max(pathInt, pathLeft + pathRight);
        return Math.max(pathLeft, pathRight);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
