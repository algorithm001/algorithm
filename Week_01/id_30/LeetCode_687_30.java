package com.shufeng.algorithm.d0_;

/**
 * @author gsf
 */
public class LeetCode_687_30 {

    public static void main(String[] args) {
        TreeNode bst = new TreeNode(1);
        bst.left = new TreeNode(4);
        bst.right = new TreeNode(5);
        bst.left.left = new TreeNode(4);
        bst.left.right = new TreeNode(4);
        bst.right.left = new TreeNode(5);

        int i = longestUnivaluePath(bst);
        System.out.println(i);
    }
    public static int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int max = Math.max(longestUnivaluePath(root.left), longestUnivaluePath(root.right));
        return Math.max(max, recursion(root.left, root.val) + recursion(root.right, root.val));
    }
    public static int recursion(TreeNode node, int pVal) {
        if (node == null || node.val != pVal) {
            return 0;
        }
        return Math.max(recursion(node.left, node.val), recursion(node.right, node.val)) + 1;
    }

}
