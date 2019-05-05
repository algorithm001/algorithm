/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 * Link: https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/
 */
class Solution {
    int minDiff = INT_MAX;
    TreeNode *prev;
public:
    int minDiffInBST(TreeNode* root) {
        int res = INT_MAX;
        inOrderBST(root);
        return minDiff;
    }

private:
    void inOrderBST(TreeNode* root) {
        if (NULL == root) {
            return;
        }
        
        /* 深度优先遍历 中序遍历 */
        inOrderBST(root->left);
        if (prev != NULL) {
            minDiff = getmin(minDiff, root->val - prev->val);
        } 
        
        prev = root;
        inOrderBST(root->right);
        
        return;
    }

private:
    int getmin(int value1, int value2) {
        return (value1 > value2 ? value2: value1);
    }
};
