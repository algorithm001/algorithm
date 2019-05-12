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
var findSecondMinimumValue = function(root) {
  if (!root) {
    return -1
  }
  let rootValue = root.val
  return findExceptRootMiniValue(root, rootValue)
};

const findExceptRootMiniValue = (root, rootValue) => {
  if (!root.left) {
    return root.val === rootValue ? -1 : root.val
  }
  let leftExceptRootMiniValue = findExceptRootMiniValue(root.left, rootValue)
  let rightExceptRootMiniValue = findExceptRootMiniValue(root.right, rootValue)
  if (leftExceptRootMiniValue === -1 && rightExceptRootMiniValue === -1) {
    return -1
  }
  if (leftExceptRootMiniValue === -1) {
    return rightExceptRootMiniValue
  }
  if (rightExceptRootMiniValue === -1) {
    return leftExceptRootMiniValue
  }
  return leftExceptRootMiniValue > rightExceptRootMiniValue ? rightExceptRootMiniValue : leftExceptRootMiniValue
}

