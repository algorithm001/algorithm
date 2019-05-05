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
    private int max = 0;
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        findMax(root,0);
        return max;
    }
    private void findMax(TreeNode root,int depth){
        if(root == null){
            if(depth > max){
                max = depth;
            }
            return ;
        }
        depth ++;
        findMax(root.left,depth);
        findMax(root.right,depth);
    }
}