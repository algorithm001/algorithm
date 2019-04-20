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
    
    int ans;
    
    public int longestUnivaluePath(TreeNode root) {
        ans = 0;
        longestUnivaluePathByRoot(root);
        return ans;
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
        
        ans = Math.max(ans, arrowLeft + arrowRight);
        return Math.max(arrowLeft, arrowRight);
    }
    
}
