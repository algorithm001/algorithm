/*
解题思路：

*/
class Solution {
public:
	int findSecondMinimumValue(TreeNode* root) {
		if (root == NULL || root->left == NULL || root->right == NULL) return -1;

		//如果根节点的值不等于左节点值并且不等于右节点的值，返回左右节点的最小值
		if (root->val != root->right->val && root->val != root->left->val)
		{
			return (root->left->val < root->right->val) ? root->left->val : root->right->val;
		}

		int minLeft, minRight = 0;
		if (root->left->val == root->val && root->right->val == root->val)
		{
			minLeft = findSecondMinimumValue(root->left);
			minRight = findSecondMinimumValue(root->right);
			if (minLeft != -1 && minRight != -1)
			{
				return (minRight > minLeft) ? minLeft : minRight;
			}
			else if (minLeft == -1)
			{
				return minRight;
			}
			else
			{
				return minLeft;
			}

		}

		if (root->val == root->left->val)
		{
			minLeft = findSecondMinimumValue(root->left);
			if (minLeft == -1)
			{
				return root->right->val;
			}
			else
			{
				return (root->right->val < minLeft) ? root->right->val : minLeft;
			}
		}

		if (root->val == root->right->val)
		{
			minRight = findSecondMinimumValue(root->right);
			if (minRight == -1)
			{
				return root->left->val;
			}
			else
			{
				return (root->left->val < minRight) ? root->left->val : minRight;
			}
		}

		return -1;

	}
};