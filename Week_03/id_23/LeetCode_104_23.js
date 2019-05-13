/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */
var maxDepth = function(root) {
  if(null===root){
      return 0;
  }
  return 1+Math.max(maxDepth(root.left),maxDepth(root.right))
};