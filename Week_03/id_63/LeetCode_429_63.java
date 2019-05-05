/*
https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
429. N叉树的层序遍历
给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。

例如，给定一个 3叉树 :

返回其层序遍历:

[
     [1],
     [3,2,4],
     [5,6]
]
说明:
    树的深度不会超过 1000。
    树的节点总数不会超过 5000。
 */
/*
执行用时 : 3 ms, 在N-ary Tree Level Order Traversal的Java提交中击败了99.33% 的用户
内存消耗 : 56.9 MB, 在N-ary Tree Level Order Traversal的Java提交中击败了52.89% 的用户
 */
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
import java.util.List;
import java.util.ArrayList;
class Solution {
  public List<List<Integer>> levelOrder(Node root) {
    List<List<Integer>> list = new ArrayList<List<Integer>>();
    find(list, root, 0);
    return list;
  }
  void find(List<List<Integer>> list, Node root, int level) {
    if (root == null) {
      return;
    }
    if (list.size() <= level) {
      List<Integer> levelList = new ArrayList<Integer>();
      list.add(levelList);
    }
    List<Integer> levelList = list.get(level);
    levelList.add(root.val);
    for (int i = 0; i < root.children.size(); i++) {
      find(list, root.children.get(i), level + 1);
    }
  }

}