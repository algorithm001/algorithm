/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree/
// 671.二叉树中第二小的节点
class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        // 根节点一定是最小值
        // 若树中所有节点同值，则没有第二小
        // 若树中根节点和子节点值不同，则第二小要么在左子树，要么在右子树
        
        if(root == null || (root.left == null && root.right == null)){
            return -1;
        }
        
        int val_root = root.val;
        int val_left = root.left.val;
        int val_right = root.right.val;
        
        if(val_root!=val_left && val_root!=val_right){
            // 左右子树根节点均与当前根节点不等值，则其一就是第二小
            return getMinOne(val_left,val_right);
        }else if(val_root==val_left && val_root!=val_right){
            // 左子树根节点与当前根节点同值，右子树根节点与当前根节点不同值，则左子树取第二小，与右子树根节点比。
            // 注意，左子树如果没有第二小，会返回负数
            return getMinOne(findSecondMinimumValue(root.left),val_right);
        }else if(val_root!=val_left && val_root==val_right){
            // 类似上面的
            return getMinOne(val_left,findSecondMinimumValue(root.right));
        }else{
            return getMinOne(findSecondMinimumValue(root.left),findSecondMinimumValue(root.right));
        }  
        
    }
    
    int getMinOne(int x,int y ){
        if(x==-1 && y==-1){
            return -1;
        }else if(x==-1 && y!=-1){
            return y;
        }else if(x!=-1 && y==-1){
            return x;
        }else{
            return Math.min(x,y);
        }
    }
}
