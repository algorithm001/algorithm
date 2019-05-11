package com.v0ex.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author bugcoder
 */
public class LeetCode_104_49 {

    /**
     * 非递归，使用栈来处理
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        int count = 0;
        //栈非空
        while (!stack.isEmpty()) {
            int size = stack.size();
            while (size-- > 0) {
                //出栈
                TreeNode cur = stack.pop();
                if (cur.left != null){
                    stack.addLast(cur.left);
                }
                if (cur.right != null){
                    stack.addLast(cur.right);
                }
            }
            count++;
        }
        return count;
    }

    /**
     * 递归经典
     * @param root
     * @return
     */
    public int maxDepthRecursive(TreeNode root) {
        if(root==null){
            return 0;
        }
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }
}
