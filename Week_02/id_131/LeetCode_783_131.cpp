/* 题目描述 :
 * 给定一个二叉搜索树的根结点 root, 返回树中任意两节点的差的最小值。
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
/* 思路 :
 * 既然是二叉搜索树，根据树的性质，知道root的右子树都是大于它的，左子树都是小于它的
 * 那么如果做中序遍历，标准的做法是得到一个递增的序列
 * 我们就先遍历右根，节点，左根，这样就会得到一个递减的序列。
 * 然后对这个序列相邻相减，取最小值即可。 实现时，可以优化掉这个序列。
 * 在遍历时记录上一个访问的节点值，和当前节点相减，记录下最小值即可。
 * 这样就可以做到时间复杂度O(n)和空间复杂度O(1)
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