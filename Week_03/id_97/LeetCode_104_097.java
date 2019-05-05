
public class Solution{

	public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }

        int leftMaxDepth = maxDepth(root.left); //求左子树的最大深度
        int rightMaxDepth = maxDepth(root.right); //求当前节点的右子树最大深度

        return Math.max(leftMaxDepth,rightMaxDepth) + 1;
    }
}

