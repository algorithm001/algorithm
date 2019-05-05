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
    int result = 101;
    public int minDiffInBST(TreeNode root) {
        if (root != null) {
            if (root.left != null) {
                int i = Math.abs(root.val - root.left.val);
                result = i < result ? i : result;
            }
            if (root.right != null) {
                int i = Math.abs(root.val - root.right.val);
                result = i < result ? i : result;
            }
            int l = minDiffInBST(root.left);
            int r = minDiffInBST(root.right);
            if (l <= r) {
                result = l;
            } else {
                return r;
            }
            result = l <= r ? l : r;
        }
        return result;
    }
}
