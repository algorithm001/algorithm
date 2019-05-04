class Solution {
public:
	int rangeSumBST(TreeNode* root, int L, int R) {
		int sum = 0;

		if (root == NULL) return 0;

		sum = rangeSumBST(root->left, L, R);

		if (root->val >= L && root->val <=R)
		{
			sum += root->val;
		}

		int temp = rangeSumBST(root->right, L, R);

		sum += temp;

		return sum;
	}
};