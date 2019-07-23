/**
 * https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/
 * <p>
 * 783. 二叉搜索树结点最小距离
 *
 * <p> 简单
 * <p> 树  binary tree
 *
 * @author aiter
 * @date 2019/04/26 6:42 AM
 */
public class LeetCode_783_14 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        root.right = new TreeNode(6);

        int ret = solution.minDiffInBST(root);

        System.out.println(String.format("预期值：1，实际值：%d", ret));

        Solution2 solution2 = new Solution2();
        System.out.println(String.format("预期值：1，实际值：%d", solution2.minDiffInBST(root)));
    }

    /**
     * <pre>
     *     要求：
     *        任意两节点的差的最小值
     *        <i>开始理解为父子节点的差值</i>
     *     二叉搜索树：
     *     1. 是有序的
     *       2.1 中序遍历，就是一个有序的数列，再求相邻数组元素之间的最小差值
     *       2.2 每个节点，查找他的中序遍历前序、后序节点，最小值只会出现在这里
     *
     *
     *       2.1  结果，为什么？中序遍历O(n)+遍历求值O(n)。总：O(n)
     *       执行用时 : 27 ms, 在Minimum Distance Between BST Nodes的Java提交中击败了5.25% 的用户
     *       内存消耗 : 35.1 MB, 在Minimum Distance Between BST Nodes的Java提交中击败了55.36% 的用户
     *       https://leetcode-cn.com/submissions/detail/17726878/
     *
     *       2.2
     *       执行用时 : 1 ms, 在Minimum Distance Between BST Nodes的Java提交中击败了100.00% 的用户
     *       内存消耗 : 34.6 MB, 在Minimum Distance Between BST Nodes的Java提交中击败了74.41% 的用户
     * </pre>
     */
    static class Solution2 {
        private final static int MAX = 100;

        public int minDiffInBST(TreeNode root) {
            if (root == null) {
                return MAX;
            }

            int left = -1;
            // 如果有左子树，那么最大值，一定是左子节点或左子树的最右节点
            if (root.left != null) {
                left = root.left.val;
                TreeNode cur = root.left.right;
                while (cur != null) {
                    left = cur.val;
                    cur = cur.right;
                }
            }

            int min = MAX;
            if (left > 0) {
                min = Math.min(min, root.val - left);
            }

            int right = -1;
            // 如果有右子树，那么最小值，一定是右子节点或右子树的最左节点
            if (root.right != null) {
                right = root.right.val;
                TreeNode cur = root.right.left;
                while (cur != null) {
                    right = cur.val;
                    cur = cur.left;
                }
            }
            if (right > 0) {
                min = Math.min(min, right - root.val);
            }

            //递归计算左子树、右子树的最小值k，在比较k与min的最小值
            return Math.min(min, Math.min(minDiffInBST(root.left), minDiffInBST(root.right)));

        }

    }

    static class Solution {
        private final static int MAX = 100;

        public int minDiffInBST(TreeNode root) {

            DListNode inorderNode = new DListNode(root.val);

            inorder(root, inorderNode);

            DListNode cur = inorderNode;
            System.out.println("-" + cur.val);
            int min = MAX;
            while (cur.pre != null) {

                min = Math.min(min, Math.abs(cur.val - cur.pre.val));
                cur = cur.pre;
                System.out.println("pre-" + cur.val);
            }
            cur = inorderNode;
            System.out.println("-" + cur.val);
            while (cur.next != null) {

                min = Math.min(min, Math.abs(cur.val - cur.next.val));
                cur = cur.next;
                System.out.println("next-" + cur.val);
            }
            return min;
        }

        private void inorder(TreeNode root, DListNode inorderNode) {
            if (root == null) {
                return;
            }

            if (root.left != null) {
                DListNode pre = inorderNode.pre;
                inorderNode.pre = new DListNode(root.left.val);
                inorderNode.pre.next = inorderNode;
                if (pre != null) {
                    inorderNode.pre.pre = pre;
                    pre.next = inorderNode.pre;
                }
                inorder(root.left, inorderNode.pre);
            }
            if (root.right != null) {
                DListNode next = inorderNode.next;
                inorderNode.next = new DListNode(root.right.val);
                inorderNode.next.pre = inorderNode;
                if (next != null) {
                    inorderNode.next.next = next;
                    next.pre = inorderNode.next;
                }
                inorder(root.right, inorderNode.next);
            }
        }
    }

    static class DListNode {
        int val;
        DListNode pre;
        DListNode next;

        DListNode(int x) {
            val = x;
        }
    }
}
