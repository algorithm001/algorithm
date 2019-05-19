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
import java.util.Collections;
import java.util.ArrayList;
import java.util.LinkedList;

class Solution {

    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> retList = new ArrayList<>();
        List<Integer> lineList = new LinkedList<>();        // all nodes at the same level
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        int currLevelCount = 1; // node count on the current level
        int nextLevelCount = 0; // node count on the next level
        while (queue.peek() != null) {
            Node node = queue.poll();
            currLevelCount--;
            lineList.add(node.val);
            List<Node> children = node.children;
            if (children != null && children.size() != 0) {
                int size = children.size();
                // update the next level node count and push these nodes into queue
                nextLevelCount += size;
                for (Node child : children) {
                    queue.offer(child);
                }
            }
            // If this is the last node of the current level
            if (currLevelCount == 0) {
                // add lineList into retList and re-init it
                retList.add(lineList);
                lineList = new LinkedList<>();
                // now start visiting the next level
                currLevelCount = nextLevelCount;
                nextLevelCount = 0;
            }
        }
        return retList;
    }
}