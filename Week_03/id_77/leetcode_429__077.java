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
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(root == null){
            return list;
        }
        
        List<Node> visit = new ArrayList<Node>();
        visit.add(root);
        List<Node> waitToVisit = new ArrayList<Node>();
        while(!visit.isEmpty()){
            
            List<Integer> currentList = new ArrayList<Integer>(visit.size());
            for(Node nodeP: visit){
                currentList.add(nodeP.val);
                for(Node nodeC: nodeP.children){
                    waitToVisit.add(nodeC);
                }
            }
            list.add(currentList);
            visit = waitToVisit;
            waitToVisit = new ArrayList<Node>();
        }
        
        return list;
    }
    
}