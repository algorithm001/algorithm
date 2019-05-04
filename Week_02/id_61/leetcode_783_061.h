//
// Created by 贾凯超 on 2019/4/22.
//

#ifndef TASKS_LEETCODE_783_061_H
#define TASKS_LEETCODE_783_061_H

#endif //TASKS_LEETCODE_783_061_H

using namespace std;
#include <vector>

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;

    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    //#783 给定一个二叉搜索树的根结点 root, 返回树中任意两节点的差的最小值。
    //思考：暴力做法，遍历完后直接操作
    int minDiffInBST(TreeNode* root) {
        vector<int> res;
        orderTree(root, res);
        int minValue = INT_MAX;
        for (int i = 0; i < res.size(); i++) {
            for (int j = i + 1; j < res.size(); j++) {
                minValue = min(minValue,abs(res[j] - res[i]));
            }
        }
        return -1;
    }

    void orderTree(TreeNode *root, vector<int>& temp) {
        if (!root) return;
        temp.push_back(root->val);
        orderTree(root->left, temp);
        orderTree(root->right, temp);
    }
};