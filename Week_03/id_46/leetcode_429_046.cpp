/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> children;

    Node() {}

    Node(int _val, vector<Node*> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
public:
    vector<vector<int>> levelOrder(Node* root) {
        vector<vector<int>> result;
        if(!root) return result;
        queue<Node*> nq;
        nq.push(root);
        while(nq.size()>0){
            vector<int> tempres;
            int nqsize = nq.size();
            for(int i=0; i<nqsize; i++){
                Node* tmp = nq.front();
                nq.pop();
                tempres.push_back(tmp->val);
                for(int j=0; j<tmp->children.size(); j++)
                    nq.push(tmp->children[j]);
            }
            result.push_back(tempres);
        }
        return result;
    }
};
