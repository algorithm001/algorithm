/**
 * @author zhangruihao.zhang
 * @version v1.0.0
 * @since 2019/05/03
 */
public class LeetCode_687_108 {
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
        int maxLen = 0;
        public int longestUnivaluePath(TreeNode root) {
            if(root == null){
                return 0;
            }
            longest(root);
            return maxLen;
        }

        private int longest(TreeNode root){
            if(root == null){
                return 0;
            }
            int leftLen=longest( root.left);
            int rightLen=longest( root.right);
            int leftUnivalueLen = 0;
            int rightUnivalue = 0;
            if(root.left != null && root.left.val == root.val){
                leftUnivalueLen = leftLen + 1;
            }

            if(root.right != null && root.right.val == root.val){
                rightUnivalue = rightLen + 1;
            }

            maxLen = max(maxLen , leftUnivalueLen + rightUnivalue );
            return max(leftUnivalueLen,rightUnivalue);
        }

        private int max(int x,int y){
            return x>y ? x : y;
        }
    }
}
