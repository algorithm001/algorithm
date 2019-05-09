class Solution {
public:
    map<TreeNode*,TreeNode*> mp;
    void findparent(TreeNode* root){
        if(root == NULL)return;
        if(root->left){
            mp[root->left] = root;
            findparent(root->left);
        }
        if(root->right){
            mp[root->right] = root;
            findparent(root->right);
        }
        return;
    }
    
    void dfs(TreeNode* target,int k,set<TreeNode*> vis,vector<int>& res){
        if(vis.find(target)!=vis.end()) return;
        vis.insert(target);
        if(k == 0){res.push_back(target->val);return;}
        if(target->left) dfs(target->left,k-1,vis,res);
        if(target->right) dfs(target->right,k-1,vis,res);
        TreeNode* p = mp[target];
        if(p) dfs(p,k-1,vis,res);
    }
    vector<int> distanceK(TreeNode* root, TreeNode* target, int K) {
        if(root == NULL) return{};
        findparent(root);
        vector<int> res;
        set<TreeNode*> vis;
        dfs(target,K,vis,res);
        return res;
    }
};