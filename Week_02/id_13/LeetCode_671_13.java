package leetCode.week2;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_671_13 {


    public int findSecondMinimumValue(TreeNode root) {
        return _dfs(root, root.val);
//        return _bfs(root);
    }

    /**
     * 根据题目描述：如果一个节点有两个子节点的话，那么这个节点的值不大于它的子节点的值。
     * 可以得知，树的根节点是最小值
     * 一个节点如果有两个孩子节点，那么该节点是这个树的最小值
     * 题目需求就变成：取出第一个比根节点大的节点
     *
     * @param root 根节点
     * @return 第二小值
     */
    private int _dfs(TreeNode root, int rootVal) {
        if (root == null) return -1;

        if (root.val > rootVal) return root.val;

        int l = _dfs(root.left, rootVal);
        int r = _dfs(root.right, rootVal);

        if (l > 0 && r > 0) {
            return Math.min(l,r);
        }

        return Math.max(l,r);
    }

    /**
     * 如果想知道第二小的数字，则需要知道每一个节点的数据，所以需要遍历
     * 本方法使用BFS的方式遍历
     * 记录第一小和第二小的数字
     * 如果当前节点数字小于第一小，则第二小替换成第一小，第一小等于当前节点值
     * 如果当前节点值等于第一小或者大于等于第二小，则不需要做任何操作
     * 如果当前节点值等于大于第一小且小于第二小，则第二小等于当前值
     *
     * 操作完毕之后，把当前节点的子节点放入队列
     *
     * 使用BFS的方式，把每个节点遍历且只遍历一次
     * 时间复杂度是O(N)
     *
     * @param root 根节点
     * @return 第二小的值
     */
    private int _bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        int firstMin = root.val;
        int secondMin = Integer.MAX_VALUE;
        TreeNode node;
        boolean isChange = false;

        while (!queue.isEmpty()) {
            node = queue.poll();
            if (node.val < firstMin) {
                secondMin = firstMin;
                firstMin = node.val;
                isChange = true;
            } else if (node.val == firstMin || node.val > secondMin) {
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                continue;
            } else if (node.val > firstMin){
                secondMin = node.val;
                isChange = true;
            }
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }

        if (!isChange) secondMin = -1;

        return secondMin;
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
