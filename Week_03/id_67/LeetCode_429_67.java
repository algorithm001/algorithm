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
        traverse(result,root,0);
        return result;
    }

    public void traverse(List result, Node root, int level){
        if (root == null){
            return;
        }
        List<Integer> levelList;
        if (result.size() <= level){
            levelList = new LinkedList<>();
            levelList.add(root.val);
            result.add(levelList);
        }else{
            levelList = (List<Integer>) result.get(level);
            levelList.add(root.val);
        }

        List childrenNode = root.children;
        for (int i = 0; i < childrenNode.size(); i++) {
            traverse(result, (Node) childrenNode.get(i),level+1);
        }
    }
}