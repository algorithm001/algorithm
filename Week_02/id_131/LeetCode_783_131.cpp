/* ��Ŀ���� :
 * ����һ�������������ĸ���� root, ���������������ڵ�Ĳ����Сֵ��
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
/* ˼· :
 * ��Ȼ�Ƕ����������������������ʣ�֪��root�����������Ǵ������ģ�����������С������
 * ��ô����������������׼�������ǵõ�һ������������
 * ���Ǿ��ȱ����Ҹ����ڵ㣬����������ͻ�õ�һ���ݼ������С�
 * Ȼ�������������������ȡ��Сֵ���ɡ� ʵ��ʱ�������Ż���������С�
 * �ڱ���ʱ��¼��һ�����ʵĽڵ�ֵ���͵�ǰ�ڵ��������¼����Сֵ���ɡ�
 * �����Ϳ�������ʱ�临�Ӷ�O(n)�Ϳռ临�Ӷ�O(1)
*/
class Solution 
{
    int pre = INT_MIN;
    int minVal = INT_MAX;
    
public:
    void recycle(TreeNode* root)
    {
        if( root == NULL ) return;
        
        recycle(root->left);
        
        if(INT_MIN != pre)
        {
            minVal = minVal < (root->val - pre) ? minVal : (root->val - pre);
        }
        pre = root->val;
        
        recycle(root->right);
    }

    int minDiffInBST(TreeNode* root)
    {
        if(NULL == root) return 0;        
        recycle(root);
        return minVal;
    }
};