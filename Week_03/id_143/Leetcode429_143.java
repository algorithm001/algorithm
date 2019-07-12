import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode429_143 {

    public List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> result=new ArrayList<>();

        if(root==null){
            return result;
        }

        Queue<Node> queue=new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty()){
            List<Integer> elements=new ArrayList<>();
            int n=queue.size();
            for(int i=0;i<n;++i){
                Node first=queue.peek();
                queue.poll();
                elements.add(first.val);
                for(int j=0;j<first.children.size();j++){
                    queue.offer(first.children.get(j));
                }
            }

            result.add(elements);
        }
        return result;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
