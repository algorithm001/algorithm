class Solution {
public:
    int maxDepth(TreeNode* root) {
        if (root == NULL)
			return 0;

		if (root->left != NULL&&root->right != NULL)
		{
			int left = maxDepth(root->left);
			int right = maxDepth(root->right);

			if (left < right)
				return right + 1;
			else
				return left + 1;
		}

		else if (root->left == NULL&&root->right != NULL)
			return maxDepth(root->right) + 1;
		if (root->right == NULL&&root->left != NULL)
			return maxDepth(root->left) + 1;

		else
			return 1;

	}
};
