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
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if(root == NULL || root == p || root == q)
            return root;
        TreeNode *leftroot = lowestCommonAncestor(root->left,p,q); 
        TreeNode *rightroot = lowestCommonAncestor(root->right,p,q); 
        if(leftroot == NULL && rightroot != NULL)
            return rightroot;
        if(leftroot != NULL && rightroot == NULL)
            return leftroot;
        if(leftroot != NULL && rightroot != NULL)
            return root;
        return NULL;
    }
};
