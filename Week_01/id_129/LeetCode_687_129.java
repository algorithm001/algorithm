public class LeetCode_687_129 {
    int ans;

    public int longestUnivaluePath(TreeNode root) {
        ans = 0;
        arrowLength(root);
        return ans;
    }

    public int arrowLength(TreeNode root) {
        if (root == null) return 0;
        int arrowLeft = arrowLength(root.left);
        int arrowRight = arrowLength(root.right);
        if (root.left != null && root.right != null && root.left.val == root.right.val && root.left.val == root.val) {
            ans = Math.max(ans, arrowLeft + arrowRight + 2);
        }
        int res = 0;
        if (root.left != null && root.left.val == root.val) {
            res = arrowLeft + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            res = Math.max(res, arrowRight + 1);
        }
        ans = Math.max(res, ans);
        return res;
    }
}
