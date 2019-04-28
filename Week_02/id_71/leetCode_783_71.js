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
let minDiffInBST = function(root) {
  let treeArray = new Array()
  treeToArray(root, treeArray)
  let minDiff = -1
  let beforeValue = -1
  for(let i = 2; i < treeArray.length; i++) {
    if (!treeArray[i]) {
      continue
    }
    if (beforeValue === -1) {
      beforeValue = i
      continue
    }
    if (minDiff === -1) {
      minDiff = i - beforeValue
    } else {
      minDiff = i - beforeValue < minDiff ? i - beforeValue : minDiff
    }
    beforeValue = i
  }
  return minDiff
};

let treeToArray = (root, treeArray) => {
  if (root === null) {
    return
  }
  treeArray[root.val] = 1
  treeToArray(root.left, treeArray)
  treeToArray(root.right, treeArray)
}
