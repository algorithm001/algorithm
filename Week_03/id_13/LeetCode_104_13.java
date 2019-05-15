package leetCode.week3;

/**
 * Maximum Depth of Binary Tree
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 * https://leetcode.com/problems/maximum-depth-of-binary-tree
 *
 * @author JP.Jiang
 * @version Java
 * @since 2019/05/01
 */
public class LeetCode_104_13 {

    public int maxDepth(TreeNode root) {
        return doMaxDepth(root);
    }

    private int doMaxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(doMaxDepth(node.left), doMaxDepth(node.right));
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
