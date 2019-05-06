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
          List<List<Integer>> result = new ArrayList<>();
            treeTraverse(result, root, 0);
            // System.out.println(result);
            return result;
        }

        public void treeTraverse(List<List<Integer>> result, Node root, int depth){
                if(root == null) {
                    return;
                }

                int size = root.children.size();

            if (result.size() <= depth){
                List<Integer> tempList = new ArrayList<>();
                result.add(tempList);
            }
            result.get(depth).add(root.val);

            for (int i = 0; i < size; i++ ){
                treeTraverse(result, root.children.get(i), depth + 1);
            }
        }
}
