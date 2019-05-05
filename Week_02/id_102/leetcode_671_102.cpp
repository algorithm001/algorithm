/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 * Link: https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree/comments/
 */
class Solution {
    long secondMinVal = LONG_MAX;
    bool isRoot = true;
    int  rootVal;
    
public:
    int findSecondMinimumValue(TreeNode* root) {
        if (root == NULL) {
            return -1;
        } 
        
        if (isRoot) {
            isRoot = false;
            rootVal = root->val;
        }
        
        /* 寻找比root value大，但是比secondMinVal小的值 ß*/
        if ((long)root->val > rootVal && (long)root->val < secondMinVal) {
            secondMinVal = (long)root->val;    
        }
        
        findSecondMinimumValue(root->left);
        findSecondMinimumValue(root->right);
        
        return secondMinVal != LONG_MAX ? secondMinVal : -1;
    }    
};