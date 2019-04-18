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
    int max =0;
    public int longestUnivaluePath(TreeNode root) {
        if(root==null){
            return 0;
        }
        maxL(root);
        return max;
    }
    
    public int maxL(TreeNode root){
        int leftL=0;
        int rightL=0;
        
        if(root.left!=null){
           if(root.left.val==root.val){
               leftL=1+maxL(root.left);
           }else{
               maxL(root.left);
           }
        }
        if(root.right!=null){
           if(root.right.val==root.val){
               rightL=1+maxL(root.right);
           }else{
               maxL(root.right);
           }
        }
        if((rightL+leftL)>max){
            max=rightL+leftL;
        }
        int result=0;
        if(rightL>leftL){
            result=rightL;
        }else{
            result=leftL;
        }
        return result;
    }
}
