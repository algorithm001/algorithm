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
    void midorder(TreeNode* root, vector<int> &dataset){
        if(!root) return;
        midorder(root->left,dataset);
        dataset.push_back(root->val);
        midorder(root->right,dataset);
        return;
    }
    int rangeSumBST(TreeNode* root, int L, int R) {
        vector<int> dataset;
        int res = 0;
        bool start = false;
        midorder(root, dataset);
        for(int i=0; i<dataset.size(); i++){
            if(dataset[i] == L)
                start = true;
            if(start)
                res += dataset[i];
            if(dataset[i]==R){
                start = false;
                break;
            } 
        }
        return res;
    }
};
