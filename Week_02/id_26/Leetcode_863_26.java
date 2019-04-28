package com.fanlu.leetcode.binarytree;
// Source : https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
// Id     : 863
// Author : Fanlu Hai
// Date   : 2018-04-26
// Other  :
// Tips   :

import java.util.*;

public class AllNodesDistanceKInBinaryTree {
    Map<Integer, TreeNode> parentMap = new HashMap<>();
    //Each node in the tree has unique values 0 <= node.val <= 500
    boolean[] visisted = new boolean[500];

    //69.28% 5.38%
    public List<Integer> distanceKOriginal(TreeNode root, TreeNode target, int K) {
//        parentMap.put(root.val, null);
        dfs(root, target);
        List<TreeNode> ans = new LinkedList<>();
        ans.add(target);
        for (int i = 0; i < K; i++) {
            ans = getDistanceOneNodes(ans);
        }
        List<Integer> intAns = new LinkedList<>();
        for (TreeNode node : ans) {
            intAns.add(node.val);
        }
        return intAns;
    }

    public List<TreeNode> getDistanceOneNodes(List<TreeNode> list) {
        List<TreeNode> result = new LinkedList<>();

        for (TreeNode node : list) {
            visisted[node.val] = true;
//            System.out.println("node.val: "+parentMap.get(node.val).val);

            if (null != parentMap.get(node.val) && !visisted[parentMap.get(node.val).val]) {
                result.add(parentMap.get(node.val));
            }
            if (null != node.left && !visisted[node.left.val]) {
                result.add(node.left);
            }
            if (node.left != node.right && !visisted[node.right.val]) {
                result.add(node.right);
            }
        }
        return result;
    }

    public void dfs(TreeNode root, TreeNode target) {

        if (null == root || root == target)
            return;
        if (null != root.left) {
            parentMap.put(root.left.val, root);
//            System.out.println(root.left.val + " : " + root.val);
            dfs(root.left, target);
        }

        if (null != root.right) {
            parentMap.put(root.right.val, root);
//            System.out.println(root.right.val + " : " + root.val);
            dfs(root.right, target);
        }
    }

    /**
     * below are codes learned from leetcode discussion
     * key idea is :if the distance from a node to target node is k,
     * the distance from its child to the target node is k + 1
     * unless the child node is closer to the target node which means the target node is in it's subtree.
     * <p>
     * Travel the tree first to find the path from root to target, store the value of distance in hashamp
     * Then use dfsWrongAnswer to travel the whole tree. Every time when we meet a treenode which has already stored in map,
     * use the stored value in hashmap instead of the value from its parent node.
     */

    Map<TreeNode, Integer> map = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new LinkedList<>();
        find(root, target);
        dfs(root, target, K, map.get(root), res);
        return res;
    }

    // find target node first and store the distance in that path that we could use it later directly
    private int find(TreeNode root, TreeNode target) {
        if (root == null) return -1;
        if (root == target) {
            map.put(root, 0);
            return 0;
        }
        int left = find(root.left, target);
        if (left >= 0) {
            map.put(root, left + 1);
            return left + 1;
        }
        int right = find(root.right, target);
        if (right >= 0) {
            map.put(root, right + 1);
            return right + 1;
        }
        return -1;
    }

    // length equals the distance from current node to target node
    private void dfs(TreeNode root, TreeNode target, int K, int length, List<Integer> res) {
        if (root == null)
            return;

        if (map.containsKey(root))
            length = map.get(root);
        if (length == K)
            res.add(root.val);

        // the distance from its child to the target node is k + 1
        dfs(root.left, target, K, length + 1, res);
        dfs(root.right, target, K, length + 1, res);
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode0 = new TreeNode(0);

        treeNode3.left = treeNode5;
        treeNode3.right = treeNode1;
        treeNode5.left = treeNode6;
        treeNode5.right = treeNode2;
        treeNode2.left = treeNode7;
        treeNode2.right = treeNode4;
        treeNode1.left = treeNode0;
        treeNode1.right = treeNode8;

        AllNodesDistanceKInBinaryTree a = new AllNodesDistanceKInBinaryTree();
        a.dfs(treeNode3, treeNode5);
        a.distanceKOriginal(treeNode3, treeNode5, 2);
    }
}
