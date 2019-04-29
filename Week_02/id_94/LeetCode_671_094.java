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
     return traversal(root,root.val);
    }
    
    private int traversal(TreeNode root,int value){
        if(root == null){
            return -1;
        }
        if(root.val > value){
            return root.val;
        }
        // 寻找左右子节点中，第一个大于自己的节点
        int l = traversal(root.left,value);
        int r = traversal(root.right,value);

        // 存在两个子节点
        if(l>=0 && r>=0){
            return Math.min(l,r);
        }
        //　存在0个子节点
        return Math.max(l,r);
    }
}