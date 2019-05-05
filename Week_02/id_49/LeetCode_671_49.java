package com.v0ex.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Second Minimum Node In a Binary Tree
 *
 * @author bugcoder
 */
public class LeetCode_671_49 {

    public int findSecondMinimumValue(TreeNode root) {
        Set<Integer> set = new HashSet<Integer>();
        inOrder(root,set);
        if(set.size() < 2){
            return -1;
        }
        //根据题意，第一个值肯定是最小的值
        int first = root.val;
        //先临时设置第二小的值是整数的最大值，后续会对这个值进行替换
        int second = Integer.MAX_VALUE;
        for(int val : set){
            if(first < val && val <= second){
                second = val;
            }
        }
        return second <= Integer.MAX_VALUE ? second : -1;
    }

    /**
     * 中序遍历二叉树，把所有的值存放在Set集合中
     * @param root
     * @param set
     */
    private void inOrder(TreeNode root,Set<Integer> set){
        if(root == null){
            return;
        }
        inOrder(root.left,set);
        set.add(root.val);
        inOrder(root.right,set);
    }
}
