/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
 
//#关于第687题的思路，采取自下而上的递归策略会更易理解，也就是采用后序遍历的方法。
//另外，切勿被题目定义的函数影响了，应自行定义一个递归的函数，否则容易陷入思维死角。
class Solution {
public:
	int longestUnivaluePath(TreeNode* root) {
		int max = 0;

		getMaxPath(root, max);

		return max;
	}

private:
    //函数的返回值为左右子树的同值路径的边数的最大值，max参数保存的是整棵树最大的同值路径
	int getMaxPath(TreeNode* root, int& max) {
		if (root == NULL) return 0;

		if (root->left == NULL && root->right == NULL)
		{
			return 0;
		}

		//先遍历左子树，再遍历右子树，再处理root，相当于是后序遍历
		int retLeft = getMaxPath(root->left, max);
		int retRight = getMaxPath(root->right, max);

		int left = 0;
		if (root->left != NULL && root->val == root->left->val)
		{
			left = retLeft + 1;
		}

		int right = 0;
		if (root->right != NULL && root->val == root->right->val)
		{
			right = retRight + 1;
		}

		//计算max的时候需要左右值相加
		max = (max > (right + left)) ? max : (right + left);

		return (right > left) ? right : left;
	}
};