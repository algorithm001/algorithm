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

  /**
      注意p,q必然存在树内, 且所有节点的值唯一!!!
      递归思想, 对以root为根的(子)树进行查找p和q, 如果root == null || p || q 直接返回root
      表示对于当前树的查找已经完毕, 否则对左右子树进行查找, 根据左右子树的返回值判断:
      1. 左右子树的返回值都不为null, 由于值唯一左右子树的返回值就是p和q, 此时root为LCA
      2. 如果左右子树返回值只有一个不为null, 说明只有p和q存在与左或右子树中, 最先找到的那个节点为LCA
      3. 左右子树返回值均为null, p和q均不在树中, 返回null
      **/
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		if(null == root || p == root || q == root) return root;

		TreeNode left = lowestCommonAncestor(root.left,p,q);
		TreeNode right = lowestCommonAncestor(root.right,p,q);

		if(null == left && null == right) return null;
		else if(null != left && null != right) return root;
		else return left == null?right:left;


    }
}
