
    

    public int longestUnivaluePath(TreeNode root) {
        return longestPath(root);
    }


    public int longestPath(TreeNode node){
        if (node == null){
            return 0;
        }

        // 节点值与左右子节点值相同，路径=左+右+2
        if (node.left!=null && node.right!=null && node.val==node.left.val && node.val==node.right.val){
            return longestPath(node.left) + longestPath(node.right) + 2;
        }

        // 节点值与左子节点值相同，路径=max(左+1, 右)
        if (node.left!=null && node.val==node.left.val){
            return Math.max(longestPath(node.left)+1, longestPath(node.right));
        }

        // 节点值与右子节点值相同，路径=max(左, 右+1)
        if (node.right!=null && node.val==node.right.val){
            return Math.max(longestPath(node.right)+1, longestPath(node.left));
        }

        // 节点值与左右子节点值都不相同，路径=max(左，右)
        return Math.max(longestPath(node.left), longestPath(node.right));

    }