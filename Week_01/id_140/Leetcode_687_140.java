/**
 * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
 * <p>
 * 注意：两个节点之间的路径长度由它们之间的边数表示。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * <p>
 * 5
 * / \
 * 4   5
 * / \   \
 * 1   1   5
 * 输出:
 * <p>
 * 2
 * 示例 2:
 * <p>
 * 输入:
 * <p>
 * 1
 * / \
 * 4   5
 * / \   \
 * 4   4   5
 * 输出:
 * <p>
 * 2
 * 注意: 给定的二叉树不超过10000个结点。 树的高度不超过1000。
 */
public class Leetcode_687_140 {
    /**
     * 调用入口
     * @param root
     * @return
     */
    public int longestUnivaluePath(TreeNode root) {
        int[] answer = new int[1];
        dfs(root, answer);
        return answer[0];
    }

    /**
     * 返回数值一样最长的那个节点的值
     * @param root
     * @param answer
     * @return
     */
    private int dfs(TreeNode root, int[] answer) {
        if (root == null) {
            return 0;
        }

        int leftLength = dfs(root.left, answer);
        int rightLength = dfs(root.right, answer);


        int maxUnival = 0;
        if (root.left != null && root.val == root.left.val) {
            maxUnival += leftLength + 1;
        }
        if (root.right != null && root.val == root.right.val) {
            maxUnival += rightLength + 1;
        }
        answer[0] = Math.max(answer[0], maxUnival);


        int returnVal = 0;
        if (root.left != null && root.left.val == root.val) {
            returnVal = leftLength + 1;
        }

        if (root.right != null && root.right.val == root.val) {
            returnVal = Math.max(returnVal, rightLength + 1);
        }

        return returnVal;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
