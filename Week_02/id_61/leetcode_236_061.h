//
// Created by 贾凯超 on 2019/4/23.
//

#ifndef TASKS_LEETCODE_236_061_H
#define TASKS_LEETCODE_236_061_H

#endif //TASKS_LEETCODE_236_061_H

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;

    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    //#236 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
    //思考：关键点在于三种情况的逻辑分析，如果找到了p，q则会返回p,q如果返回的NULL说明，该树便利完成
    //所以如果left和right都有值说明p和q两个节点分布在左右两边，此时最先满足这个条件的节点就是结果
    //如果只有left或者right说明两个节点在左子树或右子树上此时这个root就应该是结果
    //如果left和right都是空，说明不存在pq
    //但前提条件是节点的值唯一
    TreeNode *lowestCommonAncestor(TreeNode *root, TreeNode *p, TreeNode *q) {
        if (!root || root == p || root == q) {
            return root;
        }
        TreeNode *left = lowestCommonAncestor(root->left, p, q);
        TreeNode *right = lowestCommonAncestor(root->right, p, q);
        if (left && right) {
            return root;
        } else if (left) {
            return left;
        } else if (right) {
            return right;
        }
        return NULL;
    }
};