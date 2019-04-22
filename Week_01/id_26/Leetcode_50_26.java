// Source : https://leetcode.com/problems/powx-n/
// Id     : 50
// Author : Fanlu Hai
// Date   : 2018-04-18
// I was trying to slove leetcode 50 but had a little differences with the problem itself
// It seems in leetcode 50 the path must be linear, which means it only have two ends,
// which requires different methods to calculate as mine will count all the linked univalue nodes.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class LongestUnivaluePathWithDifferences {
    private int maxLength = 0;

    public int longestUnivaluePath(TreeNode root) {

        preOrderTraverse(root);
        return maxLength;
    }

    // get path count of each node
    public int treePath(TreeNode root) {
        int pathCount =0;

        if (null == root)
            return 0;
        if (null != root.left && root.val == root.left.val) {
            pathCount += 1 + treePath(root.left);
        }
        if (null != root.right && root.val == root.right.val) {
            pathCount += 1 + treePath(root.right);
        }
        return pathCount;
    }

    public void preOrderTraverse(TreeNode root) {

        if (null == root)
            return;
        int tmp = treePath(root);
//        System.out.println("node value: " + root.val + " | path count value: " + tmp);
        if (tmp > maxLength) {
            maxLength = tmp;
        }
        preOrderTraverse(root.left);
        preOrderTraverse(root.right);
    }

    public static void main(String[] args) {
        LongestUnivaluePathWithDifferences longestUnivaluePath = new LongestUnivaluePathWithDifferences();
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(5);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(4);
        TreeNode treeNode6 = new TreeNode(5);
        TreeNode treeNode7 = new TreeNode(4);
        TreeNode treeNode8 = new TreeNode(4);
        TreeNode treeNode9 = new TreeNode(4);
        TreeNode treeNode10 = new TreeNode(5);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.right = treeNode6;
        treeNode4.left = treeNode7;
        treeNode4.right = treeNode8;
        treeNode5.left = treeNode9;
        treeNode6.left = treeNode10;

        longestUnivaluePath.preOrderTraverse(treeNode1);
        System.out.println(longestUnivaluePath.longestUnivaluePath(treeNode1));

    }
}


