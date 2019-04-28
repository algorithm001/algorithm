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
    List<Integer> list = new ArrayList<>();
    
    public int minDiffInBST(TreeNode root) {
        inOrder(root);
        int result = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); ++i) {
            result = Math.min(list.get(i) - list.get(i - 1), result);
            if (result == 1) {
                break;
            }
        }

        return result;
    }
    
    public void inOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        inOrder(treeNode.left);
        list.add(treeNode.val);
        inOrder(treeNode.right);

    }
}