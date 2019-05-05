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
        if (!root) return vector<vector<int>>();
        
        vector<vector<int>> res;//定义一个元素为vector<int>的vector对象，用于返回
        queue<Node*> q;//定义一个队列，元素类型为指向node的指针
        q.push(root);//将root节点压入队列
        
        while (!q.empty()) {
            int size = q.size();//保存队列大小，也就是当前层的节点个数
            vector<int> curLevel;//存储每层的结果
            
            for (int i=0; i < size; i++) {//遍历当前层
                Node* tmp = q.front();//取出队头
                q.pop();//将队头元素出队，因为后面不需要它了
                curLevel.push_back(tmp->val);//保存当前节点值
                for (auto n:tmp->children)//将tmp节点的每个子节点入队（先进先出）
                    q.push(n);
            }
            res.push_back(curLevel);//将当前层结果保存到res中
        }
        
        return res;
        
    }
};
