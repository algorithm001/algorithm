package com.leetcode.binarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么这个节点的值不大于它的子节点的值。
 *
 * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
 *
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   2   5
 *      / \
 *     5   7
 *
 * 输出: 5
 * 说明: 最小的值是 2 ，第二小的值是 5 。
 *
 *
 * 输入:
 *     2
 *    / \
 *   2   2
 *
 * 输出: -1
 * 说明: 最小的值是 2, 但是不存在第二小的值。
 */
public class SecondMinimumNodeInaBinaryTree671 {

    public int findSecondMinimumValue(TreeNode root) {
        long ans = traversal(root, root.val);
        return ans > Integer.MAX_VALUE ? -1 : (int)ans;
    }

    //所有大于value节点的最小值即为第二小的节点
    public long traversal(TreeNode root, int value){
        if(root != null){
            if(root.val > value)
                return root.val;
            return Math.min(traversal(root.left, value), traversal(root.right, value));
        }
        return (long)Integer.MAX_VALUE + 1;
    }

}
