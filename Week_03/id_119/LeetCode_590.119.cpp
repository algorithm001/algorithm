class Solution {
public:
    vector<int> postorder(Node* root) {
        if(!root) return vector<int>();
        
        vector<int> res;
        stack<Node*> s;
        s.push(root);
        
        while (!s.empty()) {
            Node* tmp = s.top();
            s.pop();
            for (auto p:tmp->children) {
                s.push(p);
            }
            res.push_back(tmp->val);
        }
        reverse(res.begin(), res.end());
        
        return res;
    }
};
