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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> routes1 = new ArrayList();
        ArrayList<TreeNode> routes2 = new ArrayList();
        FindRoute(root, p.val, routes1);
        FindRoute(root, q.val, routes2);
        return Lca(routes1, routes2);
    }
    
    public boolean FindRoute(TreeNode root, Integer p, List<TreeNode> routes) {
        if(root == null) return false;

        routes.add(root);
        if(root.val == p) return true;

        if(FindRoute(root.left, p, routes)) return true;
        if(FindRoute(root.right, p, routes)) return true;

        routes.remove(root);
        return false;
    }

    public TreeNode Lca(ArrayList<TreeNode> nodes1, ArrayList<TreeNode> nodes2) {
        int c = nodes1.size() > nodes2.size() ? nodes2.size() : nodes1.size();
        TreeNode last = null;
        for(int i=0;i<c;i++) {
            TreeNode a = nodes1.get(i);
            TreeNode b = nodes2.get(i);
            if(a == b) {
                last = a;
            } else {
                break;
            }
        }
        return last;
    }
}
