/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * 938. 二叉搜索树的范围和
 * https://leetcode-cn.com/problems/range-sum-of-bst/
 * BST后序遍历，递归实现
 * @param {TreeNode} root
 * @param {number} L
 * @param {number} R
 * @return {number}
 */
var rangeSumBST = function(root, L, R) {
    if (root === null) { return 0; }
    
    if (root.val < L) {
      return rangeSumBST(root.right, L, R);
    }
    if (root.val > R) {
      return rangeSumBST(root.left, L, R);
    }
    
    return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
  };
  
  /**
   * 938. 二叉搜索树的范围和
   * https://leetcode-cn.com/problems/range-sum-of-bst/
   * BST前序遍历，递归实现
   * @param {TreeNode} root
   * @param {number} L
   * @param {number} R
   * @return {number}
   */
  var rangeSumBST = function(root, L, R) {
    var sum = 0;
    function inOrder(node, L, R) {
      if (node === null) { return 0; }
      if (node.val >= L && node.val <= R) {
        sum += node.val;
      }
      inOrder(node.left, L, R)
      inOrder(node.right, L, R)
      
      return sum;
    }
    
    return inOrder(root, L, R);
  };