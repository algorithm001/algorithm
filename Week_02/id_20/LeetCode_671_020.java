/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int findSecondMinimumValue(TreeNode root) {
      Set<Integer> set = new HashSet<>();
        inOrder(root, set);
        List<Integer> list = new ArrayList<>();
        list.addAll(set);
        if (list.size() == 1) {
            return -1;
        } else {
            Collections.sort(list);
            return list.get(1);
        }
    }

    private void inOrder(TreeNode root, Set<Integer> set) {
        if (root != null) {
            inOrder(root.left, set);
            set.add(root.val);
            inOrder(root.right,set);
        }
    }
}
