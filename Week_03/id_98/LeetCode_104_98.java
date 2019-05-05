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
        
	   if( null == root ){
		   return 0;
	   }
	   
	   return 1+ Math.max(maxDepth(root.left) ,maxDepth(root.right));
   
        
    }
}