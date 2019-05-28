package com.leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 给定一个二叉搜索树的根结点 root, 返回树中任意两节点的差的最小值。
 *
 * 示例：
 *
 * 输入: root = [4,2,6,1,3,null,null]
 * 输出: 1
 * 解释:
 * 注意，root是树结点对象(TreeNode object)，而不是数组。
 *
 * 给定的树 [4,2,6,1,3,null,null] 可表示为下图:
 *
 *           4
 *         /   \
 *       2      6
 *      / \
 *     1   3
 *
 * 最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值。
 * 注意：
 *
 * 二叉树的大小范围在 2 到 100。
 * 二叉树总是有效的，每个节点的值都是整数，且不重复。
 *
 */
public class MinimumDistanceBetweenBSTNodes783 {

    List<Integer> res = new ArrayList<>();

    public int min =0;

    public int minDiffInBST(TreeNode root) {
        if (root == null) return 0;
        getInOrder(root);
        return min;
    }

    public void getInOrder(TreeNode node){

        if (node == null) {
            return ;
        }

        getInOrder(node.left);

        res.add(node.val);
        int size = res.size();
        if(size == 2){
            min = res.get(1) - res.get(0);
        }else if (size > 2){
            min = Math.min(res.get(size-1) - res.get(size -2),min);
        }

        getInOrder(node.right);

    }

}
