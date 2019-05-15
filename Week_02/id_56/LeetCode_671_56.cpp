class Solution {
public:
    vector<int> nums;
    int findSecondMinimumValue(TreeNode* root) {
        storeNums(root);
        set<int> st(nums.begin(), nums.end());
        if(st.size()==1){
            return -1;
        }
        //sort(st.begin(), st.end());
        set<int>::iterator it;
        it = st.begin();
        it++;
        return *it;
    }
    void storeNums(TreeNode* root){
        if(root==NULL){
            return;
        }
        nums.push_back(root->val);
        storeNums(root->left);
        storeNums(root->right);
    }
