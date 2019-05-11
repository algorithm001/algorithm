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
    int last = -1;
    int min = int.MaxValue;
    public int MinDiffInBST(TreeNode root) {
        A(root);
        return min;
    }
    
    void A(TreeNode root)
    {
        if(root == null)
        {
            return;
        }
        A(root.left);
        if(last != -1)
        {
            int temp;
            if(root.val > last)
            {
                temp = root.val - last;
            }
            else
            {
                temp = last - root.val;
            }
            if(temp < min)
            {
                min = temp;
            }
        }
        last = root.val;
        A(root.right);
    }
}
