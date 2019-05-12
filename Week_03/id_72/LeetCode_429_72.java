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
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        List<Node> rootList = new LinkedList<>();
        rootList.add(root);
        bfs(rootList, result);
        return result;
    }
    private void bfs(List<Node> nodes, List<List<Integer>> result) {
        if (nodes == null || nodes.isEmpty()) {
            return;
        }
        List<Node> children = new LinkedList<>();
        List<Integer> valueList = new LinkedList<>();
        result.add(valueList);
        for (Node node : nodes) {
            valueList.add(node.val);
            children.addAll(node.children);
        }
        bfs(children, result);
    }
}