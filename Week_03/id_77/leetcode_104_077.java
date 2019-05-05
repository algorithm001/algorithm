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
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }
    
    public int max (int a,int b){
        return a > b ? a : b;
    }    
    
}