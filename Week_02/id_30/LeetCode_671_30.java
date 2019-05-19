package com.shufeng.algorithm.d0_;

/**
 * @author gsf
 */
public class LeetCode_671_30 {

    public static void main(String[] args) {
        TreeNode bst = new TreeNode(2);
        bst.left = new TreeNode(2);
        bst.right = new TreeNode(5);
        bst.right.right = new TreeNode(5);
        bst.right.left = new TreeNode(7);
        int secondMinimumValue = findSecondMinimumValue(bst);
        System.out.println(secondMinimumValue);
    }

    public static int findSecondMinimumValue(TreeNode root) {
        return recursive(root);
    }

    public static int recursive(TreeNode root) {
        if (root == null || root.left == null || root.right == null) {
            return -1;
        }
        int left = root.val == root.left.val ? recursive(root.left) : root.left.val;
        int right = root.val == root.right.val ? recursive(root.right) : root.right.val;
        return (left == -1 || right == -1) ? Math.max(left, right) : Math.min(left, right);
    }
}
