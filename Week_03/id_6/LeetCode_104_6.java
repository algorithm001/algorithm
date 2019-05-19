

    // LeetCode 104

    // [ 1. DFS ]

    
    // maxDepth = max(left, right) + 1
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return 1 + Math.max(left, right);
    }
    