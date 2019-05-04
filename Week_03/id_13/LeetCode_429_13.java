package leetCode.week3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Find the Town Judge
 * https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
 * https://leetcode.com/problems/n-ary-tree-level-order-traversal/
 *
 * @author JP.Jiang
 * @version Java
 * @since 2019/05/01
 */
public class LeetCode_429_13 {

    public List<List<Integer>> levelOrder(Node root) {
        return listOrder(root);
    }

        /**
         * 使用广度优先搜索进行遍历
         *
         * @param root 根节点
         * @return 排列后的数组
         */
        private List<List<Integer>> listOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> level = new ArrayList<>();
        if (root == null) return result;

        if (root.children == null) {
            level.add(root.val);
            result.add(level);
            return result;
        }

        Queue<Node> queue = new LinkedList<>();


        queue.add(root);
        while (!queue.isEmpty()) {
            int level_size = queue.size();

            for (int i = 0; i < level_size; i++) {
                Node node = queue.poll();
                level.add(node.val);
                queue.addAll(node.children);
            }

            // 需要新建立一个对象加入result
            result.add(new ArrayList<>(level));
            // 清空当前层数组的所有内容
            level.clear();
        }
        return result;
    }


    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

}
