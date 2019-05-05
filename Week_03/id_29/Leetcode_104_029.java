package leetcode.Algorithms._101_200._104_MaximumDepthOfBinaryTree;

import leetcode.Algorithms._101_200._103_BinaryTreeZigzagLevelOrderTraversal.BinaryTreeZigzagLevelOrderTraversal;

import java.util.List;

/**
 * 
 ref: https://leetcode.com/problems/maximum-depth-of-binary-tree/

 Given a binary tree, find its maximum depth.

 The maximum depth is the number of nodes along the
 longest path from the root node down to the farthest leaf node.

 Note: A leaf is a node with no children.

 Example:

 Given binary tree [3,9,20,null,null,15,7],

 3
 / \
 9  20
 /  \
 15   7
 return its depth = 3.

 todo 有空在看一下ref：
 https://leetcode.com/problems/maximum-depth-of-binary-tree/discuss/34195/Two-Java-Iterative-solution-DFS-and-BFS

 */
public class MaximumDepthOfBinaryTree {

    private static int max;

    public static int maxDepth(TreeNode root) {
        max = 0;
        traverse(root, 0);
        return max;
    }

    private static void traverse(TreeNode node, int level){
        if(node == null){
            return;
        }

        max = Math.max(max, level +1);

        traverse(node.left, level+1);
        traverse(node.right, level+1);
    }


    /**
     * 简洁的代码
     * @param root
     * @return
     */
    public int refMaxDepth(TreeNode root) {
        return root == null? 0 : 1 + Math.max(refMaxDepth(root.left),refMaxDepth(root.right));
    }

    public static void main(String[] args) {
        TreeNode node3 =  new TreeNode(3);
        TreeNode node9 =  new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 =  new TreeNode(7);
        node3.left = node9;
        node3.right = node20;
        node20.left = node15;
        node20.right = node7;

        int result = maxDepth(node3);


        System.out.println("end here, result:"+result);
    }

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
}
