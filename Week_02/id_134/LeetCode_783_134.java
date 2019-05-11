//https://leetcode.com/problems/minimum-distance-between-bst-nodes/
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
    private int ret = Integer.MAX_VALUE;
    private int prevVal = 0;
    private boolean flag = true;
    public int minDiffInBST(TreeNode root) {
        traversing(root);
        return ret;
    }
    
    public void traversing(TreeNode node) {
        if (node == null)
            return;
        traversing(node.left);
        if (!flag) {
            int curDis = node.val - prevVal;
            if (curDis < ret)
                ret = curDis;
        }
        prevVal = node.val;
        flag = false;
        traversing(node.right);
    }
}