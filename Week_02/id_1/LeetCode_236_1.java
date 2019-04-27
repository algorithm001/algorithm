class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 自己没做出来，参考的 discuss 里面的解法：
        // 原答案：https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/discuss/65226/My-Java-Solution-which-is-easy-to-understand
        if(root == null || root == p || root == q) {
            return root;
        }  
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left != null && right != null) {
            return root;
        }   
        return left != null ? left : right;
    }
}