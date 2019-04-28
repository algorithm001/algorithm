package leetcode.Algorithms._701_800._783_MinimumDistanceBetweenBSTNodes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by jialei.zou on 2019/4/21 .
 ref:
 https://leetcode.com/problems/minimum-distance-between-bst-nodes/

 Given a Binary Search Tree (BST) with the root node root, return the minimum
 difference between the values of any two different nodes in the tree.

 Example :

 Input: root = [4,2,6,1,3,null,null]
 Output: 1
 Explanation:
 Note that root is a TreeNode object, not an array.

 The given tree [4,2,6,1,3,null,null] is represented by the following diagram:

      4
    /   \
   2     6
  / \
 1   3

 while the minimum difference in this tree is 1, it occurs between node 1 and node 2,
 also between node 3 and node 2.
 Note:

 The size of the BST will be between 2 and 100.
 The BST is always valid, each node's value is an integer, and each node's value is different.
 */
public class MinimumDistanceBetweenBSTNodes {


    /**
     * 因为二叉树是有序的，来个遍历即可
     * @param root
     * @return
     */
    public int minDiffInBST(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        int result = Integer.MAX_VALUE;
        traverse(root, list);
        for (int i=1; i< list.size();i++){
            result = Math.min(result,list.get(i)-list.get(i-1));
        }
        return result;
    }

    private void traverse(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        traverse(root.left, list);
        list.add(root.val);
        traverse(root.right, list);
    }


    private int result = Integer.MAX_VALUE;

    /**
     * 题目的要求是找出任意两个结点之间的差值最小，差值最小，
     * 是要比较root和其左侧所有结点的最大结点，以及root和其右侧结点的最小结点
     * 下面的错误思路，是比较了root和相邻左右结点的差值
     * @param root
     * @return
     */
    public int minDiffInBST1(TreeNode root) {
        helper(root);
        int rootResult = result;
        result = Integer.MAX_VALUE;
        return rootResult;
    }

    private void helper(TreeNode root){
        if(root == null || (root.left==null && root.right == null)){
            return;
        }
        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        if(root.left != null){
            left = root.val - root.left.val;
        }
        if(root.right != null){
            right = root.right.val - root.val;
        }
        result = Math.min(result, Math.min(left, right));
        helper(root.left);
        helper(root.right);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(3);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        MinimumDistanceBetweenBSTNodes distanceBetweenBSTNodes = new MinimumDistanceBetweenBSTNodes();
        System.out.println(distanceBetweenBSTNodes.minDiffInBST(node1));
        System.out.println(distanceBetweenBSTNodes.minDiffInBST(node1));

    }
}
