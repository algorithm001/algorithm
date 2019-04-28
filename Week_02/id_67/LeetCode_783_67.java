/*
 * @lc app=leetcode.cn id=783 lang=java
 *
 * [783] 二叉搜索树中的搜索
 *
 * https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/description/
 *
 * algorithms
 * Easy (51.55%)
 * Total Accepted:    2.5K
 * Total Submissions: 4.8K
 * Testcase Example:  '[4,2,6,1,3,null,null]'
 *
 * 给定一个二叉搜索树的根结点 root, 返回树中任意两节点的差的最小值。
 *
 * 示例：
 *
 *
 * 输入: root = [4,2,6,1,3,null,null]
 * 输出: 1
 * 解释:
 * 注意，root是树结点对象(TreeNode object)，而不是数组。
 *
 * 给定的树 [4,2,6,1,3,null,null] 可表示为下图:
 *
 * ⁠         4
 * ⁠       /   \
 * ⁠     2      6
 * ⁠    / \
 * ⁠   1   3
 *
 * 最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值。
 *
 * 注意：
 *
 *
 * 二叉树的大小范围在 2 到 100。
 * 二叉树总是有效的，每个节点的值都是整数，且不重复。
 *
 *
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int last = -1000000;
    int res = 1000000;
    public int minDiffInBST(TreeNode root) {
        if (root == null) {
            return 0;
        }
        minDiffInBST(root.left);
        //将差值与记录最小差值再取小值
        res = Math.min(root.val - last, res);
        //中序遍历之后将当前节点用于下一次比对
        last = root.val;
        minDiffInBST(root.right);
        return res;
    }
}

