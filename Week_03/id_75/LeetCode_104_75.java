/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null)return 0;
        int leftDp = maxDepth(root.left);
        int rightDp = maxDepth(root.right);
        return Math.max(leftDp,rightDp) + 1;
    }
}