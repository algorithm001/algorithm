class Solution {
public:
	int maxDepth(TreeNode* root) {
		if (root == NULL) return 0;

		int maxDepthLeft = 1;
		int maxDepthRight = 1;

		maxDepthLeft += maxDepth(root->left);
		maxDepthRight += maxDepth(root->right);

		return maxDepthLeft > maxDepthRight ? maxDepthLeft : maxDepthRight;
	}
};