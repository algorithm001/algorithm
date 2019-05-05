/**[二叉树][简单]
给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么这个节点的值不大于它的子节点的值。 
给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
示例 1:
输入: 
    2
   / \
  2   5
     / \
    5   7
输出: 5
说明: 最小的值是 2 ，第二小的值是 5 。

示例 2:
输入: 
    2
   / \
  2   2
输出: -1
说明: 最小的值是 2, 但是不存在第二小的值。
*/

/*
思路1：
由于节点的值不大于它的子节点的值，题目所求目标与树的根节点与其左右子节点的相关情况有关，分情况讨论
如果三个节点都相等，则目标值是左子树中第二小值和右子树第二小值中取小
如果根等于左子节点且不等于右子节点，则目标值是左子树中第二小值和右子节点取小
如果根等于右子节点且不等于左子节点，则目标值是右子树中第二小值和左子节点取小
如果根不等于左子节点且不等于右子节点，则目标值是左子节点和右子节点取小

问题的求解和子问题的求解相同，自然想到用递归实现。

*/
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
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null || root.left == null) return -1;
        int secondMin;
        int leftMin;
        int rightMin;
        
        //判断根节点和左右节点的相等情况
        if(root.val == root.left.val && root.val == root.right.val){
            leftMin = findSecondMinimumValue(root.left); 
            rightMin = findSecondMinimumValue(root.right);
        }else if(root.val == root.left.val){
            leftMin = findSecondMinimumValue(root.left); 
            rightMin = root.right.val;
        }else if(root.val == root.right.val){
            leftMin = root.left.val; 
            rightMin = findSecondMinimumValue(root.right);
        }else{
            leftMin = root.left.val; 
            rightMin = root.right.val;
        }
        
        //确定返回值
        if(leftMin == -1 && rightMin == -1){
            return -1;
        }else if(leftMin == -1){
            return rightMin;
        }else if(rightMin == -1){
            return leftMin;
        }else{
            return leftMin < rightMin ? leftMin : rightMin;
        }
        
    }
}