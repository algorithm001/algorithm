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
    public int rangeSumBST(TreeNode root, int L, int R) {
        int sum = 0;
        if (root == null) {
            return sum;
        }
        if (L <= root.val && R >= root.val) {
            sum += root.val;
        }
        if (root.left != null) {
            sum += rangeSumBST(root.left, L, R);
        }
        if (root.right != null) {
            sum += rangeSumBST(root.right, L, R);
        }
        return sum;
    }
}