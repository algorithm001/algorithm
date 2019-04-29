/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//second-minimum-node-in-a-binary-tree(二叉树-简单)
 //前序遍历二叉树，取出比根节点大的最小值
class Solution {
	//初始化最小值
    int min = -1;
	//初始化第二小的值
    int penult = -1;
    public int findSecondMinimumValue(TreeNode root) {
        if(root == null) return -1;
        if(root.left == null && root.right == null) return -1;
		//根据题目描述，根节点的值是最小值
        min = root.val;
		//遍历二叉树
        findSecondMinValue(root);
        return penult;
    }
    
    public void findSecondMinValue(TreeNode node){
        if(node.val > min){
            if(penult == -1) penult = node.val;
            penult = Math.min(penult,node.val);
        }
        if(node.left != null)findSecondMinValue(node.left);
        if(node.right != null)findSecondMinValue(node.right);
    }
}



//用分治思想，把大的二叉树分解为以两层节点为结构的最小化二叉树求解
class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        if(root == null) return -1;
        int min = root.val;
        int result = findSecondnumValue(root,root.val);
        return result;
    }
    
    public int findSecondnumValue(TreeNode root,int min){
        if(root == null) return -1;
        if(root.val > min) return root.val;
		//根据题目描述，剩下的root.val只有和min相等的情况，继续递归找比min大的值
        int left = findSecondnumValue(root.left,min);
        int right = findSecondnumValue(root.right,min);
		//找出最小化二叉树中第二小的值
        return (left == -1 || right == -1) ? Math.max(left,right) : Math.min(left,right);
    }
}