/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Node> l1 = new ArrayList<>();
        List<Node> l2 = new ArrayList<>();
        l1.add(root);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> levelList;

        while (!l1.isEmpty()) {
            levelList = new ArrayList<>();
            for (Node n : l1) {
                levelList.add(n.val);
                for (Node c : n.children) {
                    if (c != null) {
                        l2.add(c);
                    }
                }
            }
            l1 = l2;
            l2 = new ArrayList<>();
            result.add(levelList);
        }

        return result;
    }
}