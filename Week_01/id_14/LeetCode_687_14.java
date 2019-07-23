/**
* https://leetcode-cn.com/problems/longest-univalue-path/
* <p> 递归   二叉树
* <p> 简单
*/
public class LeetCode_687_14 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(1);

        root.right = new TreeNode(5);
        root.right.right = new TreeNode(5);

        System.out.println("2:" + solution.longestUnivaluePath(root));

        TreeNode root2 = new TreeNode(-9);
        root2.left = new TreeNode(5);
        root2.left.left = new TreeNode(-2);
        root2.left.right = new TreeNode(-6);
        root2.left.left.left = new TreeNode(5);
        root2.left.left.left.left = new TreeNode(-3);
        root2.left.left.left.right = new TreeNode(6);
        root2.left.left.left.left.left = new TreeNode(-5);
        root2.left.left.left.left.left.left = new TreeNode(0);

        root2.right = new TreeNode(0);

        System.out.println("0:" + solution.longestUnivaluePath(root2));

        TreeNode root3 = new TreeNode(5);
        root3.left = new TreeNode(5);
        root3.left.left = new TreeNode(5);
        root3.left.right = new TreeNode(5);
        root3.left.left.left = new TreeNode(5);
        root3.left.left.left.left = new TreeNode(5);

        root3.right = new TreeNode(4);

        System.out.println("4:" + solution.longestUnivaluePath(root3));
    }

    /**
     * 这道题开始的理解、思路都有问题。本身使用递归没有问题。
     * <pre>
     *     1. 开始没有考虑多余一段最长路径的比较
     *     2. 最大值的保存，开始一直想用参数传递！！！ Integer也无法引用传递？！ 最后才使用成员变量，每次需要重置为0
     *     3. 下图的最长=4，而不是5
     *
     *       5
     *      /\
     *     5 4
     *    /\
     *   5 5
     *   |
     *   5
     *  /
     * 5
     * </pre>
     */
    static class Solution {
        private int max = 0;

        public int longestUnivaluePath(TreeNode root) {
            //注意重置，对象会重用
            max = 0;
            getMax(root);
            return max;
        }

        private int getMax(TreeNode root) {
            if (root == null) {
                return 0;
            }
            if (root.left == null && root.right == null) {
                return 0;
            }

            int left = getMax(root.left);
            int right = getMax(root.right);

            int tmpLeft = 0;
            if (root.left != null && root.val == root.left.val) {
                tmpLeft = left + 1;
            }
            int tmpRight = 0;
            if (root.right != null && root.val == root.right.val) {
                tmpRight = right + 1;
            }

            max = Math.max(tmpLeft + tmpRight, max);

            //返回左、右的大值，而不是相加的值
            return Math.max(tmpLeft, tmpRight);

        }
    }
}
