class Solution {
public:
    vector<int> preorder(Node* root) {
        if (!root) return vector<int>();
        
        vector<int> res;
        stack<Node*> s;
        s.push(root);
        
        while(!s.empty()) {
            Node* tmp = s.top();
            s.pop();
            res.push_back(tmp->val);
            for (int i=tmp->children.size()-1; i>=0; i--) {
                s.push(tmp->children[i]);
            }
        }
        
        return res;
    }
};
