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
        /* 首先判断root是否为空，为空直接返回空数组 */
        if (root == NULL) {
            return {};
        }
        
        vector<vector<int>> res;
        queue<Node*> q;
        q.push(root);
        
        while (!q.empty()) {
            /* 用level定义每层的数组 */
            vector<int> level;
            for (int i = q.size(); i > 0; --i) {
                /*  对t的类型进行自动推导 */
                auto t = q.front(); 
                q.pop();
                level.push_back(t->val);
                /* 子节点放入children数组 */
                if (!t->children.empty()) {
                    /*  对t->children进行遍历 */
                    for (auto a : t->children) {
                        q.push(a);    
                    }
                }
            }
            res.push_back(level);
        }
        return res;
    }
};
