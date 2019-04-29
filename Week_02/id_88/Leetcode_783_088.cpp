class Solution 
{
    int pre = INT_MIN;
    int minVal = INT_MAX;
    
public:
    void midOrderTraverse(TreeNode* root)
    {
        if( root == NULL ) return;
        
        midOrderTraverse(root->left);
        
        if(INT_MIN != pre)
        {
            minVal = minVal < (root->val - pre) ? minVal : (root->val - pre);
        }
        pre = root->val;
        
        midOrderTraverse(root->right);
    }

    int minDiffInBST(TreeNode* root)
    {
        if(NULL == root) return 0;        
        midOrderTraverse(root);
        return minVal;
    }
};