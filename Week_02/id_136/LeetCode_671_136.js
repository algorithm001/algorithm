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
    let t = root.val
    let find = (root) => {
        if (root === null) {
            return -1
        }
        if (root.val > t) {
            return root.val
        }
        if (root.val === t) {
            let left = find(root.left)
            let right = find(root.right)
            if (left <0 ) return right;
            if (right< 0 ) return left;
            return Math.min(left, right);
        }
        
        
    }
      return find(root)
};