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
    int respath=0;
    int longestUnivaluePath(TreeNode* root) {
        if(!root) return 0;
        maxpath(root);
        return respath;
    }
    int maxpath(TreeNode* root){
        int res=0,le=0,ri=0,nextLen;;
        if(!root->left && !root->right) return 0;
        if(root->left){
            nextLen = maxpath(root->left);
            if(root->val==(root->left)->val){
                le = nextLen+1;
                res += le;
            }
            else le=0;
        }
        if(root->right){
            nextLen = maxpath(root->right);
            if(root->val==(root->right)->val){
                ri = nextLen+1;
                res += ri;
            }
            else ri=0;
        }
        respath = max(respath,res);
        return max(le,ri);
    }
};
