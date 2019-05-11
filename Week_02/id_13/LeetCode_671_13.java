package leetCode.week2;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_671_13 {

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
    public int findSecondMinimumValue(TreeNode root) {
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
