import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.Node;

//Definition for a Node.
class Node {
	public int val;
	public List<Node> children;
	public Node() {}
	public Node(int _val,List<Node> _children) {
		val = _val;
		children = _children;
	}
};

class Solution {
	public List<List<Integer>> levelOrder(Node root) {
		List<List<Integer>> res = new LinkedList<>();
        if(root == null) {
            return res;
        }
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while(!q.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int len = q.size();
            for(int i = 0; i < len; i++) {
                Node t = q.poll();
                temp.add(t.val);
                for(int j = 0; j < t.children.size(); j++) {
                    q.add(t.children.get(j));
                }
            }
            res.add(temp);
        }
        return res;
	}
}