/**
 * 获取二叉树的最大深度
 * 
 * @author apple
 */
public class MaxDepth {
    /**
     * Definition for a binary tree node. public class TreeNode { int val;
     * TreeNode left; TreeNode right; TreeNode(int x) { val = x; } }
     */
    public static int maxDepth(TreeNode root) {
        return dfs(root, 0);
    }
	// 遇到二叉树就用递归
    public static int dfs(TreeNode root, int depth) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        return Math.max(dfs(root.left, depth) + 1, dfs(root.right, depth) + 1);
    }
}
