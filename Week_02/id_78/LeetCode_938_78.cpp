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
    int rangeSumBST(TreeNode* root, int L, int R) {
        int sum = 0;
        std::stack<TreeNode*> s;
        TreeNode* q = root;

        while (!s.empty() || q != NULL) {

            if (q != NULL) {
                s.push(q);
                q = q->left;
            } else {
                q = s.top();
                s.pop();
 
                if (q->val > R) {
                    break;
                }

                if (q->val >= L && q->val <= R) {
                    sum += q->val;
                }

                q = q->right;
            }
        }

        return sum;
    }
};
