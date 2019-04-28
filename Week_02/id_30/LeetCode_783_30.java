package com.shufeng.algorithm.d0_;

/**
 * @author gsf
 */
public class LeetCode_783_30 {

    public static void main(String[] args) {
        TreeNode bst = new TreeNode(4);
        bst.left = new TreeNode(2);
        bst.right = new TreeNode(6);
        bst.left.left = new TreeNode(1);
        bst.left.right = new TreeNode(3);

        int i = minDiffInBST(bst);
        System.out.println(i);
    }

    public static int minDiffInBST(TreeNode root) {
        if (root == null) {
            return -1;
        }
        List<Integer> list = new ArrayList<>();
        minDiffInBST(root, list);
        int num = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            num = Math.min(num, list.get(i) - list.get(i - 1));
        }
        return num;
    }

    public static void minDiffInBST(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        minDiffInBST(root.left, list);
        list.add(root.val);
        minDiffInBST(root.right, list);
    }
}