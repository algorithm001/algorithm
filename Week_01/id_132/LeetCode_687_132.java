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
    /*
    最长同值路径，需要比较以不同节点为根节点时的最长同值路径，取最大值。
    以某节点为根节点时的最长同值路径 = 以其左孩子为根节点的最长同值路径 + 以其右孩子为根节点的最长同值路径。
    注意，分支节点的最长同值路径也可以理解为最大同值深度
    */
    int maxP = 0;
    public int longestUnivaluePath(TreeNode root) {
        if(root == null) return 0;
        getMaxP(root,root.val);
	    return maxP;
	}
	private int getMaxP(TreeNode root, int val){
        if(root == null) return 0;
        int left = getMaxP(root.left, root.val);
        int right = getMaxP(root.right, root.val);
        maxP = Math.max(maxP,left+right);
        if(root.val == val)
            //其左右子树的最大同值路径中较长的那个加上该节点后继续向父节点回溯构成最长同值路径
            return Math.max(left,right)+1;
        return 0;
    } 
}