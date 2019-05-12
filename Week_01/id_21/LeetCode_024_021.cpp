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
  ListNode* swapPairs(ListNode* head) {
    if (head == nullptr || head->next == nullptr) return head;
    ListNode* dummy = new ListNode(0);
    dummy->next = head;

    ListNode * prev = dummy, * p1, * p2, * next;
    while(prev->next && prev->next->next) {
      p1 = prev->next;
      p2 = p1->next;
      next = p2->next;

      prev->next = p2;
      p2->next = p1;
      p1->next = next;
      prev = p1;
    }

    p1 = dummy->next;
    delete dummy;

    return p1;
  }
};