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
    int rangeSumBST(TreeNode* root, int L, int R) {
        if(nullptr == root) {
            return 0;
        }
        
        int sum = 0;
        if(root->val >=L && root->val <=R) {
            sum =root->val;
        }
        
        int left = rangeSumBST(root->left, L, R);
        int right = rangeSumBST(root->right, L, R);
        
        return sum + left + right;
    }
};