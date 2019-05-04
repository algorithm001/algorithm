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
    public int findSecondMinimumValue(TreeNode root) {
        if (root.left == null) {
            return -1;
        }
        int ret = -1;
        if (root.left.val == root.val) {
            ret = findSecondMinimumValue(root.left);
        } else {
            ret = root.left.val;
        }
        int retRight = -1;
        if (root.right.val == root.val) {
            retRight = findSecondMinimumValue(root.right);
        } else {
            retRight = root.right.val;
        }
        if (retRight > root.val
            && (ret == -1 || retRight < ret)) {
            ret = retRight;
        }
        return ret;
    }
}
