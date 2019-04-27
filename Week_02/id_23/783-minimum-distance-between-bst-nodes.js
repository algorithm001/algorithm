/**
 * https://leetcode.com/problems/minimum-distance-between-bst-nodes/
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
var minDiffInBST = function(root) {
  // inOrderTraversal will be better O(n)
  // while... this solution  O(2^n)

  if (null === root) {
    return Number.MAX_SAFE_INTEGER;
  }

  const getClosestMax = root => {
    if (null === root || null === root.right) {
      return Number.MAX_SAFE_INTEGER;
    }
    root = root.right;

    while (root !== null) {
      if (root.left === null) {
        return root.val;
      }
      root = root.left;
    }
  };

  const getClosestMin = root => {
    if (null === root || null === root.left) {
      return Number.MIN_SAFE_INTEGER;
    }

    root = root.left;

    while (root !== null) {
      if (root.right === null) {
        return root.val;
      }
      root = root.right;
    }
  };

  const findMin = root => {
    if (null === root) {
      return Number.MAX_SAFE_INTEGER;
    }

    const val = root.val;
    const max = getClosestMax(root);
    const min = getClosestMin(root);

    return Math.min(max - val, val - min);
  };

  const result = findMin(root);
  if (1 === result) {
    return 1;
  }

  return Math.min(result, minDiffInBST(root.left), minDiffInBST(root.right));
};
