/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 �㷨

�� getMaxLen Ϊ�ӽڵ� node ����������ͷ�ĳ��ȡ���� node.Left ��������ڵ� node ������ͬ��ֵ��
���ֵ�ͻ��� 1 + getMaxLen���� node.right ���ڵ������Ҳ��һ����

�����Ǽ�����󳤶�ʱ����ѡ�𰸽��Ǹýڵ������������ϵļ�ͷ֮�͡����ǽ���Щ��ѡ�𰸼�¼��������������Ѵ𰸡�
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