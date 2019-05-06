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
        if(root == null) return result;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        result.add(list);
        
        addRes(queue,result);
        return result;
    }
    
    private void addRes(Queue<Node> queue,List<List<Integer>> result){
         List<Integer> list = new ArrayList<>();
         Queue<Node> new_queue = new LinkedList<>();
         while(queue.size() != 0){
            Node w = queue.poll();
            for(int i = 0; i < w.children.size() ; i++){
                Node res = w.children.get(i);
                list.add(res.val);
                new_queue.add(res);
            }
        }
        if(!list.isEmpty()) result.add(list);
        if(!new_queue.isEmpty()) addRes(new_queue,result);
    }
}


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
        if(root == null) return result;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int len = queue.size();   
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < len; i++){
                Node w = queue.poll();
                list.add(w.val);
                for(int j = 0; j < w.children.size(); j++){
                    Node node = w.children.get(j);   
                    queue.offer(node);
                }
            }         
            if(!list.isEmpty())result.add(list);
        }  
        return result;
    }
 
}