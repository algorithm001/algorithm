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
   
    int last = -1000000;
    int res = 1000000;
    public int minDiffInBST(TreeNode root) {
        if (root == null) {
            return 0;
        }
        minDiffInBST(root.left);
        res = Math.min(root.val - last, res);
        last = root.val;
        minDiffInBST(root.right);
        return res;
    }
    
    
    //此答案对应题目：返回相邻两节点差的最小值。
    public int minDiffInBST1(TreeNode root) {
        int minDiff=getDiff(root,0);
        return minDiff;     
    }
    
    public int getDiff(TreeNode root,int val){
        if(root!=null){
            int currentMin=Math.abs(root.val-val);
            if(root.left!=null){
              currentMin=Math.min(getDiff(root.left,root.val),currentMin);
            }
            if(root.right!=null){
                 currentMin=Math.min(getDiff(root.right,root.val),currentMin);
            }
           
            return currentMin;
        }else{
            return Integer.MAX_VALUE;
        }
       
    }
}