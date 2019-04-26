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
        if(root == NULL && root->left == NULL)
            return -1;
        long long ans = findmin(root, root->val);
        return ans == 2147483648 ? -1 : ans;
    }
    
    long long findmin(TreeNode* root, int val) {
        if(root) {
            if(root->val > val) {
                return root->val;
            }
            return min(findmin(root->left, val), findmin(root->right, val) );
        }
        return 2147483648;
    }
};


