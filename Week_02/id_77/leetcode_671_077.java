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

       return findSecondMinVal(root,root.val);
        
    }
    

    
public int findSecondMinVal(TreeNode root,int val){
        if(root.val > val){
            return root.val;
        }else if(root.left != null){
            int leftMin = findSecondMinVal(root.left,val);
            int rightMin = findSecondMinVal(root.right,val);
            if(leftMin == -1){
                return rightMin;
            }else if(rightMin == -1){
                return leftMin;
            }else{
                return leftMin < rightMin ? leftMin : rightMin;
            }
           
        }else{
            return -1;
        }
    }
}