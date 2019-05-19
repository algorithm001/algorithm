import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

public class TreeLevelOrder {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null){
            return result;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i< size ;i++){
                Node nodeT = queue.poll();
                temp.add(nodeT.val);
                queue.addAll(nodeT.children);
            }
            result.add(temp);
        }

        return result;
    }
}


