/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int maxPath = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return maxPath;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = dfs(node.left);
        if (node.left != null) {
            if (node.left.val == node.val) {
                left++;
            } else {
                left = 0;
            }
        }
        int right = dfs(node.right);
        if (node.right != null) {
            if (node.right.val == node.val) {
                right++;
            } else {
                right = 0;
            }
        }
        maxPath = Math.max(right + left, maxPath);
        return Math.max(left, right);
    }
}