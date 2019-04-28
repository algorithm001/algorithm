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
    int result = 0;
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }
        rangeSumBST(root.left, L, R);
        if (root.val >= L && root.val <= R) {
            result += root.val;
        }
        rangeSumBST(root.right, L, R);
        return result;
    }
    
}