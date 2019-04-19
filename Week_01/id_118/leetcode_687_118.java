/**
 * https://leetcode-cn.com/problems/longest-univalue-path/
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    int result;
    
    public int longestUnivaluePath(TreeNode root) {
        result = 0;
        longestUnivaluePathByRoot(root);
        return result;
    }
    

    // 从 root 向下的最长同值路径。
    public int longestUnivaluePathByRoot(TreeNode root){
        if(null==root){
            return 0;
        }
        
        int left = longestUnivaluePathByRoot(root.left);
        int right  = longestUnivaluePathByRoot(root.right);
        int arrowLeft = 0, arrowRight = 0;
        
        if(root.left!=null && root.left.val==root.val){
            arrowLeft += left + 1;
        }
        if(root.right!=null && root.right.val==root.val){
            arrowRight += right + 1;
        }
        
        result = Math.max(result, arrowLeft + arrowRight);
        return arrowLeft+arrowRight;
    }
    
}
