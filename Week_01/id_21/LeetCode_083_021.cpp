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
    if (head == nullptr || head->next == nullptr) return head;
    ListNode* p1 = head, * temp;
    while (p1->next != nullptr) {
      if (p1->val == p1->next->val) {
        temp = p1->next;
        p1->next = p1->next->next;
        delete temp;
      } else {
        p1 = p1->next;
      }
    }
    return head;
  }
};