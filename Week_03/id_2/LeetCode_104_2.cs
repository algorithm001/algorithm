/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int MaxDepth(TreeNode root) {
        if(root == null)
        {
            return 0;
        }
        
        var left = MaxDepth(root.left);
        var right = MaxDepth(root.right);
        
        return (left >= right ? left : right) + 1;
    }
}
