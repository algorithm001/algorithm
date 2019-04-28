/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 二叉树节点之间最小距离（二叉搜索树，中序遍历）
 */
int minDiffInBST(struct TreeNode* root) {
    int *nums = (int*)malloc(sizeof(int)*199);
    int k = 0;
    int minValue = 1000;
    struct TreeNode* p = root;
    if (p == NULL) {
        return 0;
    }
    inOrderTarvle(p,&minValue,nums,&k);
    for (int i = 0;i+1 < k;i++) {
        if (nums[i+1] - nums[i] < minValue) {
            minValue = nums[i+1] - nums[i];
        }
    }
    return minValue;
}
void inOrderTarvle(struct TreeNode* root,int *min,int *nums,int *k) {
    if (root == NULL) {
        return NULL;
    }
    
    inOrderTarvle(root->left,min,nums,k);
   // minNode(root,min);
    nums[*k] = root->val;
    (*k)++;
    inOrderTarvle(root->right,min,nums,k);
    
}

//计算差值，并返回最小值
void minNode(struct TreeNode* p,int *minValue) {
    int min = 0,leftMin = 100,rightMin = 100;
    if (p == NULL) {
        return NULL;
    }
    if (p->left != NULL) {
        leftMin = p->val -  p->left->val;
    } 
    if (p->right != NULL) {
        rightMin = p->right->val - p->val;
    }
    min = leftMin < rightMin?leftMin:rightMin;
    if (min < *minValue) {
        *minValue = min;
    }
     
}