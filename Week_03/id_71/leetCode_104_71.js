/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */
var maxDepth = function(root) {
  if (root === null) {
    return 0
  }
  let leftMaxDepth = maxDepth(root.left)
  let rightMaxDepth = maxDepth(root.right)
  return (leftMaxDepth > rightMaxDepth ? leftMaxDepth : rightMaxDepth) + 1
};
