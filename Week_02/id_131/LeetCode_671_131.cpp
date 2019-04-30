/**
 * 二叉树中第二小的节点.
 * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。
 * 如果一个节点有两个子节点的话，那么这个节点的值不大于它的子节点的值。 

 * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
 * };
 */
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
    int secondMin = INT_MAX;
    
public:
    int recycle(TreeNode* root, int &minValue)
    {
        if(NULL == root) return -1;
        
        if(root->val > minValue && root->val < secondMin)
        {
            secondMin = root->val;
        }
        
        recycle(root->left, minValue);
        recycle(root->right, minValue);
        return secondMin == INT_MAX ? -1 : secondMin;
    }
    
    int findSecondMinimumValue(TreeNode* root) {
        if(NULL == root) return -1;
        
        return recycle(root, root->val);
        
    }
};