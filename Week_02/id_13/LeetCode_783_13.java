package leetCode.week2;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_783_13 {


    private List<Integer> list = new ArrayList<>();

    /**
     * 因为二叉搜索树的特性：
     * 如果左右子树均为有效的话，左子树小于父节点，右子树大于父节点
     * <p>
     * 通过中序遍历，按照从小到大的顺序访问整个树
     * 相邻节点的差值取小的
     *
     * 时间复杂度是O(N + M)
     *
     * @param root 根节点
     * @return 最小值
     */
    public int minDiffInBST(TreeNode root) {
        int cur = Integer.MAX_VALUE;

        inOrder(root);

        for (int i = 1; i < list.size(); i++) {
            cur = Math.min(list.get(i) - list.get(i - 1), cur);
        }

        return cur;
    }

    private void inOrder(TreeNode node) {
        if (node == null) return;
        inOrder(node.left);
        list.add(node.val);
        inOrder(node.right);
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
