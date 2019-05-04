/**
 * leetcode 671
 *
 * @author hewei
 * @date 2019/4/27 21:50
 */
public class LeetCode_671_53 {
    public int findSecondMinimumValue(TreeNode root) {
        if (root.left == null && root.right == null) {
            return -1;
        }
        int left = root.val == root.left.val ? findSecondMinimumValue(root.left) : root.left.val;
        int right = root.val == root.right.val ? findSecondMinimumValue(root.right) : root.right.val;
        if (left == -1 && right == -1) {
            return -1;
        }
        if (left == -1) {
            return right;
        }
        if (right == -1) {
            return left;
        }
        return Math.min(left, right);
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
