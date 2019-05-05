static private int max(int x, int y){
        return x > y ? x : y;
    }
    static int maxDepth(BinaryTree.TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null)    return 1;
        return max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }