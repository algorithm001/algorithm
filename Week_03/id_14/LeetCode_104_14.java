import java.util.HashMap;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 *
 * <p> 简单
 * <p> 二叉树
 * <p> DFS
 *
 * @author aiter
 * @date 2019/05/04 8:54 AM
 */
public class LeetCode_104_14 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();

        /**
         * <pre>
         *            1
         *          /   \
         *         4     5
         *        / \   / \
         *       4  5  6  7
         *      / \
         *     12 5
         * </pre>
         */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(12);
        root.left.left.right = new TreeNode(5);

        root.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(String.format("期望值：4，实际值：%d", solution.maxDepth(root)));
        System.out.println(String.format("期望值：4，实际值：%d", solution2.maxDepth(root)));
    }

    /**
     * 难得遇到一道送分题！
     */
    static class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int left = maxDepth(root.left);
            int right = maxDepth(root.right);

            return ((left >= right) ? left : right) + 1;

        }
    }

    /**
     * 用stack和哈希表，实现一下。
     * 哈希表记录当前节点的深度
     */
    static class Solution2 {

        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int max = 0;

            Stack<TreeNode> stack = new Stack<>();
            HashMap<TreeNode, Integer> map = new HashMap<>();

            stack.push(root);
            map.put(root, map.getOrDefault(root, 1));

            while (!stack.empty()) {
                TreeNode cur = stack.pop();

                int tmp = map.getOrDefault(cur, 1);

                max = max > tmp ? max : tmp;

                if (cur.right != null) {
                    stack.push(cur.right);
                    map.put(cur.right, tmp + 1);
                }

                if (cur.left != null) {
                    stack.push(cur.left);
                    map.put(cur.left, tmp + 1);
                }

            }
            return max;
        }
    }
}
