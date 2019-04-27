//https://leetcode.com/problems/range-sum-of-bst/
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
    private int sum = 0;
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (L > R)
            return 0;
        traversing(root, L, R);
        return sum;
    }
    
    public void traversing(TreeNode node, int L, int R) {
        if (node == null)
            return;
        if (node.val >= L && node.val <= R)
            sum += node.val;
        traversing(node.left, L, R);
        traversing(node.right, L, R);
    }
}