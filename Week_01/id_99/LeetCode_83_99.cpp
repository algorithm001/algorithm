/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* deleteDuplicates(ListNode* head) {
        if (nullptr == head) {
            return nullptr;
        }
        
        ListNode *node = head;
        ListNode *nextNode = head->next;
        
        while (nullptr != head && nullptr != nextNode) {
            if (node->val == nextNode->val) {
                node->next = nextNode->next;
            } else {
                node = nextNode;
            }
            nextNode = node->next;
        }
        return head;
    }
};