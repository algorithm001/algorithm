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
        public TreeNode LowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
        {
            if(root == null||root == p||root==q)
            {
                return root;
            }
            bool b1 = FindValue(root.left, p);
            bool b2 = FindValue(root.left, q);
            bool b3 = FindValue(root.right, p);
            bool b4 = FindValue(root.right, q);
            if(!b1==b2&&!b3==b4)
            {
                return root;
            }else
            {
                TreeNode node;
                if(root.left!=null)
                {
                    node = LowestCommonAncestor(root.left, p, q);
                    if(node!=null)
                    {
                        return node;
                    }
                }

                if (root.right != null)
                {
                    node = LowestCommonAncestor(root.right, p, q);
                    if (node != null)
                    {
                        return node;
                    }
                }
            }
            return null;
        }

        public bool FindValue(TreeNode node, TreeNode v)
        {
            if (node == null)
            {
                return false;
            }
            if (node == v)
            {
                return true;
            }
            else
            {
                return (node.left == null ? false : FindValue(node.left, v)) || (node.right == null ? false : FindValue(node.right, v));
            }
        }
}
