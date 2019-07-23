import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
 *
 * <p> 简单
 * <p> N叉树
 *
 * @author aiter
 * @date 2019/05/04 7:51 PM
 */
public class LeetCode_429_14 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Node root = new Node(1, new ArrayList<Node>() {{
            add(new Node(3, new ArrayList<Node>() {{
                add(new Node(5, new ArrayList<Node>()));
                add(new Node(6, new ArrayList<Node>()));
            }}));

            add(new Node(2, new ArrayList<Node>()));
            add(new Node(4, new ArrayList<Node>()));
        }});

        List<List<Integer>> list = solution.levelOrder(root);
        System.out.println(list);
        System.out.println(new Solution2().levelOrder(root));
    }

    /**
     * 使用递归的方式。
     * 递归的方式，无论是效率还是代码清晰度都比较好。
     */
    static class Solution2 {
        public List<List<Integer>> levelOrder(Node root) {
            List<List<Integer>> list = new ArrayList<>();
            getList(list, root, 0);

            return list;

        }

        private void getList(List<List<Integer>> list, Node root, int l) {
            if (root == null) {
                return;
            }
            if (l >= list.size()) {
                list.add(new ArrayList<>());
            }
            List<Integer> levelList = list.get(l);
            levelList.add(root.val);

            int nextLevel = l + 1;
            for (Node node : root.children) {
                getList(list, node, nextLevel);
            }
        }
    }

    /**
     * 使用遍历的方式。
     * <pre>
     *     1. 队列记录层次的元素
     * </pre>
     */
    static class Solution {
        public List<List<Integer>> levelOrder(Node root) {
            List<List<Integer>> list = new ArrayList<>();
            LinkedList<Node> queue = new LinkedList<>();
            if (root == null) {
                return list;
            }
            Node cur = root;
            //当前层的遍历数量
            int cNum = 1;
            //下一层的总量
            int nNum = 0;
            List<Integer> iList = new ArrayList<>();
            list.add(iList);
            while (cNum-- > 0) {
                List<Node> cList = cur.children;
                nNum += cList.size();
                queue.addAll(cList);

                iList.add(cur.val);
                //System.out.println(String.format("当前数量：%d,下一层数量：%d", cNum, nNum));
                //如果当前层，遍历完成。将下一层数量赋值给当前层，并将下一层重置为0
                if (cNum == 0) {
                    cNum = nNum;
                    nNum = 0;
                    if (cNum > 0) {
                        iList = new ArrayList<>();
                        list.add(iList);
                    }
                }

                if (queue.size() > 0) {
                    cur = queue.poll();
                } else {
                    break;
                }
            }

            return list;

        }
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}

