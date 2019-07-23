/**
 * https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree/
 *
 * <p>二叉树
 * <p>简单
 *
 * https://leetcode-cn.com/submissions/detail/17526993/
 *
 * @author aiter
 * @date 2019/04/22 9:22 PM
 */
public class LeetCode_671_14 {

    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(solution.findSecondMinimumValue(root));
    }

    static class Solution {
        private int second = -1;

        /**
         * <pre>
         *     1. 非空的二叉树
         *     2. 都是正数
         *     3. 子节点数量：0/2
         *     4. 有子节点。 value <= 子节点value
         * </pre>
         *
         * @param root
         * @return 第2小的值，或者-1
         */
        public int findSecondMinimumValue(TreeNode root) {
            second = -1;
            getNum(root);
            return second;
        }

        /**
         * @param node
         * @return 返回当前节点及子节点中的最小值
         */
        private int getNum(TreeNode node) {
            if (node == null) {
                return -1;
            }

            int left = getNum(node.left);
            int right = getNum(node.right);

            /**
             * 只需要判断左子树， 子节点要么是2，要么是0
             */
            if (left == -1) {
                return node.val;
            }

            if (left == right) {
                if (node.val < left) {
                    second = second == -1 ? left : Math.min(left, second);
                }
            } else {
                if (left < right) {
                    if (node.val < left) {
                        second = second == -1 ? left : Math.min(left, second);
                    } else {
                        second = second == -1 ? right : Math.min(right, second);
                    }
                } else {
                    if (node.val < right) {
                        second = second == -1 ? right : Math.min(right, second);
                    } else {
                        second = second == -1 ? left : Math.min(left, second);
                    }
                }
            }

            return node.val;
        }
    }
}
