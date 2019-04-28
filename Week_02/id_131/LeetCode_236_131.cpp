/* 题目描述 :
 * 236. 二叉树的最近公共祖先
 
 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，
 最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大
 （一个节点也可以是它自己的祖先）。”
*/

/*]
  思路
  1. 两个节点的公共祖先一定在从根节点，至这两个节点的路径上。
  2. 由于求公共祖先中的最近公共祖先，那么即同时出现在这两条路
     径上的离根节点最远的节点(或离两个最近)。
  3. 最终算法即:求p节点路径，q节点路径，两路径上最后一个相同 的节点。
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
            return; // 当node为空或已找到search 节点直接返回，结束搜索
        }
        path.push_back(node); // 先序遍历时，将节点压入path栈
        if(node == search)
        {
            finish = 1;
            result = path;
        }
        preorder(node->left,search,path,result,finish);
        preorder(node->right,search,path,result,finish);
        path.pop_back(); // 结束遍历node时，将node节点弹出path栈
    }
    
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) 
    {
        std::vector<TreeNode*> path; // 申明遍历用的临时栈
        std::vector<TreeNode*> node_p_path; // 储存P节点路径
        std::vector<TreeNode*> node_q_path; // 储存q节点路径
        
        int finish = 0; // 记录是否完成搜索
        preorder(root, p,path,node_p_path,finish);
        
        path.clear(); // 清空path，finish,计算q节点路径
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
            }//最后相同的节点为最近公共节点
        }
        return result;
    }
};