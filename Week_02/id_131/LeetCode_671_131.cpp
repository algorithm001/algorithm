/**
 * �������еڶ�С�Ľڵ�.
 * ����һ���ǿ�����Ķ�������ÿ���ڵ㶼������������ÿ���ڵ���ӽڵ�����ֻ��Ϊ 2 �� 0��
 * ���һ���ڵ��������ӽڵ�Ļ�����ô����ڵ��ֵ�����������ӽڵ��ֵ�� 

 * ����������һ��������������Ҫ������нڵ��еĵڶ�С��ֵ������ڶ�С��ֵ�����ڵĻ������ -1 ��
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