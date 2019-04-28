import java.util.*;

/**
 * Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes.
 *
 * Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.
 *
 * If no such second minimum value exists, output -1 instead.
 *
 * Example 1:
 *
 * Input:
 *     2
 *    / \
 *   2   5
 *      / \
 *     5   7
 *
 * Output: 5
 * Explanation: The smallest value is 2, the second smallest value is 5.
 *
 *
 * Example 2:
 *
 * Input:
 *     2
 *    / \
 *   2   2
 *
 * Output: -1
 * Explanation: The smallest value is 2, but there isn't any second smallest value.
 */
public class Leetcode_671_140 {
    public int findSecondMinimumValue(TreeNode root) {
        if(root == null) return -1;
        Set<Integer> values = new HashSet<>();
        readValues(values, root);
        if(values.size() < 2) return -1;
        return findSecondSmallest(values);
    }

    private void readValues(Set<Integer> values, TreeNode root){
        if(root == null) return;
        if(root.left == null & root.right == null) values.add(root.val);
        readValues(values, root.left);
        readValues(values, root.right);
    }

    private int findSecondSmallest(Set<Integer> values){
        List<Integer> list = new ArrayList<>(values);
        Collections.sort(list);
        return list.get(1);
    }


}
 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
