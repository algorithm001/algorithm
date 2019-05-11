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
    int first = -1;
    int second = -1;
    public int FindSecondMinimumValue(TreeNode root) {
        A(root);
        return second;
    }
    
    public void A(TreeNode root)
    {
        if(root == null)
        {
            return;
        }
                
        int a = root.val;
        if(a < first || first == -1)
        {
            var temp = first;
            first = a;
            if(temp < second)
            {
                second = temp;
            }
        }
        
        if(a > first && (a < second || second == -1))
        {
            second = a;
        }
        A(root.left);
        A(root.right);
    }
}
