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
    int result ;
    public int longestUnivaluePath(TreeNode root) {
        result = 0;
        longestLength(root);
        return result;
    }

    public int longestLength(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = longestLength(node.left);
        int right = longestLength(node.right);
        int arrLeft = 0;
        int arrRight = 0;
        if(node.left != null && node.left.val == node.val){
            arrLeft += left + 1;
        }
        if(node.right != null && node.right.val == node.val){
            arrRight += right + 1;
        }
        result = Math.max(result,arrLeft + arrRight);
        return Math.max(arrLeft,arrRight);
    }
}