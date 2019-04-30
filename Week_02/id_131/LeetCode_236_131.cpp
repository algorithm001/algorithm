/* ��Ŀ���� :
 * 236. �������������������
 
 ����һ��������, �ҵ�����������ָ���ڵ������������ȡ�

 �ٶȰٿ�������������ȵĶ���Ϊ���������и��� T ��������� p��q��
 ����������ȱ�ʾΪһ����� x������ x �� p��q �������� x ����Ⱦ����ܴ�
 ��һ���ڵ�Ҳ���������Լ������ȣ�����
*/

/*]
  ˼·
  1. �����ڵ�Ĺ�������һ���ڴӸ��ڵ㣬���������ڵ��·���ϡ�
  2. �����󹫹������е�����������ȣ���ô��ͬʱ������������·
     ���ϵ�����ڵ���Զ�Ľڵ�(�����������)��
  3. �����㷨��:��p�ڵ�·����q�ڵ�·������·�������һ����ͬ �Ľڵ㡣
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
public:
    void preorder(TreeNode *node,TreeNode *search, 
                  std::vector<TreeNode*> &path,
                  std::vector<TreeNode*> &result,
                  int &finish)
    {
        if(!node || finish)
        {
            return; // ��nodeΪ�ջ����ҵ�search �ڵ�ֱ�ӷ��أ���������
        }
        path.push_back(node); // �������ʱ�����ڵ�ѹ��pathջ
        if(node == search)
        {
            finish = 1;
            result = path;
        }
        preorder(node->left,search,path,result,finish);
        preorder(node->right,search,path,result,finish);
        path.pop_back(); // ��������nodeʱ����node�ڵ㵯��pathջ
    }
    
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) 
    {
        std::vector<TreeNode*> path; // ���������õ���ʱջ
        std::vector<TreeNode*> node_p_path; // ����P�ڵ�·��
        std::vector<TreeNode*> node_q_path; // ����q�ڵ�·��
        
        int finish = 0; // ��¼�Ƿ��������
        preorder(root, p,path,node_p_path,finish);
        
        path.clear(); // ���path��finish,����q�ڵ�·��
        finish = 0;
        preorder(root, q, path,node_q_path,finish);
        
        int path_len = 0;
        if(node_p_path.size() < node_q_path.size())
        {
            path_len = node_p_path.size();
        }
        else
        {
            path_len = node_q_path.size();
        }
        
        TreeNode * result = 0;
        for (int i = 0; i < path_len; i++)
        {
            if(node_p_path[i] == node_q_path[i])
            {
                result = node_p_path[i];
            }//�����ͬ�Ľڵ�Ϊ��������ڵ�
        }
        return result;
    }
};