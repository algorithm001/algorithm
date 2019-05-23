package leetcode.Algorithms._901_1000._938_RangeSumOfBST;

/**
 * Created by jialei.zou on 2019/4/21 .
 * ref:
 * https://leetcode.com/problems/range-sum-of-bst/
 * Given the root node of a binary search tree, return the sum of values of all nodes
 * with value between L and R (inclusive).

 The binary search tree is guaranteed to have unique values.



 Example 1:

 Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
 Output: 32
 Example 2:

 Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
 Output: 23


 Note:

 The number of nodes in the tree is at most 10000.
 The final answer is guaranteed to be less than 2^31.
 *
 */
public class RangeSumOfBST {
    public int rangeSumBST(TreeNode root, int L, int R) {
        if(root == null){
            return 0;
        }
        int left = rangeSumBST(root.left, L, R);
        int right = rangeSumBST(root.right, L, R);
        if(root.val>=L && root.val<=R){
            return left+right+root.val;
        }else {
            return left+right;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
