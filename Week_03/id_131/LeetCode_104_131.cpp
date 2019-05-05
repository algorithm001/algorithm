/*
  997.二叉树的最大深度
  给定一个二叉树，找出其最大深度。

二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

说明: 叶子节点是指没有子节点的节点。

示例：
给定二叉树 [3,9,20,null,null,15,7]
    3
   / \
  9  20
    /  \
   15   7
返回它的最大深度 3 。
*/
/*
  思路：
  
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
	// 递归方法
    int maxDepth(TreeNode* root) {
		if(NULL == root) return 0;
        int left = maxDepth(root->left) + 1;
		int right = maxDepth(root->right) + 1;
		return left > right ? left : right;
    }
};
class Solution2 {
public:
	// 迭代方法
    int maxDepth(TreeNode* root) {
		stack<pair<TreeNode*, int>> dataStack;
		if(root == NULL) return 0;
        pair<TreeNode*, int> p1(root, 1);
		dataStack.push(p1);
		
		int depth = 0;
		while( !dataStack.empty() )
		{
			pair<TreeNode*, int> topPair = dataStack.top();
			root = topPair.first;
			int preDepth = topPair.second;
			dataStack.pop();
			if(root != NULL)
			{
				depth = depth > preDepth ? depth : preDepth;
                pair<TreeNode*, int> pLeft(root->left, preDepth+1);
                pair<TreeNode*, int> pRigth(root->right, preDepth+1);
				dataStack.push(pLeft);
				dataStack.push(pRigth);
			}
		}
		return depth;		
    }
};