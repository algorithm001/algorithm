/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 * Link: https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree/
 *                  3
 *
 *              5       1 
 *
 *            6   2   0   8
 *
 *              7   4
 */

class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if (root == NULL || root == p || root == q) {
            return root;
        }
        
        TreeNode *left  = lowestCommonAncestor(root->left, p, q);
        TreeNode *right = lowestCommonAncestor(root->right, p, q);
        
        if (left != NULL && right != NULL) {
            return root;
        }
        
        if (left != NULL) {
            return left;
        }
        
        return right;
    }
};