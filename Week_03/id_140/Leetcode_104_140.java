/**
 * Given a binary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its depth = 3.
 */
public class Leetcode_104_140 {

    public int maxDepth(TreeNode root) {
        return(depth(root, 0));
    }

    int depth(TreeNode node, int depth) {
        if(node == null) return depth;
        return Math.max(depth(node.left, depth+1), depth(node.right, depth+1));
    }

    public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
  }
}
