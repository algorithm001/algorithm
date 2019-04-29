class Solution {
public:
    
    int findSecondMinimumValue(TreeNode* root) {
        if(!root->left) return -1;
        int left = (root->left->val == root->val) ? findSecondMinimumValue(root->left) : root->left->val;
        int right = (root->right->val == root->val) ? findSecondMinimumValue(root->right) : root->right->val;
        return ((left == -1 ) || (right == -1)) ? max(left,right) : min(left,right);

    }
};