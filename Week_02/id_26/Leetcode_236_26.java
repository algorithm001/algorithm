package com.fanlu.leetcode.binarytree;
// Source : https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
// Id     : 236
// Author : Fanlu Hai
// Date   : 2018-04-24
// Other  : lowest common ancestor (LCA): The lowest common ancestor is defined between two nodes p and q
//          as the lowest node in T that has both p and q as descendants
//          (where we allow a node to be a descendant of itself).
// Tips   :

import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

public class LowestCommonAncestorOfABinaryTree {

    private TreeNode ans;

    // This answer is copied from leetcode submission analysis sample
    // 100.00% (20% faster than original)  44.21%
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        this.recurse(root, p, q);
        return this.ans;
    }

    private boolean recurse(TreeNode node, TreeNode p, TreeNode q) {

        if (node == null) {
            return false;
        }

        // rec left
        // it's very hard for me to write below code even though it's nothing hard.
        int left = this.recurse(node.left, p, q) ? 1 : 0;
        int right = this.recurse(node.right, p, q) ? 1 : 0;

        int mid = (node == p) || (node == q) ? 1 : 0;

        // this is better than comparing objects
        if (mid + left + right >= 2) {
            this.ans = node;
        }
        return (mid + left + right > 0);

    }


    //65.83%  40.60%
    // this is fast enough to my understanding, but there are more elegant and faster ways to do the same steps
    public TreeNode lowestCommonAncestorOriginal(TreeNode root, TreeNode p, TreeNode q) {

        if (null == root || root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestorOriginal(root.left, p, q);
        TreeNode right = lowestCommonAncestorOriginal(root.right, p, q);

        if (null != left && null != right) {
            return root;
        } else if (null == right) {
            return left;
        } else {
            // null == left
            return right;
        }
        //return left == null ? right : right == null ? left : root;
    }

    /**
     * below are some no very successfull attampts
     */
    Queue<TreeNode> pNodeList = new LinkedList<>();
    Queue<TreeNode> qNodeList = new LinkedList<>();

    //! Time Limit Exceeded
    public TreeNode lowestCommonAncestorTooSlow(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode result = root;
        dfsNode(root, p, q, new LinkedList<TreeNode>());
        while (!pNodeList.isEmpty()) {
            TreeNode tmp = pNodeList.poll();
//            System.out.println(tmp);
            if (tmp != qNodeList.poll()) {
                break;
            }
            result = tmp;
        }
        return result;
    }

    public void dfsNode(TreeNode treeNode, TreeNode p, TreeNode q, Queue<TreeNode> queue) {
        if (null == treeNode)
            return;

        Queue<TreeNode> tmpQueue = new LinkedList<>();
        tmpQueue.addAll(queue);

        tmpQueue.add(treeNode);
        if (treeNode.val == p.val) {
            pNodeList = tmpQueue;
        }

        if (treeNode.val == q.val) {
            qNodeList = tmpQueue;
        }

        dfsNode(treeNode.left, p, q, tmpQueue);
        dfsNode(treeNode.right, p, q, tmpQueue);
    }


    Queue<Integer> pList = new LinkedList<>();
    Queue<Integer> qList = new LinkedList<>();


    // implemented the int version
    public int lowestCommonAncestorReturnInt(TreeNode root, TreeNode p, TreeNode q) {
        int result = root.val;
        dfsValue(root, p.val, q.val, new LinkedList<Integer>());
        while (!pList.isEmpty()) {
            int tmp = pList.poll();
//            System.out.println(tmp);
            if (tmp != qList.poll()) {
                break;
            }
            result = tmp;
        }
        return result;
    }

    public void dfsValue(TreeNode treeNode, int p, int q, Queue<Integer> queue) {
        if (null == treeNode)
            return;

        Queue<Integer> tmpQueue = new LinkedList<>();
        tmpQueue.addAll(queue);

        tmpQueue.add(treeNode.val);
        if (treeNode.val == p) {
            pList = tmpQueue;
        }

        if (treeNode.val == q) {
            qList = tmpQueue;
        }

        dfsValue(treeNode.left, p, q, tmpQueue);
        dfsValue(treeNode.right, p, q, tmpQueue);
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);

        treeNode1.left = treeNode2;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode5.right = treeNode3;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;

        LowestCommonAncestorOfABinaryTree lowestCommonAncestorOfABinaryTree = new LowestCommonAncestorOfABinaryTree();
        lowestCommonAncestorOfABinaryTree.dfsValue(treeNode1, 7, 6, new LinkedList<Integer>());

        for (int i : lowestCommonAncestorOfABinaryTree.pList) {
            System.out.print(i + "*");
        }
        System.out.println();
        for (int i : lowestCommonAncestorOfABinaryTree.qList) {
            System.out.print(i + "-");
        }
        System.out.println();

        System.out.println("result: " + lowestCommonAncestorOfABinaryTree.lowestCommonAncestorReturnInt(treeNode1, treeNode7, treeNode6));
    }

}
