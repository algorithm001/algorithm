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
  ListNode* reverseKGroup(ListNode* head, int k) {
    if (head == nullptr || k == 1) return head;
    ListNode* dummy = new ListNode(0);
    dummy->next = head;

    ListNode* begin = dummy, *end, * next;

    while(begin != nullptr) {
      int i;
      end = begin->next;
      for(i = 1; i < k; i++) {
        if (end == nullptr || end->next == nullptr) break;
        end = end->next;
      }
      if (i < k) break;
      next = begin->next;
      reverse(begin, end);
      begin = next;
    }

    return dummy->next;
  }

  /*
   * 此函数为左开右闭区间
   * 直接修改 begin->next 的指向来完成翻转
   */
  void reverse(ListNode* begin, ListNode* end) {
    end = end->next;
    ListNode* p1 = begin->next, * next;

    ListNode* dummy = new ListNode(0);
    dummy->next = end;
    
    while (p1 != end) {
      next = p1->next;
      p1->next = dummy->next;
      dummy->next = p1;
      p1 = next;
    }

    begin->next = dummy->next;
    delete dummy;
  }
};