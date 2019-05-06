package com.shufeng.algorithm.d0_;

/**
 * @author gsf
 */
public class LeetCode_429_30 {

    public static void main(String[] args) {

        Node root = new Node(1, Arrays.asList(
                new Node(3, Arrays.asList(
                        new Node(5, null),
                        new Node(6, null))),
                new Node(2, null),
                new Node(4, null)
        ));
        List<List<Integer>> lists = levelOrder(root);
        System.out.println(lists);
    }

    public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(new ArrayList<>());
        if (root == null) {
            return lists;
        }

        int num = 0;
        lists.get(num).add(root.val);
        levelOrder(root.children, lists, num + 1);
        return lists;
    }

    public static void levelOrder(List<Node> children, List<List<Integer>> lists, int num) {
        if (children == null) {
            return;
        }
        for (int i = 0; i < children.size(); i++) {
            Node node = children.get(i);
            if (lists.size() < num + 1) {
                lists.add(new ArrayList<>());
            }
            lists.get(num).add(node.val);
            levelOrder(node.children, lists, num + 1);
        }
    }
}

