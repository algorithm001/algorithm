package data.leetcode.dfs;

public class Leetcode104 {
    //二叉树的最大深度
//    给定一个二叉树，找出其最大深度。
//
//    二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
//
//    说明: 叶子节点是指没有子节点的节点。
//
//    示例：
//    给定二叉树 [3,9,20,null,null,15,7]，
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 执行用时 : 1 ms, 在Maximum Depth of Binary Tree的Java提交中击败了90.50% 的用户
     * 内存消耗 : 36.2 MB, 在Maximum Depth of Binary Tree的Java提交中击败了73.86% 的用户
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int leftMax = 1 + maxDepth(root.left);
        int rightMax = 1 + maxDepth(root.right);
        return Math.max(leftMax, rightMax);
    }
}
