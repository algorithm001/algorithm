/**
 * 
 */
static BinaryTree.TreeNode lowestCommonAncestor(BinaryTree.TreeNode root, BinaryTree.TreeNode p, BinaryTree.TreeNode q) {
    if (root == p) return p;
    if (root == q) return q;
    if (root.left != null && root.right != null) {
        if ((BinaryTree.isHave(root.left, p) && BinaryTree.isHave(root.right, q)) || (BinaryTree.isHave(root.right, p) && BinaryTree.isHave(root.left, q))) return root;
        if (BinaryTree.isHave(root.left, p) && BinaryTree.isHave(root.left, q)) return lowestCommonAncestor(root.left, p, q);
        if (BinaryTree.isHave(root.right, p) && BinaryTree.isHave(root.right, q)) return lowestCommonAncestor(root.right, p, q);
    }
    return null;
}