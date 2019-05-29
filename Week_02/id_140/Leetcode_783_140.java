import java.util.ArrayList;
import java.util.List;

/**
 * Given a Binary Search Tree (BST) with the root node root, return the minimum difference between the values of any two different nodes in the tree.
 *
 * Example :
 *
 * Input: root = [4,2,6,1,3,null,null]
 * Output: 1
 * Explanation:
 * Note that root is a TreeNode object, not an array.
 *
 * The given tree [4,2,6,1,3,null,null] is represented by the following diagram:
 *
 *           4
 *         /   \
 *       2      6
 *      / \
 *     1   3
 *
 * while the minimum difference in this tree is 1, it occurs between node 1 and node 2, also between node 3 and node 2.
 * Note:
 *
 * The size of the BST will be between 2 and 100.
 * The BST is always valid, each node's value is an integer, and each node's value is different.
 */
public class Leetcode_783_140 {

    public int minDiffInBST(TreeNode root) {
        List<Integer> res=new ArrayList<Integer>();
        inorder(res,root);
        int min=Integer.MAX_VALUE;
        for(int i=1;i<res.size();i++){
            min=Math.min(min,res.get(i)-res.get(i-1));
        }
        return min;
    }
    private void inorder(List<Integer> res, TreeNode root){
        if(root==null)
            return;
        inorder(res,root.left);
        res.add(root.val);
        inorder(res,root.right);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
