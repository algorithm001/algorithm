//
// Created by 贾凯超 on 2019/4/22.
//

#ifndef TASKS_LEETCODE_671_061_H
#define TASKS_LEETCODE_671_061_H

#endif //TASKS_LEETCODE_671_061_H
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
    //#671 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么这个节点的值不大于它的子节点的值。
    //给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
    //方案1: 先遍历然后找第二小，暴力但是时间复杂度高
    int findSecondMinimumValue(TreeNode *root) {
        vector<int> res;
        orderTree(root, res);
        sort(res.begin(), res.end());
        for (int i = 1; i < res.size(); i++) {
            if (res[i] > res[0]) {
                return res[i];
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