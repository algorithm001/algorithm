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
	  return traversal(root, root.val);
    }
	
   private static int traversal(TreeNode root, int rootVal) {
        if (root == null) {
            return -1;
        }
        if (root.val > rootVal) {
            return root.val;
        }

        int l = traversal(root.left, rootVal); // 遍历左节点值是否有大于根节点的值  3
        System.out.println("left ----> " + l);
        int r = traversal(root.right, rootVal); // 遍历右节点值是否有大于根节点的值 7
        System.out.println("right --->" + r);
        // 如果左右节点都比跟节点大的话，取最小的
        if (l >= 0 && r >= 0) {
            return Math.min(l, r);
        }
        // 否则取最大的
        return Math.max(l, r);
   }    
}
