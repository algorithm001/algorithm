class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if (nullptr == root) {
            return nullptr;
        }
        
        if (root->val == p->val || root->val == q->val) {
            return root;
        }
        
        TreeNode* left = lowestCommonAncestor(root->left, p, q);
        TreeNode* right = lowestCommonAncestor(root->right, p, q);
        if (left != nullptr && right != nullptr) {
            return root;
        } else if (left != nullptr) {
            return left;
        } else {
            return right;
        }
    }
};