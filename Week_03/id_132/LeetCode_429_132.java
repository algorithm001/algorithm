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
        List<List<Integer>> llist = new ArrayList<>();
        if (root == null){
            return llist;
        }
        ArrayDeque<Node> que = new ArrayDeque<>();
        que.offer(root);
        while (!que.isEmpty()){
            int size = que.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; ++ i){
                Node tmp = que.poll();
                list.add(tmp.val);
                for (Node node : tmp.children){
                    if (node != null){
                        que.offer(node);
                    }
                }
            }
            llist.add(list);
        }
        return llist;
    }
}