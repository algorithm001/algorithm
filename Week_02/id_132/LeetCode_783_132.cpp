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
    void pre(vector<int>& res,TreeNode* root)
    {
        if(root != NULL)
        {
            
            pre(res,root->left);
            res.push_back(root->val);
            pre(res,root->right);
        }
    }
    int minDiffInBST(TreeNode* root) {
        vector<int> res;
        pre(res,root);
        vector<int> r;
        for(int i=0;i < res.size()-1;i++)
            r.push_back(res[i+1] - res[i]);
        sort(r.begin(),r.end()); 
        return r[0];
    }
    
 
}
