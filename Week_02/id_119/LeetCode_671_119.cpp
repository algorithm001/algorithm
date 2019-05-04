/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public: 
    int findSecondMinimumValue(TreeNode* root) {
        long first = root->val, second = LONG_MAX;
        helper(root, first, second);
        return (first == second || second == LONG_MAX) ? -1 : second;
    }
    
    void helper(TreeNode* node, long &first, long &second) {
        if (!node) return;
        if (node->val != first && node->val < second) {
            second = node->val;
        }
        helper(node->left, first, second);
        helper(node->right, first, second);
    }
};
