/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/submissions/
// 236.二叉树的最近公共祖先
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        // root有任何一个是根节点，则它本身就是最近公共祖先
        if(p==root || q==root){
            return root;
        }
        
        // 判断：p和q在不在左子树上
        boolean pLeft = find(root.left,p);
        boolean qLeft = find(root.left,q);
        
        if(pLeft && qLeft){
            // 都在左子树
            return lowestCommonAncestor(root.left,p,q);
        }else if(!pLeft && !qLeft){
            // 都在右子树
            return lowestCommonAncestor(root.right,p,q);
        }else{
            // 一个在左子树，一个在右子树，则当前节点就是最近公共祖先。
            return root;
        }
        
    }
    
    // 检查 root这棵树中，是否有节点x
    boolean find(TreeNode root, TreeNode x){
        if(root==null){
            return false;
        }
        if(root==x){
            return true;
        }
        if(root.left==null && root.right==null){
            return false;
        }else if(root.left==null && root.right!=null){
            return find(root.right,x);
        }else if(root.left!=null && root.right==null){
            return find(root.left,x);
        }else{
            return find(root.left,x) || find(root.right,x);
        }        
    }
}
