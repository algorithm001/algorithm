/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * 671. 二叉树中第二小的节点
 * https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree/submissions/
 * 使用前序遍历，递归实现
 * @param {TreeNode} root
 * @return {number}
 */
var findSecondMinimumValue = function(root) {
  
    if (root == null) { return -1; }
    
    return (function findMin(node, val) {
      if (node == null) { return -1; } // 递归终止条件，节点为空
      if (node.val > val) { return node.val; } // 递归终止条件，当子节点大于父节点则返回子节点的值
      const l = findMin(node.left, val); // 前序遍历左子树
      const r = findMin(node.right, val); // 前序遍历右子树
      
      // 有左右子节点则求两者最小值，否则求两者最大值
      return l >= 0 && r >= 0 ? Math.min(l, r) : Math.max(l, r);
    }(root, root.val));
    
  };