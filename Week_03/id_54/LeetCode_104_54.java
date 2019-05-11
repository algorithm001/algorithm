int maxDepth(struct TreeNode* root){
    int left, right;
    if(0 == root) return 0;
    if(0 == root->left && 0 == root->right) return 1;
    
    left = maxDepth(root->left);
    right = maxDepth(root->right);
    
    return 1+(left>right?left:right);
}
