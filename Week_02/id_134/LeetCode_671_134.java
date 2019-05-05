//https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private int first = Integer.MAX_VALUE;
    private int second = Integer.MAX_VALUE;
    private boolean flag = false;
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null)
            return -1;
        travsing(root);
        return flag?second:-1;
    }
    
    public void travsing(TreeNode node) {
        if (node == null)
            return ;
        if (node.val < first)
            first = node.val;
        if (node.val <= second && node.val > first) {
            second = node.val;
            flag = true;
        }
        travsing(node.right);
        travsing(node.left);
    }
}