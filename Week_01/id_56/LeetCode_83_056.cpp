class Solution {
public:
    ListNode* deleteDuplicates(ListNode* head) {
        if ((head == nullptr) || (head->next == nullptr))  return head;
        ListNode* node = head;
        ListNode* nextNode = node->next;
        while (nextNode != nullptr) {
            if (nextNode->val == node->val) {
                node->next = nextNode->next;
                nextNode->next = nullptr;
            } else node = nextNode;
            nextNode = node->next;
        }
        
        return head;
    }
};
