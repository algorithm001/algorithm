#include <iostream>
#include <vector>
#include <unordered_map>
#include <unordered_set>

using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;

    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    vector<int> distanceK(TreeNode *root, TreeNode *target, int K) {
        unordered_map<TreeNode *, TreeNode *> parentNodeMap;
        setParentNode(root, parentNodeMap);
        unordered_set<TreeNode *> ignoreNodeSet;
        vector<int> result;
        distanceKInternal(target, K, parentNodeMap, ignoreNodeSet, result);
        return result;
    }

    void setParentNode(TreeNode *node, unordered_map<TreeNode *, TreeNode *> &parentNodeMap) {
        if (node == nullptr) {
            return;
        }

        if (node->left != nullptr) {
            parentNodeMap[node->left] = node;
            setParentNode(node->left, parentNodeMap);
        }

        if (node->right != nullptr) {
            parentNodeMap[node->right] = node;
            setParentNode(node->right, parentNodeMap);
        }
    }

    void distanceKInternal(TreeNode *node, int k, unordered_map<TreeNode *, TreeNode *> &parentNodeMap,
                           unordered_set<TreeNode *> &ignoreNodeSet,
                           vector<int> &result) {
        if (node == nullptr || k < 0) {
            return;
        }

        if (ignoreNodeSet.find(node) != ignoreNodeSet.end()) {
            return;
        }

        ignoreNodeSet.emplace(node);
        if (k == 0) {
            result.emplace_back(node->val);
            return;
        }

        if (node->left != nullptr) {
            distanceKInternal(node->left, k - 1, parentNodeMap, ignoreNodeSet, result);
        }

        if (node->right != nullptr) {
            distanceKInternal(node->right, k - 1, parentNodeMap, ignoreNodeSet, result);
        }

        const auto &iter = parentNodeMap.find(node);
        if (iter != parentNodeMap.end()) {
            distanceKInternal(iter->second, k - 1, parentNodeMap, ignoreNodeSet, result);
        }
    }
};

int main(int argc, char **argv) {
    TreeNode *node1 = new TreeNode(3);
    TreeNode *node2 = new TreeNode(5);
    TreeNode *node3 = new TreeNode(1);
    TreeNode *node4 = new TreeNode(6);
    TreeNode *node5 = new TreeNode(2);
    TreeNode *node6 = new TreeNode(0);
    TreeNode *node7 = new TreeNode(8);
    TreeNode *node8 = new TreeNode(7);
    TreeNode *node9 = new TreeNode(4);
    node1->left = node2;
    node1->right = node3;
    node2->left = node4;
    node2->right = node5;
    node3->left = node6;
    node3->right = node7;
    node5->left = node8;
    node5->right = node9;
    Solution solution;
    vector<int> result = solution.distanceK(node1, node2, 2);
    for (auto val : result) {
        std::cout << val << std::endl;
    }
    return 0;
}