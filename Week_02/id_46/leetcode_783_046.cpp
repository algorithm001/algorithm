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
    void midorder(TreeNode* root, vector<int> &nodeset){
        if(!root) return;
        midorder(root->left,nodeset);
        nodeset.push_back(root->val);
        midorder(root->right,nodeset);
        return;
    }
    
    int minDiffInBST(TreeNode* root) {
        vector<int> nodeset;
        midorder(root,nodeset);
        int len = nodeset.size();
        int result = nodeset[len-1] - nodeset[len-2];
        if(len==2) return result;
        for(int i=len-3; i>=0; i--)
            result = min(nodeset[i+1]-nodeset[i],result);
        return result;
    }
};
