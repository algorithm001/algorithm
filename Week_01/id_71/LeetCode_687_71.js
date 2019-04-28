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
var longestUnivaluePath = function (root) {
  let max = [0]
  t(root, max)
  return max[0]
};

var t = function (root, max) {

  if (!root) {
    return 0
  }

  let leftLongestUnivaluePath = t(root.left, max)
  let rightLongestUnivaluePath = t(root.right, max)

  if (root.left && root.right && root.left.val === root.val && root.right.val === root.val) {
    let currentLongestUnivaluePath = leftLongestUnivaluePath + rightLongestUnivaluePath + 2
    if (max[0] < currentLongestUnivaluePath) {
      max[0] = currentLongestUnivaluePath
    }
    return leftLongestUnivaluePath + 1 > rightLongestUnivaluePath + 1 ? leftLongestUnivaluePath + 1 : rightLongestUnivaluePath + 1
  }

  if (root.left && root.right && root.left.val !== root.val && root.right.val !== root.val) {
    let currentLongestUnivaluePath = Math.max(leftLongestUnivaluePath, rightLongestUnivaluePath)
    if (max[0] < currentLongestUnivaluePath) {
      max[0] = currentLongestUnivaluePath
    }
    return 0
  }

  if (root.left && root.left.val === root.val) {
    leftLongestUnivaluePath += 1
    if (leftLongestUnivaluePath >= rightLongestUnivaluePath) {
      if (max[0] < leftLongestUnivaluePath) {
        max[0] = leftLongestUnivaluePath
      }
    } else {
      if (max[0] < rightLongestUnivaluePath) {
        max[0] = rightLongestUnivaluePath
      }
    }
    return leftLongestUnivaluePath
  }

  if (root.right && root.right.val === root.val) {
    rightLongestUnivaluePath += 1
    if (rightLongestUnivaluePath >= leftLongestUnivaluePath) {
      if (max[0] < rightLongestUnivaluePath) {
        max[0] = rightLongestUnivaluePath
      }
    } else {
      if (max[0] < leftLongestUnivaluePath) {
        max[0] = leftLongestUnivaluePath
      }
    }
    return rightLongestUnivaluePath
  }

  return 0
}
