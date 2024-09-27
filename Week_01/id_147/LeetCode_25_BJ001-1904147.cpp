#include <iostream>
#include <vector>

struct ListNode {
    int val;
    ListNode *next;

    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    ListNode *reverseKGroup(ListNode *head, int k) {
        ListNode *pre = nullptr;
        ListNode *next = nullptr;
        ListNode *node = head;
        ListNode *result = nullptr;
        std::vector<ListNode *> nodeList;
        nodeList.resize(k, nullptr);
        int i = 0;
        while (node != nullptr) {
            ListNode *pre = nodeList[0];
            for (i = 0; i < k; ++i) {
                if (node != nullptr) {
                    nodeList[i] = node;
                    node = node->next;
                } else {
                    break;
                };
            }

            if (i != k) {
                if (result == nullptr) {
                    result = nodeList[0];
                }
                break;
            }

            if (result == nullptr) {
                result = nodeList[k - 1];
            }

            if (pre != nullptr) {
                pre->next = nodeList[k - 1];
            }

            for (i = 0; i < k - 1; ++i) {
                nodeList[i + 1]->next = nodeList[i];
            }

            nodeList[0]->next = node;
        }
        return result;
    }
};