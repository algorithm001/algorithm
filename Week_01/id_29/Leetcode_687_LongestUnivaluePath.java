package leetcode.Algorithms._601_700._687_LongestUnivaluePath;

/**
 * Created by jialei.zou on 2019/4/19 .
 ref:
 https://leetcode.com/problems/longest-univalue-path/

 Given a binary tree, find the length of the longest path where each node in the path has the same value.
 This path may or may not pass through the root.

 The length of path between two nodes is represented by the number of edges between them.



 Example 1:

 Input:

      5
     / \
   4   5
  / \   \
 1   1   5
 Output: 2



 Example 2:

 Input:

      1
     / \
    4   5
   / \   \
  4   4   5
 Output: 2



 Note: The given binary tree has not more than 10000 nodes. The height of the tree is not more than 1000.

 */
public class LongestUnivaluePath {

    private int result = 0;

    public int longestUnivaluePath(TreeNode root) {
        helper(root);
        return result;
    }

    private int helper(TreeNode root){
        if(root == null || (root.left == null && root.right == null)){
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        if(root.left != null && root.left.val == root.val){
            left = left + 1;
        }else {
            left = 0;
        }
        if(root.right != null && root.right.val == root.val){
            right = right + 1;
        }else {
            right = 0;
        }
        result = Math.max(result, left+right);
        return left>right? left:right;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(5);
        TreeNode node7 = new TreeNode(1);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        LongestUnivaluePath path = new LongestUnivaluePath();
        System.out.println(path.longestUnivaluePath(node1));

    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
