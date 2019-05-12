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
    int sum;

    public int longestUnivaluePath(TreeNode root) {
        sum = 0;
        childLength(root);
        return sum;
    }

    public int childLength(TreeNode node) {
        if (node == null) return 0;
        int LeftChildLength = childLength(node.left);
        int RightChildLength = childLength(node.right);
        int LeftLength;
        int RightLength;
        if(node.left != null && node.left.val == node.val){
            LeftLength = LeftChildLength + 1;
        }else {
            LeftLength = 0;
        }
        if(node.right !=null && node.right.val == node.val){
            RightLength = RightChildLength + 1;
        }else{
            RightLength = 0;
        }

        sum = Math.max(sum, LeftLength + RightLength);
        return Math.max(LeftLength, RightLength);
    }
}