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
    let a = root.val 
    
    let trace = (root) => {
        if (root === null) {
            return -1
        }
        if (root.val > t) {
            return root.val
        }
        if (root.val === t) {
            let left = trace(root.left)
            let right = trace(root.right)
            if (left <0 ) return right;
            if (right< 0 ) return left;
            return Math.min(left, right);
        }
        
        
    }
    let b = trace(root)
    return b  
};