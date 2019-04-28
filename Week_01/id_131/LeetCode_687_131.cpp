/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 算法

令 getMaxLen 为从节点 node 延伸出的最长箭头的长度。如果 node.Left 存在且与节点 node 具有相同的值，
则该值就会是 1 + getMaxLen。在 node.right 存在的情况下也是一样。

当我们计算最大长度时，候选答案将是该节点在两个方向上的箭头之和。我们将这些候选答案记录下来，并返回最佳答案。
 */
class Solution {
    
private:
    int maxLen = 0;
    
public:
    int longestUnivaluePath(TreeNode* root) 
    {
        if(NULL == root) return 0;
        getMaxLen(root, root->val);
        return maxLen;
    }
    int getMaxLen(TreeNode* root, int val)
    {
        if(NULL == root) return 0;
        int leftLen = getMaxLen(root->left, root->val);
        int rightLen = getMaxLen(root->right, root->val);
        maxLen = std::max(maxLen, leftLen+rightLen);
        if(root->val == val)
        {
            return std::max(leftLen, rightLen) + 1;
        }
        return 0;
    }
};