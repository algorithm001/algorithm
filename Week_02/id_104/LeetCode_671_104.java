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
    public int findSecondMinimumValue(TreeNode root) {
        //找到第一个小于此节点的值既可以 
        int result=getMin(root,root.val);
        return result;
    }
    
    
    /**
    ** 获取第二最小值 
    */
    public int getMin(TreeNode tree,int val){
        
        if(tree.val!=val){
            return tree.val;
        }
        
        if(tree.left==null){
            return -1;
        }
        
        if(tree.right==null){
            return -1;
        }
        
        int l=getMin(tree.left,val);
        int r=getMin(tree.right,val);
        
        if(l==-1 && r==-1){
            return -1;
        }
        
        if(l!=-1 && r!=-1){
            return Math.min(l,r);
        }
        
        return l+r+1;
        
    }
}