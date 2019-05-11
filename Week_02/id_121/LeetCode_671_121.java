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
    private int[] result  = new int[2];
    public int findSecondMinimumValue(TreeNode root) {
        for(int i = 0;i < 2; i ++){
            result[i] = -1;
        }
        travelTree(root);
        for(int i = 0;i < 2; i ++){
            if(result[i] == -1){
                return -1;
            }
            if(i == 1){
                return result[i];
            }
        }
        return -1;
    }
    private void travelTree(TreeNode root){
        if(root == null){
            return ;
        }
        for(int i = 0;i < 2;i ++){
            if(result[i] == root.val){
                break;
            }
            if(result[i] == -1){
                result[i] = root.val;
                break;
            }
            if(root.val < result[i]){
                moveToBack(i);
                result[i] = root.val;
                break;
            }
        }
        travelTree(root.left);
        travelTree(root.right);
    }
    private void moveToBack(int start){
        for(int i = result.length - 2; i >= start;i --){
            result[i+1] = result[i];
        }
    }
}